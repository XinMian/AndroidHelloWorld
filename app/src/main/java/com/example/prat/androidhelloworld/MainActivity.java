package com.example.prat.androidhelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvHello;
    EditText etUsername;
    EditText etPassword;
    Button btSubmit;

    EditText etInput1;
    EditText etInput2;
    TextView tvResult;
    Button btnCalculate;

    RadioButton radioPlus;
    RadioButton radioMinus;
    RadioButton radioMutiply;
    RadioButton radioDivide;
    RadioGroup radioGroupCalculateMode;

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

                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    return true;
                }
                return false;
            }
        });

        btSubmit = findViewById(R.id.BtSubmit);
        btSubmit.setOnClickListener(this);

        //Start Here
        etInput1 = findViewById(R.id.Etinput1);
        etInput2 = findViewById(R.id.Etinput2);
        tvResult = findViewById(R.id.TvResult);

        btnCalculate = findViewById(R.id.BtnCalculate);
        radioGroupCalculateMode = findViewById(R.id.RadioCalculateMode);
        radioPlus = findViewById(R.id.RadioPlus);
        radioMinus = findViewById(R.id.RadioMinus);
        radioMutiply = findViewById(R.id.RadioMultiply);
        radioDivide = findViewById(R.id.RadioDivide);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btSubmit)
            tvHello.setText(etUsername.getText() + " " + etPassword.getText());
        else if (v == btnCalculate) {

            int input1 = 0;
            int input2 = 0;
            int result = 0;

            try {
                input1 = Integer.parseInt(etInput1.getText().toString());

            } catch (NumberFormatException e) {

            }

            try {
                input2 = Integer.parseInt(etInput2.getText().toString());

            } catch (NumberFormatException e) {

            }

            switch (radioGroupCalculateMode.getCheckedRadioButtonId()) {
                case R.id.RadioPlus:
                    result = input1 + input2;
                    break;
                case R.id.RadioMinus:
                    result = input1 - input2;
                    break;
                case R.id.RadioMultiply:
                    result = input1 * input2;
                    break;
                case R.id.RadioDivide:
                    try {
                        result = input1 / input2;
                    } catch (NumberFormatException e) {

                    }
            }

            tvResult.setText("= " + result);
            Log.d("Calculation", "Result = " + result);
        }

    }
}
