package com.example.def;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.def.application.App;
import com.example.def.models.RecycleViewAdapter;
import com.example.def.retrofit.ApiService;
import com.example.def.retrofit.Authorization;
import com.example.def.retrofit.AuthorizationInterceptor;
import com.example.def.retrofit.MessageResponse;
import com.example.def.retrofit.Session;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main3Activity extends AppCompatActivity {
    private static String mSessionId;
    private RecyclerView recyclerView;
    private ArrayList <String> items = new ArrayList <String>();
    private EditText mMessageEditText;
    public static TextView mMessageOutputCliente;
    public static TextView mMessageOutputBot;
    private RecycleViewAdapter recycleViewAdapter;
    private ApiService mService;


//    public void setmSessionId(String mSessionId) {
//        this.mSessionId = mSessionId;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText = findViewById(R.id.editText);
        mService = ((App)getApplication()).getApiService(); //ApiUtils.getSoService();
        mMessageOutputBot = findViewById(R.id.viewMessaggioBot);
        recyclerView = findViewById(R.id.recycleView1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recycleViewAdapter = new RecycleViewAdapter(this, items);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutputCliente = findViewById(R.id.viewMessaggio);
        mMessageOutputBot = findViewById(R.id.viewMessaggioBot);
        loadAnswers();
    }

    public static final String VERSION = "2019-02-28";

    private void loadAnswers() {
        System.out.println(mSessionId);
//        Call <SessionId> call = mService.getAnsware();
        Session sess = ((App)getApplication()).getSession();
        Call <Authorization> call =
        mService.createSession(AuthorizationInterceptor.getAuthorizationHeader(sess.getUserId(),sess.getPassword()),VERSION);
        call.enqueue(new Callback <Authorization>() {
            @Override
            public void onResponse(Call <Authorization> call, Response <Authorization> response) {
                if (response.isSuccessful()) {
                    System.out.println("hola");
                    mSessionId = response.body().getSessionId();
                    System.out.println(mSessionId);
                } else {
                    int statusCode = response.code();
                    // Log.d("okkio", String.valueOf(statusCode));
                }
            }
            @Override
            public void onFailure(Call <Authorization> callresponse, Throwable t) {
                System.out.println("non funziona");
            }
        });
        System.out.println(mSessionId);
    }

    public static String getmSessionId() {

        System.out.println(mSessionId);
        return mSessionId;

    }

    public void invioMessaggio(View view) {
        String message = mMessageEditText.getText().toString();
        recycleViewAdapter.notifyItemInserted(items.size());
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(findViewById(R.id.button).getWindowToken(), 0);
        mMessageEditText.setText("");
        recyclerView.scrollToPosition(items.size() - 1);
        if (message.length() == 0) {
            Log.d("yessa", "non stampo");
        } else {
            items.add(message);
        }
    }


//    @Override
//    public Call <SessionId> getAnsware() {
//        return null;
//    }
//
//    @Override
//    public Call <MessageOutputBot> getAnsware2() {
//        return null;
//    }
}