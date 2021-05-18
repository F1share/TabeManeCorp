package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ReadFirebaseSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_firebase_sample);

        String word_1 = "ここに入れたい";
        ((TextView)findViewById(R.id.tv01)).setText(word_1);
    }
}