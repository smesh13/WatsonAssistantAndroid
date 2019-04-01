package com.example.def;

import android.content.Context;
import android.os.Bundle;
import android.se.omapi.Session;
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
import java.util.ArrayList;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.def.RetrofitClient.retrofit;


public class Main3Activity extends AppCompatActivity implements SoService {
    private static String mSessionId;
    private RecyclerView recyclerView;
    private ArrayList <String> items = new ArrayList <String>();
    private EditText mMessageEditText;
    public static TextView mMessageOutputCliente;
    public static TextView mMessageOutputBot;
    private RecycleViewAdapter recycleViewAdapter;
    private SoService mService;


//    public void setmSessionId(String mSessionId) {
//        this.mSessionId = mSessionId;
//    }

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
        recycleViewAdapter = new RecycleViewAdapter(this, items);
        recyclerView.setAdapter(recycleViewAdapter);
        mMessageOutputCliente = findViewById(R.id.viewMessaggio);
        mMessageOutputBot = findViewById(R.id.viewMessaggioBot);
        loadAnswers();
    }

    private void loadAnswers() {
        System.out.println(mSessionId);
        Call <SessionId> call = mService.getAnsware();
        call.enqueue(new Callback <SessionId>() {
            @Override
            public void onResponse(Call <SessionId> call, Response <SessionId> response) {
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
            public void onFailure(Call <SessionId> callresponse, Throwable t) {
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


    @Override
    public Call <SessionId> getAnsware() {
        return null;
    }

    @Override
    public Call <MessageOutputBot> getAnsware2() {
        return null;
    }
}