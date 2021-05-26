package com.example.tabemanecorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RealTimeSale extends AppCompatActivity {

    String[] strings = {
            "0110　惣菜(枝豆)　　　　　　20　2021.5.27",
            "0126　惣菜(コロッケ)　　　　25　2021.5.27",
            "0140　惣菜(春巻き)　　　　　20　2021.5.27",
            "0042　小松菜　　　　　　　  50　2021.5.28",
            "0088　えのき　　　　　　　  40　2021.5.28",
            "0137　惣菜(ハンバーグ)　　　15　2021.5.28",
            "0045　カリフラワー　　　　  35　2021.5.29",
            "0053　オクラ　　　　　　　  40　2021.5.29",
            "0089　エリンギ　　　　　　  50　2021.5.29",
            "0125　惣菜(鶏のから揚げ)　　20　2021.5.29",
            "0131　惣菜(茄子の揚げ浸し)　20　2021.5.29",
            "0038　大根　　　　　　　　  50　2021.5.31",
            "0087　しいたけ　　　　　　  35　2021.5.31",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_sale);

        // ホームボタンを押したとき
        findViewById(R.id.btnhome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealTimeSale.this,Home.class);
                startActivity(intent);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                strings
        );

        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);

        ((ListView)findViewById(R.id.listView)).setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(RealTimeSale.this,TimeSale2.class);
                        startActivity(intent);
                    }
                }
        );

    }
}