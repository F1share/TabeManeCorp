package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class Coupon extends AppCompatActivity {

    // ++++++++++++++++++++++++++++++++++++++++++
    // Setting
    private static  final int REQUEST_CODE = 1;
    String rate = null ;
    
    String rate_num = null ;
    String kind = null ;
    String gender = null ;
    String age = null ;
    String occupation = null ;
    String amessage = null ;
    String bmessage = null ;
    String cmessage = null ;
    String dmessage = null ;
    String emessage = null ;
    String fmessage = null ;
    int[] num_tv = {2,2,2,2,2};
    int state = 2 ;
    int stringLength = 100 ;
    // ++++++++++++++++++++++++++++++++++++++++++

    // On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon.this, Home.class);
                startActivity(intent);
            }
        });

        // ++++++++++++++++++++++++++++++++++++++++++
        // 登録ボタンを押したとき
        // ++++++++++++++++++++++++++++++++++++++++++
        findViewById(R.id.completed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tva = findViewById(R.id.tv0);
                TextView tvb = findViewById(R.id.tv1);
                TextView tvc = findViewById(R.id.tv2);
                TextView tvd = findViewById(R.id.tv3);
                TextView tve = findViewById(R.id.tv4);
                tva.setText(amessage);
                tvb.setText(bmessage);
                tvc.setText(cmessage);
                tvd.setText(dmessage);
                tve.setText(emessage);
                // Date Text
                EditText editText = findViewById(R.id.editTextDate);
                final String text = editText.getText().toString();
                stringLength = text.length();
                if (stringLength < 4) {
                    state = 1;
                } else {
                    state = 2;
                }
                TextView tvf = findViewById(R.id.tv5);
                switch (state) {
                    case 1:
                        fmessage = "日付を入力してください。";
                        tvf.setText(fmessage);
                        break;
                    case 2:
                        fmessage = " ";
                        tvf.setText(fmessage);
                        break;
                }
                int[] a = {2, 2, 2, 2, 2};

                if (Arrays.equals(num_tv, a) && state == 2) {
                    if (state == 2) {

                        // ********************************************
                        // データ送信　＆　登録
                        // ********************************************
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                        reference = reference.child("クーポン").push();
                        reference.child("rate").setValue(rate_num, null);
                        reference.child("food").setValue(kind, null);
                        String name = kind + rate + "クーポン";
                        reference.child("name").setValue(name, null);
                        reference.child("date").setValue(text, null);

                        Intent intent2 = new Intent(Coupon.this, Coupon2.class);
                        intent2.putExtra("Name", name);
                        intent2.putExtra("Food", kind);
                        intent2.putExtra("Type", rate);
                        intent2.putExtra("Gender", gender);
                        intent2.putExtra("Age", age);
                        intent2.putExtra("Occupation", occupation);
                        intent2.putExtra("Date", text);
                        startActivityForResult(intent2, REQUEST_CODE);


                    }
                }
            }
        });


        // Spinner : 食品の種類
        Spinner aspinner = findViewById(R.id.aSpinner);
        aspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "全品" :
                        Log.d(selectedItem,"全品");
                        kind = "全品" ;
                        amessage = " " ;
                        num_tv[0] = 2 ;
                        break ;
                    case "野菜" :
                        Log.d(selectedItem,"野菜");
                        kind = "野菜" ;
                        amessage = " " ;
                        num_tv[0] = 2 ;
                        break;
                    case "肉類" :
                        Log.d(selectedItem,"肉類");
                        kind = "肉類" ;
                        amessage = " " ;
                        num_tv[0] = 2 ;
                        break;
                    case "魚介類" :
                        Log.d(selectedItem,"魚介類");
                        kind = "魚介類" ;
                        amessage = " " ;
                        num_tv[0] = 2 ;
                        break;
                    case "スイーツ" :
                        Log.d(selectedItem,"スイーツ");
                        kind = "スイーツ" ;
                        amessage = " " ;
                        num_tv[0] = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        kind = null ;
                        amessage = "選択してください。" ;
                        num_tv[0] = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner : 割引のオプション
        Spinner bspinner = findViewById(R.id.bSpinner);
        bspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "100円引き" :
                        Log.d(selectedItem,"100円");
                        rate = "100円引き" ;
                        rate_num = "100" ;
                        bmessage = " " ;
                        num_tv[1] = 2 ;
                        break;
                    case "200円引き" :
                        Log.d(selectedItem,"200円");
                        rate = "200円引き" ;
                        rate_num = "200" ;
                        bmessage = " " ;
                        num_tv[1] = 2 ;
                        break;
                    case "10%OFF" :
                        Log.d(selectedItem,"10%OFF");
                        rate = "10％割り引き" ;
                        rate_num = "0.1" ;
                        bmessage = " " ;
                        num_tv[1] = 2 ;
                        break;
                    case "15%OFF" :
                        Log.d(selectedItem,"15%OFF");
                        rate = "15％割り引き" ;
                        rate_num = "0.15" ;
                        bmessage = " " ;
                        num_tv[1] = 2 ;
                        break;
                    case "20%OFF" :
                        Log.d(selectedItem,"20%OFF");
                        rate = "20％割り引き" ;
                        rate_num = "0.2" ;
                        bmessage = " " ;
                        num_tv[1] = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        rate = null ;
                        bmessage = "選択してください。" ;
                        num_tv[1] = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner : 性別
        Spinner cspinner = findViewById(R.id.cSpinner);
        cspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "男性" :
                        Log.d(selectedItem,"男性");
                        cmessage = " " ;
                        gender = selectedItem ;
                        num_tv[2] = 2 ;
                        break;
                    case "女性" :
                        Log.d(selectedItem,"女性");
                        cmessage = " " ;
                        gender = selectedItem ;
                        num_tv[2] = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"区別なし");
                        cmessage = " " ;
                        gender = selectedItem ;
                        num_tv[2] = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        cmessage = "選択してください。" ;
                        gender = null ;
                        num_tv[2] = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner : 年代
        Spinner dspinner = findViewById(R.id.dSpinner);
        dspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "10代" :
                        Log.d(selectedItem,"case 1");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    case "20代" :
                        Log.d(selectedItem,"case 2");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    case "30~40代"  :
                        Log.d(selectedItem,"case 3");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    case "50~60代" :
                        Log.d(selectedItem,"case 4");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    case "70代~"  :
                        Log.d(selectedItem,"case 5");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"case 6");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tv[3] = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        dmessage = "選択してください。" ;
                        age = null ;
                        num_tv[3] = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Spinner : 職業
        Spinner espinner = findViewById(R.id.eSpinner);
        espinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem){
                    case "会社員" :
                        Log.d(selectedItem,"case 1");
                        emessage = " " ;
                        num_tv[4] = 2 ;
                        occupation = selectedItem ;
                        break;
                    case "公務員" :
                        Log.d(selectedItem,"case 2");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tv[4] = 2 ;
                        break;
                    case "学生"  :
                        Log.d(selectedItem,"case 3");
                        emessage = " " ;
                        num_tv[4] = 2 ;
                        occupation = selectedItem ;
                        break;
                    case "専業主婦(夫)" :
                        Log.d(selectedItem,"case 4");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tv[4] = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"case 5");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tv[4] = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        emessage = "選択してください。" ;
                        occupation = selectedItem ;
                        num_tv[4] = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

