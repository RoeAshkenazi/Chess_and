package com.roe.chess.src.player;

import android.util.Log;

import com.roe.chess.src.piece.Bishop;
import com.roe.chess.src.piece.King;
import com.roe.chess.src.piece.Knight;
import com.roe.chess.src.piece.Pawn;
import com.roe.chess.src.piece.Piece;
import com.roe.chess.src.piece.Queen;
import com.roe.chess.src.piece.Rook;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
	private  final long serialVersionUID = 1;

	public char color;
	public ArrayList<Piece> living;
	public ArrayList<Piece> dead;
	public King k;
	private int index;
	
	/**
	   * Creates the Player, sets default values and the color
	   * 
	   * @param c A letter representing the color of the player
	   */
	public Player(char c, ArrayList<Piece> newDead, ArrayList<Piece> newLivi) {
		color = c;
		this.living = new ArrayList<Piece>(newLivi);
		this.dead = new ArrayList<Piece>(newDead);
//		this.k = new King(newK, c);
	}

	public Player(char c) {
		color = c;
		living = new ArrayList<Piece>();
		dead = new ArrayList<Piece>();
	}
	
	/**
	   * Removes a piece from the living and places it in the dead
	   * 
	   * @param p The piece to be killed
	   */
	public void kill(Piece p) {
		dead.add(p);
		living.remove(p);
	}
	
	/**
	   * Deletes the old piece and replaces it with the requested piece
	   * 
	   * @param p The piece being promoted
	   * @param type A char representing the type of piece to be upgraded to
	   * @return Piece The new piece that is being replaced
	   */
	public Piece promote(Piece p, char type) {
		dead.add(p);
		living.remove(p);

		for(Piece tmpP : dead){
			Log.i("HERE",tmpP.toString());
		}
		Log.i("Type:", ""+type);

		switch(type){
			case 'Q':
				for(Piece tmpP : dead){
					Log.i("Queen DEAD",tmpP.toString());
					if(tmpP.toString().equals(color+"Q")){
						Log.i("Inside Queen", ""+color+"Q");
						p = new Queen(color);
						living.add(p);
						dead.remove(tmpP);
						return p;
					}
				}
				p = new Pawn(color);
				living.add(p);
				return p;
				
			case 'B':
				for(Piece tmpP : dead) {
					Log.i("Bishop DEAD",tmpP.toString());
					if (tmpP.toString().contains(color + "B")) {
						Log.i("Inside Bishop", ""+color+"B");
						p = new Bishop(color);
						living.add(p);
						dead.remove(tmpP);
						return p;
					}
				}
				p = new Pawn(color);
				living.add(p);
				return p;
				
			case 'N':
				for(Piece tmpP : dead) {
					Log.i("Knight DEAD",tmpP.toString());
					if (tmpP.toString().contains(color + "N")) {
						Log.i("Inside Knight", ""+color+"N");
						p = new Knight(color);
						living.add(p);
						dead.remove(tmpP);
						return p;
					}
				}
				p = new Pawn(color);
				living.add(p);
				return p;

			case 'R':
				for(Piece tmpP : dead){
					Log.i("Rook DEAD",tmpP.toString());
					if(tmpP.toString().equals(color+"R")){
						Log.i("Inside Rook", ""+color+"R");
						p = new Rook(color);
						living.add(p);
						dead.remove(tmpP);
						return p;
					}
				}
				p = new Pawn(color);
				living.add(p);
				return p;

			default:
				p = new Pawn(color);
				living.add(p);
				return p;
				
		}
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
