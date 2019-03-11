package com.example.def;

import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView ;


public class Main3Activity extends AppCompatActivity {
    public static final String Extra_Message = "MESSAGE";
    private EditText mMessageEditText ;
    private RecyclerView mReplyTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mMessageEditText =findViewById(R.id.editText);
        mReplyTextView = findViewById(R.id.recycleView1);
    }

    public void invioMessaggio(View view) {
        String message = mMessageEditText.getText().toString();
        Intent intent = new Intent(this,Main3Activity.class);
        intent.putExtra(Extra_Message,message);

    }
}