package com.omer.packeto;


public class questions {
    String Question_content;
    int question_number;
    String answr1;
    String answr2;
    String answr3;
    String answr4;


    String correctornot;

    public questions(String question_content, int question_number, String answr1, String answr2, String answr3, String answr4, String correctornot) {
        Question_content = question_content;
        this.question_number = question_number;
        this.answr1 = answr1;
        this.answr2 = answr2;
        this.answr3 = answr3;
        this.answr4 = answr4;
        this.correctornot = correctornot;
    }

    public String getQuestion_content() {
        return Question_content;
    }


    public int getQuestion_number() {
        return question_number;
    }


    public String getAnswr1() {
        return answr1;
    }


    public String getAnswr2() {
        return answr2;
    }


    public String getAnswr3() {
        return answr3;
    }


    public String getAnswr4() {
        return answr4;
    }


    public String getCorrectornot() {
        return correctornot;
    }



}