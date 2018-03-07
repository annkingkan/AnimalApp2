package com.kingkan.cs58.sdu.animalapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    //ประกาศตัวแปล
    Button btn1,btn2,btn3,btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer; //เล่นไฟล์เสียง
    int questionCount= 1; //เก็บข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>(); //qID แรนดอมโจทย์
    String answer;
    int score = 0; //รวมคะแนน

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);//ผูกอีลิเม้นกับตัวแปลบนจาวา

        //แสดงคำถาม
        for (int i = 1; i <= questionCount; i++) {
            qID.add(i);


        }
        Collections.shuffle(qID); //qIDกำหนดคำถามแบบสุ่ม
        setQuestion(qID.remove(0));

    }//onCreate

    private void setQuestion(int qID) { //กำหนดข้อคำถามและเฉลยในแต่ละข้อ
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>(); //แรนดอมชอยส์
            choice.add("นก");
            choice.add("แมว");
            choice.add("หมู");
            choice.add("แกะ");//สัตว์ที่จะให้แสดง
            Collections.shuffle(choice);//กำหนดให้แรนดอม
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));
        }


    }//end setQuestion

    public void playSound(View view) {
        mediaPlayer.start();

    }//end playSound methot


}//class
