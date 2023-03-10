package com.roe.chess;

import com.roe.chess.src.piece.Piece;

import android.graphics.Color;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.util.Log;

import com.roe.chess.R;


public class GridAdapter extends BaseAdapter {

    private static final String TAG = "GridAdapter";

    private Context context;
    Piece[][] board;

    public int start = -1;
    public int end = -1;

    public void setData(Piece[][] newPiece){
        this.board = newPiece;
    }

    private Integer[] blackPiece = {
            R.drawable.bb,
            R.drawable.bq,
            R.drawable.bn,
            R.drawable.bp,
            R.drawable.bk,
            R.drawable.br
    };
//
//    private Integer[] whitePiece = {
//            R.drawable.wb,
//            R.drawable.wk,
//            R.drawable.wn,
//            R.drawable.wp,
//            R.drawable.wq,
//            R.drawable.wr
//    };

    public GridAdapter(Context c, Piece[][]newBoard) {
        this.context = c;
        this.board = newBoard;
    }

    public int getCount() {  return 64; }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iView;

        iView = new ImageView(context);
        int size = parent.getWidth()/8;

        int x = (position % 8);
        int y = 7-(position / 8);

        if (x % 2 == 0) {
            if(y % 2 == 0){
                iView.setBackgroundColor(Color.parseColor("#513414"));
            } else {
                iView.setBackgroundColor(Color.parseColor("#d6a671"));
            }
        } else {
            if(y % 2 == 1){
                iView.setBackgroundColor(Color.parseColor("#513414"));
            } else {
                iView.setBackgroundColor(Color.parseColor("#d6a671"));
            }
        }

        String pieceName = "";
        if(board[x][y] != null){
            pieceName = (board[x][y].toString()).toLowerCase();
        }

        if(!(pieceName.equals(""))) {
            iView.setImageResource(context.getResources().getIdentifier(pieceName, "drawable", context.getPackageName()));
        }

        iView.setLayoutParams(new GridView.LayoutParams(size,size));

        Log.i(TAG,"MOVING");

        return iView;
    }
}
