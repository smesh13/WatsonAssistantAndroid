package com.example.def;

import android.content.Context;
import android.os.Bundle;
import android.se.omapi.Session;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import com.example.def.models.RecycleViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.def.RetrofitClient.retrofit;


public class Main3Activity extends AppCompatActivity {
    private String mSessionId;
    private RecyclerView recyclerView;
    private ArrayList <String> items = new ArrayList <String>();
    private ArrayList <String> itembot = new ArrayList <String>();
    private EditText mMessageEditText;
    public TextView mMessageOutputCliente;
    public TextView mMessageOutputBot;
    private RecycleViewAdapter recycleViewAdapter;
    private SoService mService;
    private String mMessaggioBot;
    private String mMessage1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText = findViewById(R.id.editText);
        mService = ApiUtils.getSoService();
        mMessageOutputBot = findViewById(R.id.viewMessaggioBot);
        recyclerView = findViewById(R.id.recycleView1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recycleViewAdapter = new RecycleViewAdapter(this, items,itembot);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutputCliente = findViewById(R.id.viewMessaggio);
        loadAnswers();
    }

    private void loadAnswers() {

        Call <SessionId> call = mService.getAnsware();
        call.enqueue(new Callback <SessionId>() {
            @Override
            public void onResponse(Call <SessionId> call, Response <SessionId> response) {
                if (response.isSuccessful()) {
                    System.out.println("hola");
                    mSessionId = response.body().getSessionId();
                  //  RetrofitClient.CSESSION_ID = mSessionId;
                    System.out.println(mSessionId);

                } else {
                    int statusCode = response.code();

                }
            }
            @Override
            public void onFailure(Call <SessionId> callresponse, Throwable t) {
                System.out.println("non funziona");
            }
        });

    }
    private void startSecondCall() {
        Call <Obj1> call2 = mService.getAnsware2(mSessionId,mMessage1);
        call2.enqueue(new Callback <Obj1>() {
            @Override
            public void onResponse(Call <Obj1> call, Response <Obj1> response) {
                System.out.println("messaggio arrivato");
                mMessaggioBot = response.body().getOutput().getGeneric().get(0).getText();
                itembot.add(mMessaggioBot);
                mMessageOutputBot = findViewById(R.id.viewMessaggioBot);
                mMessageOutputBot.setText(mMessaggioBot);
                //String text = getText();
                System.out.println(mMessaggioBot);

            }

            @Override
            public void onFailure(Call <Obj1> call, Throwable t) {
                System.out.println("errore 404Ema");
            }
        });
    }


    public void invioMessaggio (View view){

        mMessage1= mMessageEditText.getText().toString();
        //recycleViewAdapter.notifyItemInserted(items.size());
        //recycleViewAdapter.notifyItemInserted(itembot.size());
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(findViewById(R.id.button).getWindowToken(), 0);
        mMessageEditText.setText("");
        recyclerView.scrollToPosition(items.size()-1);
        if (mMessage1.length() == 0) {
            Log.d("yessa", "non stampo");
        } else {
            items.add(mMessage1);
        }
        startSecondCall();
    }

    }
