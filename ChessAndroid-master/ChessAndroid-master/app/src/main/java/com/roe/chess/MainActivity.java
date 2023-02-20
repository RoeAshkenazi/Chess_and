package com.roe.chess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

        private ImageButton btnNewGame, btnOnLineGame,btnQuit, btnHistory;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewGame = (ImageButton) findViewById(R.id.gameStart);
        btnQuit = (ImageButton)findViewById(R.id.quit);
        btnHistory  = (ImageButton)findViewById(R.id.listGame);
        btnOnLineGame = (ImageButton)findViewById(R.id.gameOnline);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(MainActivity.this, GameActivity.class);
                newGame.putExtra("typeOfGame","offline");
                startActivity(newGame);
            }
        });

        btnOnLineGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(MainActivity.this, OnlineKey.class);
                startActivity(newGame);
            }
        });


        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newGame = new Intent(MainActivity.this, ReplayActivity.class);
                startActivity(newGame);
            }
        });

    }

}
