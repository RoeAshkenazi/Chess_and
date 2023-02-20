package com.roe.chess;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class OnlineKey extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Button create_game;
    private Button join_game;
    private Button start_game;

    public String joinBord;

    private TextView key;

    private EditText enter_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinekey);

        find();

        onClicks();
    }

    private void onClicks() {

        start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(join_game.getVisibility() == View.VISIBLE)
                {
                    String code = enter_key.getText().toString();
                    int i = Integer.parseInt(code);

                    Intent newGame = new Intent(OnlineKey.this, GameActivity.class);
                    newGame.putExtra("typeOfGame","online");
                    newGame.putExtra("player","join");
                    newGame.putExtra("gameCode",i+"");
                    startActivity(newGame);
                }

                else
                {
                    String code = key.getText().toString();
                    int i = Integer.parseInt(code);
                    mDatabase.child("games").child(i+"").setValue("rnbqkbnr@pppppppp@00000000@00000000@00000000@00000000@PPPPPPPP@RNBKQBNR@w");
                    //create game and send to firebase
                    Intent newGame = new Intent(OnlineKey.this, GameActivity.class);
                    newGame.putExtra("typeOfGame","online");
                    newGame.putExtra("player","create");
                    newGame.putExtra("gameCode",i+"");
                    startActivity(newGame);
                }
            }
        });

        create_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                join_game.setVisibility(View.INVISIBLE);

                Random r = new Random(System.currentTimeMillis());
                int i = r.nextInt(10)+1;
                i=(i*i)%10;
                String s = String.valueOf(i);

                for(int j=0;j<5;j++) {
                    i = r.nextInt(10)+1;
                    i = (i * i) % 10;
                    s = s.concat(String.valueOf(i));
                }

                key.setText(s);
                key.setVisibility(View.VISIBLE);
                start_game.setVisibility(View.VISIBLE);
            }
        });

        join_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                create_game.setVisibility(View.INVISIBLE);
                enter_key.setVisibility(View.VISIBLE);
                start_game.setVisibility(View.VISIBLE);
            }
        });
    }

    private void find() {

        mDatabase = FirebaseDatabase.getInstance().getReference();
        create_game  = findViewById(R.id.online_create_game);
        join_game = findViewById(R.id.online_join);
        start_game = findViewById(R.id.online_Start);
        key = findViewById(R.id.online_txt_generate_key);
        enter_key = findViewById(R.id.online_etxt_key);

    }
}
