package com.example.prat.androidhelloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    int result;
    TextView tvResult;
    Button buttonOk;
    EditText editTextReturnText;
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
        tvResult.setText("Result = " + result);

        buttonOk = findViewById(R.id.buttonOK);
        buttonOk.setOnClickListener(this);

        editTextReturnText = findViewById(R.id.edittextReturnText);
    }


    @Override
    public void onClick(View v) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("Text", editTextReturnText.getText().toString());
        setResult(RESULT_OK, returnIntent);

        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
