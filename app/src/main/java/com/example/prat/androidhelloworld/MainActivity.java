package com.example.prat.androidhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHello;
    EditText etUsername;
    EditText etPassword;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        tvHello = (TextView) findViewById(R.id.TVHello);
        tvHello.setText("Login");

        etUsername = findViewById(R.id.EtUsername);
        etPassword = findViewById(R.id.EtPassword);
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_DONE)
                {

                    return true;
                }
                return false;
            }
        });

        btSubmit = findViewById(R.id.BtSubmit);
        btSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btSubmit)
            tvHello.setText(etUsername.getText() + " " + etPassword.getText());
    }
}
