package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {

        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL

    }

    TextView txt1;
    TextView txtOutput;

    // Instance Variables

    private String currNumber;
    private String LeftString;
    private String RightString;
    private OPERATOR currOperator;
    private int calculatiosResult;

    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currNumber = "";
        calculatiosResult = 0;

        calculationsString = "";

        txt1 = findViewById(R.id.txt1);
        txtOutput =findViewById(R.id.txtOutput);


        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);

        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(MainActivity.this);

        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubstract).setOnClickListener(MainActivity.this);

        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnEqual:

                operatorIsTapped(OPERATOR.EQUAL);

                break;

            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;

            case R.id.btnMultiply:

                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString = calculationsString + " * ";

                break;

            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;

            case R.id.btndivide:

                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString = calculationsString + " / ";

                break;


            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;

            case R.id.btnSubstract:

                operatorIsTapped(OPERATOR.SUBTRACT);

                calculationsString = calculationsString + " - ";

                break;


            case R.id.btnClear:

                clearTapped();

                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;

            case R.id.btnPlus:

                operatorIsTapped(OPERATOR.PLUS);
                calculationsString = calculationsString + " + ";

                break;


        }
        txt1.setText(calculationsString);
    }
    private void numberIsTapped(int tappedNumber) {

        currNumber = currNumber + String.valueOf(tappedNumber);
        txtOutput.setText(currNumber);

        calculationsString = currNumber;
        txt1.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {

        if (currOperator != null) {

            if (currNumber != "") {


                RightString = currNumber;
                currNumber = "";

                switch (currOperator) {


                    case PLUS:

                        calculatiosResult = Integer.parseInt(LeftString) +
                                Integer.parseInt(RightString);

                        break;

                    case SUBTRACT:

                        calculatiosResult = Integer.parseInt(LeftString) -
                                Integer.parseInt(RightString);

                        break;

                    case MULTIPLY:

                        calculatiosResult = Integer.parseInt(LeftString) *
                                Integer.parseInt(RightString);

                        break;
                    case DIVIDE:

                        calculatiosResult = Integer.parseInt(LeftString) /
                                Integer.parseInt(RightString);

                        break;


                }

                LeftString = String.valueOf(calculatiosResult);
                txtOutput.setText(LeftString);
                calculationsString = LeftString;

            }
        }

        else {

            LeftString = currNumber;
            currNumber = "";

        }

        currOperator = tappedOperator;

    }

    private void clearTapped() {


        LeftString = "";
        RightString = "";
        calculatiosResult = 0;
        currNumber = "";
        currOperator = null;
        txtOutput.setText("0");
        calculationsString = "0";

    }

}