package com.example.muni.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String message,no,gender;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        no = intent.getStringExtra("Phone");
        gender=intent.getStringExtra("gender");
        txtView = (TextView) findViewById(R.id.text);
        txtView.setText("name:" + message + "\n" + "phone no:" + no + "\n" + "gender :" +gender);


    }
}
