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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvHello = (TextView) findViewById(R.id.TVHello);
        tvHello.setText("Login");

        final EditText etUsername = findViewById(R.id.EtUsername);
        final EditText etPassword = findViewById(R.id.EtPassword);
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

        Button btSubmit = findViewById(R.id.BtSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHello.setText(etUsername.getText() + " " + etPassword.getText());
            }
        });

    }
}
