package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Coupon2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon2);

        // Data from Coupon.java
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String kind = intent.getStringExtra("Food");
        String type = intent.getStringExtra("Type");
        String gender = intent.getStringExtra("Gender");
        String age = intent.getStringExtra("Age");
        String occupation = intent.getStringExtra("Occupation");
        String date = intent.getStringExtra("Date");

        // ホームボタン（上部）を押したとき
        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon2.this, Home.class);
                startActivity(intent);
            }
        });

        // 戻るボタンを押したとき
        findViewById(R.id.btnback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ret = new Intent();
                setResult(RESULT_OK, intent_ret);
                finish();
            }
        });

        // ホームボタン（右下）を押したとき
        findViewById(R.id.btnhome2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon2.this, Home.class);
                startActivity(intent);
            }
        });

        // 画面に登録内容を表示
        TextView tvID = findViewById(R.id.tvId);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvRate = findViewById(R.id.tvRate);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvOcc = findViewById(R.id.tvOcc);
        TextView tvDate = findViewById(R.id.tvDate);
        String messageId = "・クーポンの名前 ： " ;
        String messageName = name ;
        String messageType = "・対象食材　　　 ： " + kind ;
        String messageRate = "・クーポンの種類 ： " + type ;
        String messageGender = "・性別　　　　　 ： " + gender ;
        String messageAge = "・年代　　　　　 ： " + age ;
        String messageOcc = "・職業　　　　　 ： " + occupation ;
        String messageDate = "・クーポン期限　 ： " + date ;
        tvID.setText(messageId);
        tvName.setText(messageName);
        tvType.setText(messageType);
        tvRate.setText(messageRate);
        tvGender.setText(messageGender);
        tvAge.setText(messageAge);
        tvOcc.setText(messageOcc);
        tvDate.setText(messageDate);

    }
}