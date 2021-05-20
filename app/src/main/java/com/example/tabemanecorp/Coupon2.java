package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Coupon2 extends AppCompatActivity {

//    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    Intent intent = getIntent() ;
//    int food_id = intent.getIntExtra("food_id", 0) ;
//    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon2);

        // ホームボタン（上部）を押したとき
        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 戻るボタンを押したとき
        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon2.this, Coupon.class);
                startActivity(intent);
//                Intent intent00 = new Intent() ;
//                intent00.putExtra("INPUT_STRING", edit.getText().toString());
//                setResult(RESULT_OK, intent00);
//                finish();
            }
        });

        // ホームボタン（右下）を押したとき
        findViewById(R.id.btnhome2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 画面にテキストを表示
        TextView tvID = findViewById(R.id.tvId);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvRate = findViewById(R.id.tvRate);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvOcc = findViewById(R.id.tvOcc);
        String messageId = "・登録番号　　　　： " ;
        String messageType = "・対象食材　　　　： " ;
        String messageRate = "・クーポンの種類　： " ;
        String messageGender = "・性別　　　　　　： " ;
        String messageAge = "・年代　　　　　　： " ;
        String messageOcc = "・職業　　　　　　： " ;
//        String messageId = "・登録番号　　　　： " + food_id ;
//        String messageType = "・対象食材　　　　： " + kind ;
//        String messageRate = "・クーポンの種類　： " + type ;
//        String messageGender = "・性別　　　　　　： " + gender ;
//        String messageAge = "・年代　　　　　　： " + age ;
//        String messageOcc = "・職業　　　　　　： " + occupation ;
        tvID.setText(messageId);
        tvType.setText(messageType);
        tvRate.setText(messageRate);
        tvGender.setText(messageGender);
        tvAge.setText(messageAge);
        tvOcc.setText(messageOcc);

    }
}