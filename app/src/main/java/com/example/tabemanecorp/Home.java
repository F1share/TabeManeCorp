package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        findViewById(R.id.btnFrame).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home.this,Frame.class);
//                startActivity(intent);
//            }
//        });

        // クーポンボタンを押したとき
        findViewById(R.id.btncoupon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Coupon.class);
                startActivity(intent);
            }
        });

        // リアルタイムセールを押したとき
        findViewById(R.id.btnsale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,RealTimeSale.class);
                startActivity(intent);
            }
        });

        // 広告設計ボタンを押したとき
        findViewById(R.id.btnadv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Advertise.class);
                startActivity(intent);
            }
        });

        // アンケート設定ボタンを押したとき
        findViewById(R.id.btnquest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Questionnaire.class);
                startActivity(intent);
            }
        });

        // ログアウトボタンを押したとき
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}