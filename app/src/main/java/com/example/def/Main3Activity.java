package com.example.def;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView ;

import java.util.ArrayList;


public class Main3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> items = new ArrayList<String>();
    private EditText mMessageEditText;
    private TextView mMessageOutput;
    private RecycleViewAdapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText=findViewById(R.id.editText);
        //Button but = (Button) findViewById(R.id.buòtton);


        recyclerView = findViewById(R.id.recycleView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleViewAdapter = new RecycleViewAdapter(this, items);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutput = findViewById(R.id.viewMessaggio);
    }

    public void invioMessaggio(View view) {
        String message = mMessageEditText.getText().toString();
      //  Intent intent = new Intent(this,Main3Activity.class);
       // intent.putExtra(Extra_Message,message);
        //adapter.notify
        items.add(message);

        recycleViewAdapter.notifyItemInserted(items.size());

        recyclerView.scrollToPosition(items.size());

    }

//    private void initRecyclerView(){
//        RecyclerView recyclerView = findViewById(R.id.recycleView1);
//        RecycleViewAdapter adapter = new RecycleViewAdapter(this,mNome,mMessaggio);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//    }

}