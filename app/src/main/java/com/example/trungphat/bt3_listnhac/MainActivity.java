package com.example.trungphat.bt3_listnhac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView_casy;
    ArrayList<list_casy> list_casy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_casy = (ListView) findViewById(R.id.list_casy);

        list_casy = new ArrayList<list_casy>();

        list_casy.add(new list_casy("Sơn Tùng MTP","Việt Nam","Pop/Ballad",R.drawable.casy1 ));
        list_casy.add(new list_casy("Soobin Hoàng Sơn","Việt Nam","Pop/Ballad",R.drawable.casy2 ));
        list_casy.add(new list_casy("Đông Nhi","Việt Nam","Pop/Ballad",R.drawable.casy3 ));
        list_casy.add(new list_casy("Chipu","Việt Nam","Pop/Ballad",R.drawable.casy4 ));
        list_casy.add(new list_casy("Avril Lavigne","Pháp/Canada","Pop/Rock",R.drawable.casy5 ));


        Adapter_casy adapter_casy = new Adapter_casy(MainActivity.this, R.layout.list_ca_sy, list_casy);

        listView_casy.setAdapter(adapter_casy);

        listView_casy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Activity_bai_hat.class);
                intent.putExtra("position",position);
                intent.putExtra("tencasy", list_casy.get(position).ten_casy);
                startActivity(intent);
            }
        });
    }
}
