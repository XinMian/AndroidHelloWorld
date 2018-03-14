package com.example.prat.androidhelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    int result;
    TextView tvResult;
    Button buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        result = intent.getIntExtra("result", 0);

        initInstances();
    }

    private void initInstances()
    {
        tvResult = (TextView) findViewById(R.id.TvResult);
        tvResult.setText("Result : " + result);

        buttonOk = findViewById(R.id.buttonOK);
        buttonOk.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        finish();
    }
}
