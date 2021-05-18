package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Coupon extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon.this,Home.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.completed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon.this,Coupon2.class);
                startActivity(intent);
            }
        });


        Spinner bSpinner=findViewById(R.id.bSpinner);
        bSpinner.setOnItemSelectedListener(this);

        Spinner cSpinner=findViewById(R.id.cSpinner);
        cSpinner.setOnItemSelectedListener(this);

        Spinner dSpinner=findViewById(R.id.dSpinner);
        dSpinner.setOnItemSelectedListener(this);

        Spinner eSpinner=findViewById(R.id.eSpinner);
        eSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
