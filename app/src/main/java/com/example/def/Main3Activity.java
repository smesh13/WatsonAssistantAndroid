package com.example.def;

import android.os.Bundle;
import android.se.omapi.Session;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.def.models.RecycleViewAdapter;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.def.RetrofitClient.retrofit;


public class Main3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList <String> items = new ArrayList <String>();
    private EditText mMessageEditText;
    private TextView mMessageOutput;
    private TextView mMessageOutput2;
    private RecycleViewAdapter recycleViewAdapter;
    private SoService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText = findViewById(R.id.editText);
        mService = ApiUtils.getSoService();
        mMessageOutput2 = findViewById(R.id.viewMessaggioBot);
        recyclerView = findViewById(R.id.recycleView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleViewAdapter = new RecycleViewAdapter(this, items);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutput = findViewById(R.id.viewMessaggio);
        //loadAnswers();
    }

    private void loadAnswers() {
        Call <ResponseBody> call = mService.getAnsware();
        call.enqueue(new Callback <ResponseBody>() {
                         @Override
                         public void onResponse(Call <ResponseBody> call, Response <ResponseBody> response) {
                             //if(response.isSuccessful()){
                                 Log.d("ok", "risposta arrivata");
                                 ResponseBody responseBody = response.body();

                             //}
                         }

                         @Override
                         public void onFailure(Call <ResponseBody> call, Throwable t) {
                             Log.d("non", "non è arrivata laris ta");
                         }
                     });
    }

//    SoService service = retrofit.create(SoService.class);
//    Call<ResponseBody> call = service.l




    public void invioMessaggio(View view) {
        String message = mMessageEditText.getText().toString();
        items.add(message);

        recycleViewAdapter.notifyItemInserted(items.size());

        recyclerView.scrollToPosition(items.size());

    }


}