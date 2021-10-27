package com.omer.packeto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;

public class Main_quiz extends AppCompatActivity {

    TextView content, questionNr, t1, t2, ticks, crosses;
    Button b1, b2, b3, b4, nextbtn, prevbtn;
    ArrayList<questions> thelist = new ArrayList<>();

    int checkmate = 0;
    int correctanswr = 0;
    int wronganswr = 0;


    public final String shared_prefs = "shared_prefs";
    public  final String highscorePF = "highscorePF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        content = findViewById(R.id.Question_Content);
        questionNr = findViewById(R.id.Question_number);
        b1 = findViewById(R.id.answer1);
        b2 = findViewById(R.id.answer2);
        b3 = findViewById(R.id.answer3);
        b4 = findViewById(R.id.answer4);
        t1 = findViewById(R.id.tick1);
        t2 = findViewById(R.id.tick2);
        ticks = findViewById(R.id.tick1_sayisi);
        crosses = findViewById(R.id.tick2_sayisi);
        nextbtn = findViewById(R.id.button_next);
        prevbtn = findViewById(R.id.button_previous);

        thelist.add(new questions("How many states make up the United States of America?", 1, "60", "40", "50", "45", "50"));
        thelist.add(new questions("What colour are the four stars on the flag of New Zealand?", 2, "Red", "Blue", "Green", "White", "Red"));
        thelist.add(new questions("Which German football team won the Champions League in 2013?", 3, "Bayern Munich", "Borussia Dortmund", "Schalke", "Werder Bremen", "Bayern Munich"));
        thelist.add(new questions("In which country was Adolf Hitler born?", 4, "Germany", "Italy", "Austria", "Holland", "Austria"));
        thelist.add(new questions("In which sport may a player score a birdie, eagle or albatross?", 5, "Cricket", "Baseball", "Handball", "Golf", "Golf"));
        thelist.add(new questions("In the popular video game series, what type of animal is Sonic?", 6, "He is an imaginary character", "Mouse", "Squirrel", "Hedgehog", "Hedgehog"));
        thelist.add(new questions("What is a ‘frag’?", 7, "A Hand Grenade", "Score", "Pistol", "Knife", "A Hand Grenade"));
        thelist.add(new questions("In /Call of Duty: Black Ops II/, who is the main playable character in the 1980s missions?", 8, "Harper", "Woods", "Briggs", "Alex Mason", "Alex Mason"));
        thelist.add(new questions("What is the world's longest river?", 9, "Mississippi", "Yangtze", "Amazon", "Nile", "Nile"));
        thelist.add(new questions("How many hours did i spend to create this app?", 10, "3", "10", "15", "20", "3"));

        loadquestions(checkmate);

    }


    @SuppressLint("SetTextI18n")
    public void loadquestions(int n) {
        questions q = thelist.get(n);
        questionNr.setText("" + q.getQuestion_number());
        content.setText("" + q.getQuestion_content());

        b1.setText("" + q.getAnswr1());
        b2.setText("" + q.getAnswr2());
        b3.setText("" + q.getAnswr3());
        b4.setText("" + q.getAnswr4());
        ticks.setText("" + correctanswr);
        crosses.setText("" + wronganswr);

        if (checkmate == 0) {
            prevbtn.setText("Home" + "");
        } else
            prevbtn.setText("Previous" + "");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b1.getText().equals(q.getCorrectornot())) {
                    b1.setBackgroundColor(0xFF00FF00);//green
                    correctanswr++;
                    b4.setClickable(false);
                    b2.setClickable(false);
                    b3.setClickable(false);

                } else {

                    if (b2.getText().equals(q.getCorrectornot())) {
                        b2.setBackgroundColor(0xFF00FF00);
                    } else if (b3.getText().equals(q.getCorrectornot())) {
                        b3.setBackgroundColor(0xff00ff00);
                    } else {

                        b4.setBackgroundColor(0xff00ff00);
                    }

                    lockTheButtons();


                    b1.setBackgroundColor(0xFFFF0000);//red
                    wronganswr++;
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b2.getText().equals(q.getCorrectornot())) {
                    b2.setBackgroundColor(0xFF00FF00);
                    correctanswr++;
                    b1.setClickable(false);
                    b4.setClickable(false);
                    b3.setClickable(false);
                } else {
                    if (b1.getText().equals(q.getCorrectornot())) {
                        b1.setBackgroundColor(0xFF00FF00);
                    } else if (b3.getText().equals(q.getCorrectornot())) {
                        b3.setBackgroundColor(0xff00ff00);
                    } else {
                        b4.setBackgroundColor(0xff00ff00);
                    }

                    lockTheButtons();

                    b2.setBackgroundColor(0xFFFF0000);//red
                    wronganswr++;
                }


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b3.getText().equals(q.getCorrectornot())) {
                    b3.setBackgroundColor(0xFF00FF00);
                    correctanswr++;
                    b1.setClickable(false);
                    b2.setClickable(false);
                    b4.setClickable(false);
                } else {
                    if (b2.getText().equals(q.getCorrectornot())) {
                        b2.setBackgroundColor(0xFF00FF00);
                    } else if (b1.getText().equals(q.getCorrectornot())) {
                        b1.setBackgroundColor(0xff00ff00);
                    } else {
                        b4.setBackgroundColor(0xff00ff00);
                    }

                    lockTheButtons();

                    b3.setBackgroundColor(0xFFFF0000);//red
                    wronganswr++;
                }


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b4.getText().equals(q.getCorrectornot())) {
                    b4.setBackgroundColor(0xFF00FF00);
                    correctanswr++;
                    b1.setClickable(false);
                    b2.setClickable(false);
                    b3.setClickable(false);
                } else {
                    if (b1.getText().equals(q.getCorrectornot())) {
                        b1.setBackgroundColor(0xFF00FF00);
                    } else if (b3.getText().equals(q.getCorrectornot())) {
                        b3.setBackgroundColor(0xff00ff00);
                    } else {
                        b2.setBackgroundColor(0xff00ff00);
                    }

                    lockTheButtons();

                    b4.setBackgroundColor(0xFFFF0000);//red
                    wronganswr++;
                }


            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkmate == 0) {
                    prevbtn.setText("Home" + "");
                    Intent yenice = new Intent(getApplicationContext(), Main_welcome.class);
                    startActivity(yenice);
                } else {

                    resetAndLoad(checkmate - 1);
                }
            }
        });


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetAndLoad(checkmate + 1);

            }

        });


    }

    private void lockTheButtons() {
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        b4.setClickable(false);
    }

    public void resetAndLoad(int abc) {
        this.checkmate = abc;
        if (checkmate == 10) {
            savehighscore();


            Intent yeni = new Intent(this, Main_welcome.class);
            startActivity(yeni);
        } else {
            b1.setBackgroundColor(0xFFFF8800); // default colorumuz
            b2.setBackgroundColor(0xFFFF8800);
            b3.setBackgroundColor(0xFFFF8800);
            b4.setBackgroundColor(0xFFFF8800);
            b1.setClickable(true);
            b2.setClickable(true);
            b3.setClickable(true);
            b4.setClickable(true);
            loadquestions(checkmate);
        }
    }

    private void savehighscore() {
        SharedPreferences sharedPreferences = getSharedPreferences(shared_prefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(highscorePF, correctanswr);
        editor.apply();
    }
}


