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
import android.widget.Toast;

import com.example.def.application.App;
import com.example.def.entity.MessageRequest;
import com.example.def.models.RecycleViewAdapter;
import com.example.def.retrofit.ApiService;
import com.example.def.retrofit.Authorization;
import com.example.def.retrofit.AuthorizationInterceptor;
import com.example.def.entity.MessageResponse;
import com.example.def.retrofit.Session;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main3Activity extends AppCompatActivity {
    private static String mSessionId;
    private RecyclerView recyclerView;
    private ArrayList <String> questions = new ArrayList <String>();
    private ArrayList <String> answers = new ArrayList <String>();
    private EditText mMessageEditText;
    private RecycleViewAdapter recycleViewAdapter;
    private ApiService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText = findViewById(R.id.editText);
        mService = ((App) getApplication()).getApiService();
        recyclerView = findViewById(R.id.recycleView1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recycleViewAdapter = new RecycleViewAdapter(this, questions, answers);
        recyclerView.setAdapter(recycleViewAdapter);
        loadAnswers();
    }

    public static final String VERSION = "2019-02-28";

    private void loadAnswers() {

        Session sess = ((App) getApplication()).getSession();
        Call <Authorization> call =
                mService.createSession(AuthorizationInterceptor.getAuthorizationHeader(), VERSION);
        call.enqueue(new Callback <Authorization>() {
            @Override
            public void onResponse(Call <Authorization> call, Response <Authorization> response) {
                if (response.isSuccessful()) {
                    mSessionId = response.body().getSessionId();
                    // Toast.makeText(Main3Activity.this, "got session_id: "+mSessionId, Toast.LENGTH_LONG).show();
                    Session sess = ((App) getApplication()).getSession();
                    sess.saveToken(mSessionId);
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call <Authorization> callresponse, Throwable t) {
                Toast.makeText(Main3Activity.this, "doesn't work", Toast.LENGTH_LONG).show();
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
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(findViewById(R.id.button).getWindowToken(), 0);
        mMessageEditText.setText("");
        if (message.length() == 0) {
            Log.d("yessa", "non stampo");
            Toast.makeText(Main3Activity.this ,"Attenzione: messaggio vuoto",Toast.LENGTH_LONG).show();
        } else {
            sendMessage(message);
        }
    }

    private void sendMessage(final String message) {
        /*
{
  "input": {
    "message_type": "text",
    "text": "<<message>>",
    "options": {
      "alternate_intents": true,
      "debug": true
    }
  },
  "context": {
    "global": {
      "system": {
        "user_id": "my_user_id"
      }
    }
  }
}
         */
        Session sess = ((App) getApplication()).getSession();
        String json = "{ \"input\": { \"message_type\": \"text\", \"text\": \"" + message + "\", \"options\": { \"alternate_intents\": true, \"debug\": true } }, \"context\": { \"global\": { \"system\": { \"user_id\": \"my_user_id\" } } } }";
        Gson gson = new Gson();
        MessageRequest question = gson.fromJson(json, MessageRequest.class);

        Call <MessageResponse> call = mService.sendMessage(AuthorizationInterceptor.getAuthorizationHeader(), sess.getToken(), VERSION, question);
        //mService.createSession(AuthorizationInterceptor.getAuthorizationHeader(sess.getUserId(),sess.getPassword()),VERSION);
        call.enqueue(new Callback <MessageResponse>() {
            @Override
            public void onResponse(Call <MessageResponse> call, Response <MessageResponse> response) {
                if (response.isSuccessful()) {
                    MessageResponse resp = response.body();
                    String text = resp.getOutput().getGeneric()[0].getText();
                   // Toast.makeText(Main3Activity.this, text, Toast.LENGTH_LONG).show();
                    answers.add(text);
                    questions.add(message);

                } else {
                    int statusCode = response.code();
                    Toast.makeText(Main3Activity.this, "response code: " + statusCode + "\n" + response.message(), Toast.LENGTH_LONG).show();
                    answers.add(response.message());
                    questions.add(message);

                }
                recycleViewAdapter.notifyItemInserted(questions.size());
                recyclerView.scrollToPosition(questions.size() - 1);
            }

            @Override
            public void onFailure(Call <MessageResponse> callresponse, Throwable t) {
                Toast.makeText(Main3Activity.this, "doesn't work", Toast.LENGTH_LONG).show();
                answers.add("doesn't work");
                questions.add(message);

                recycleViewAdapter.notifyItemInserted(questions.size());
                recyclerView.scrollToPosition(questions.size() - 1);
            }
        });
    }
}