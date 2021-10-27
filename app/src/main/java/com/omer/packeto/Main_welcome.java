package com.omer.packeto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_welcome extends AppCompatActivity {

    Button buton_strt;


    int highscore;
    TextView highscoretv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        loadhighscore();

        buton_strt = findViewById(R.id.button_startquiz);
        highscoretv = findViewById(R.id.high_score);
        highscoretv.setText(highscore + "");

        buton_strt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(getApplicationContext(), Main_quiz.class);
                startActivity(int1);
            }
        });


    }

    private void loadhighscore() {
        Main_quiz main_quiz = new Main_quiz();

        SharedPreferences sharedPreferences = getSharedPreferences(main_quiz.shared_prefs ,MODE_PRIVATE);
        highscore = sharedPreferences.getInt(main_quiz.highscorePF,0);

    }


}