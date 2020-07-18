package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float a,b,c;
    String screenText, sign, signed, calcresult;
    TextView textview;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.txtin);
        signed = "0";
        screenText = "";
        calcresult = "0";
    }

    public void onClickNum (View view) {
        calcresult = "0";
        if (signed.equals("0")){
            Button button = (Button)view;
            screenText += button.getText().toString();
            textview.setText(screenText);
            a = Float.parseFloat((screenText));
        } else {
            Button button = (Button)view;
            screenText += button.getText().toString();
            textview.setText(screenText);
            b = Float.parseFloat((screenText));
        }
    }

    public void onClickSign (View view) {
        Button button = (Button)view;
        sign = button.getText().toString();
        textview.setText(sign);
        signed = "1";
        screenText = "";
    }

    public void onClickCalc (View view) {
        Button button = (Button)view;

        if (sign.equals("+")){
            c = a + b;
        }else if (sign.equals("-")){
            c = a - b;
        }else if (sign.equals("*")) {
            c = a * b;
        }else if (sign.equals("/")) {
            c = a / b;
        }
        calcresult = Float.toString(c);
        textview.setText(calcresult);
        screenText = "0";
        signed = "0";

    }

    public void reset (View view) {
        Button button = (Button)view;
        signed = "0";
        screenText = "";
        calcresult = "0";
        textview.setText("0");
    }
}