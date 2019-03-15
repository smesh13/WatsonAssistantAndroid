package com.example.def;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private ImageButton imageButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = findViewById(R.id.button1);
    }

    public void startChatting(View view) {
       Intent intent = new Intent(MainActivity.this,SecondActivity.class);
       startActivity(intent);

    }

}
