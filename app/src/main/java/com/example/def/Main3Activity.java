package com.example.def;

import android.os.Bundle;
import android.se.omapi.Session;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView ;

import com.example.def.models.RecycleViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Main3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> items = new ArrayList<String>();
    private EditText mMessageEditText;
    private TextView mMessageOutput;
    private RecycleViewAdapter recycleViewAdapter;
    private SoService mService ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText=findViewById(R.id.editText);
        mMessageOutput=findViewById(R.id.viewMessaggioBot);
        mService = ApiUtils.getSoService();
        loadAnswers();
        recyclerView = findViewById(R.id.recycleView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleViewAdapter = new RecycleViewAdapter(this, items);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutput = findViewById(R.id.viewMessaggio);
    }

    private void loadAnswers() {


        mService.getAnsware().enqueue(new Callback <Response>() {
            @Override
            public void onResponse(Call<Response> call, Response <Response> response) {







                if (response.isSuccessful()){



                    String message2 = mMessageOutput.getText().toString();
                    items.add(message2);
                }
            }

            @Override
            public void onFailure(Call <Response> call, Throwable t) {

            }
        });

    }

    public void invioMessaggio(View view) {
        String message = mMessageEditText.getText().toString();
        items.add(message);

        recycleViewAdapter.notifyItemInserted(items.size());

        recyclerView.scrollToPosition(items.size());

    }


}