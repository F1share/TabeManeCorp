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

public class Coupon extends AppCompatActivity {

    // Setting
    String rate = null ;
    String rate_num = null ;
    String kind = null ;
    String gender = null ;
    String age = null ;
    String occupation = null ;
    String date = null ;
    String amessage = null ;
    String bmessage = null ;
    String cmessage = null ;
    String dmessage = null ;
    String emessage = null ;
    String fmessage = null ;
    int num_tva = 2 ;
    int num_tvb = 2 ;
    int num_tvc = 2 ;
    int num_tvd = 2 ;
    int num_tve = 2 ;
    int state = 2 ;
    int stringLength = 100 ;
    int food_id = 10004 ;

    // On Create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);

        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Coupon.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //******************************************************************************
        // Connection between Spinner & Firebase DB
        //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        findViewById(R.id.completed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tva = findViewById(R.id.atv);
                TextView tvb = findViewById(R.id.btv);
                TextView tvc = findViewById(R.id.ctv);
                TextView tvd = findViewById(R.id.dtv);
                TextView tve = findViewById(R.id.etv);
                //                TextView tv_upper = findViewById(R.id.tv_upper);
                tva.setText(amessage);
                tvb.setText(bmessage);
                tvc.setText(cmessage);
                tvd.setText(dmessage);
                tve.setText(emessage);
                // Date Text
                EditText editText = findViewById(R.id.editTextDate) ;
                final String text = editText.getText().toString();
                stringLength = text.length() ;
                if (stringLength < 4) {
                    state = 1 ;
                } else {
                    state = 2 ;
                }
                TextView tvf = findViewById(R.id.ftv);
                switch (state) {
                    case 1 :
                        fmessage = "日付を入力してください。" ;
                        tvf.setText(fmessage);
                        break ;
                    case 2 :
                        fmessage = " " ;
                        tvf.setText(fmessage);
                        break ;
                }
                if (num_tva == 2) {
                    if (num_tvb == 2) {
                        if (num_tvc == 2) {
                            if (num_tvd == 2) {
                                if (num_tve == 2) {
                                    if (state == 2) {

                                        // ********************************************
                                        // データ送信　＆　登録
                                        // ********************************************
                                        //food_id = food_id + 1 ;
                                        //String id_text = String.valueOf(food_id) ;
                                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                                        reference = reference.child("クーポン").push();
                                        reference.child("rate").setValue(rate_num,null);
                                        reference.child("food").setValue(kind, null) ;
                                        String name = kind + rate + "クーポン" ;
                                        reference.child("name").setValue(name, null);
                                        reference.child("date").setValue(text, null) ;

//                                    reference.child("性別").setValue(gender, null) ;
//                                    reference.child("年代").setValue(age, null) ;
//                                    reference.child("職業").setValue(occupation, null) ;
//                                    try {
//                                        Thread.sleep(5000);
//                                    } catch(InterruptedException e) {
//                                        System.out.println("got interrupted!");
//                                    }
                                        Intent intent = new Intent(Coupon.this, Coupon2.class);

//                                    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                                    Intent subIntent = new Intent(getApplicationContext(), Coupon3.class) ;
//                                    subIntent.putExtra("food_id", food_id);
//                                    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//                                    subIntent.putExtra("type", food_id);
//                                    subIntent.putExtra("rate", food_id);
//                                    subIntent.putExtra("gender", food_id);
//                                    subIntent.putExtra("age", food_id);
//                                    subIntent.putExtra("occupation", food_id);

                                        startActivity(intent);

                                    }
                                }
                            }
                        }
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
                        num_tva = 2 ;
                        break ;
                    case "野菜" :
                        Log.d(selectedItem,"野菜");
                        kind = "野菜" ;
                        amessage = " " ;
                        num_tva = 2 ;
                        break;
                    case "肉類" :
                        Log.d(selectedItem,"肉類");
                        kind = "肉類" ;
                        amessage = " " ;
                        num_tva = 2 ;
                        break;
                    case "魚介類" :
                        Log.d(selectedItem,"魚介類");
                        kind = "魚介類" ;
                        amessage = " " ;
                        num_tva = 2 ;
                        break;
                    case "スイーツ" :
                        Log.d(selectedItem,"スイーツ");
                        kind = "スイーツ" ;
                        amessage = " " ;
                        num_tva = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        kind = null ;
                        amessage = "選択してください。" ;
                        num_tva = 1 ;
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
                        num_tvb = 2 ;
                        break;
                    case "200円引き" :
                        Log.d(selectedItem,"200円");
                        rate = "200円引き" ;
                        rate_num = "200" ;
                        bmessage = " " ;
                        num_tvb = 2 ;
                        break;
                    case "10%OFF" :
                        Log.d(selectedItem,"10%OFF");
                        rate = "10％割り引き" ;
                        rate_num = "0.1" ;
                        bmessage = " " ;
                        num_tvb = 2 ;
                        break;
                    case "15%OFF" :
                        Log.d(selectedItem,"15%OFF");
                        rate = "15％割り引き" ;
                        rate_num = "0.15" ;
                        bmessage = " " ;
                        num_tvb = 2 ;
                        break;
                    case "20%OFF" :
                        Log.d(selectedItem,"20%OFF");
                        rate = "20％割り引き" ;
                        rate_num = "0.2" ;
                        bmessage = " " ;
                        num_tvb = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        rate = null ;
                        bmessage = "選択してください。" ;
                        num_tvb = 1 ;
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
                        num_tvc = 2 ;
                        break;
                    case "女性" :
                        Log.d(selectedItem,"女性");
                        cmessage = " " ;
                        gender = selectedItem ;
                        num_tvc = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"区別なし");
                        cmessage = " " ;
                        gender = selectedItem ;
                        num_tvc = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        cmessage = "選択してください。" ;
                        gender = null ;
                        num_tvc = 1 ;
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
                        num_tvd = 2 ;
                        break;
                    case "20代" :
                        Log.d(selectedItem,"case 2");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tvd = 2 ;
                        break;
                    case "30~40代"  :
                        Log.d(selectedItem,"case 3");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tvd = 2 ;
                        break;
                    case "50~60代" :
                        Log.d(selectedItem,"case 4");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tvd = 2 ;
                        break;
                    case "70代~"  :
                        Log.d(selectedItem,"case 5");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tvd = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"case 6");
                        dmessage = " " ;
                        age = selectedItem ;
                        num_tvd = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        dmessage = "選択してください。" ;
                        age = null ;
                        num_tvd = 1 ;
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
                        num_tve = 2 ;
                        occupation = selectedItem ;
                        break;
                    case "公務員" :
                        Log.d(selectedItem,"case 2");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tve = 2 ;
                        break;
                    case "学生"  :
                        Log.d(selectedItem,"case 3");
                        emessage = " " ;
                        num_tve = 2 ;
                        occupation = selectedItem ;
                        break;
                    case "専業主婦(夫)" :
                        Log.d(selectedItem,"case 4");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tve = 2 ;
                        break;
                    case "区別なし" :
                        Log.d(selectedItem,"case 5");
                        emessage = " " ;
                        occupation = selectedItem ;
                        num_tve = 2 ;
                        break;
                    default:
                        Log.d(selectedItem,"失敗");
                        emessage = "選択してください。" ;
                        occupation = selectedItem ;
                        num_tvd = 1 ;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        EditText et0 = findViewById(R.id.editTextDate) ;
//        et0.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                return false;
//            }
//        });

    }
}
