package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    private enum Operator {none, add, sub, mul, div, eq}

    private double data01=0, data02 = 0;

    private Operator opp = Operator.none;

    private boolean hasDot = false;

    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.resultText);
    }
    public void onClickNumericalButton(View view) {


        //Getting ID of pressed Button
        int pressID = view.getId();

        //If we had an equal sign pressed last, standard operation is to clean
        if (opp == Operator.eq) {
            opp = Operator.none;
            resultText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            hasDot = false;
            resultText.setText("");
        }

        //Figuring out which button was pressed and updating the represented text field object
        if (pressID == R.id.button0) {
            resultText.setText(resultText.getText() + "0");
        } else if (pressID == R.id.button1) {
            resultText.setText(resultText.getText() + "1");
        } else if (pressID == R.id.button2) {
            resultText.setText(resultText.getText() + "2");
        } else if (pressID == R.id.button3) {
            resultText.setText(resultText.getText() + "3");
        } else if (pressID == R.id.button4) {
            resultText.setText(resultText.getText() + "4");
        } else if (pressID == R.id.button5) {
            resultText.setText(resultText.getText() + "5");
        } else if (pressID == R.id.button6) {
            resultText.setText(resultText.getText() + "6");
        } else if (pressID == R.id.button7) {
            resultText.setText(resultText.getText() + "7");
        } else if (pressID == R.id.button8) {
            resultText.setText(resultText.getText() + "8");
        } else if (pressID == R.id.button9) {
            resultText.setText(resultText.getText() + "9");
        } else if (pressID == R.id.buttonDot) {
            if (!hasDot) {
                resultText.setText(resultText.getText() + ".");
                hasDot = true;
            }
        } else {
            resultText.setText("ERROR");
        }

    }

    public void onClickFunctionButton(View view){
        int buttonPressed = view.getId();

        if(buttonPressed == R.id.buttonEq){
            String s1 = "";
            s1 += resultText.getText();
            data02 = Double.valueOf(s1);
            double result = 0;

            if(opp == Operator.div){
                result = data01/data02;
            } else if(opp == Operator.mul){
                result = data01*data02;
            } else if(opp == Operator.add){
                result = data01+data02;
            } else if(opp == Operator.sub){
                result = data01 - data02;
            }

            resultText.setText(Double.toString(result));
            opp = Operator.eq;
        }
        else {
            String s = "";
            s += resultText.getText();
            data01 = Double.valueOf(s);

            if (buttonPressed == R.id.buttonDiv) {
                opp = Operator.div;
                resultText.setText(resultText.getText() + "/");
            } else if (buttonPressed == R.id.buttonMul) {
                opp = Operator.mul;
                resultText.setText(resultText.getText() + "*");
            } else if (buttonPressed == R.id.buttonPlus) {
                opp = Operator.add;
                resultText.setText(resultText.getText() + "+");
            } else if (buttonPressed == R.id.buttonMinus) {
                opp = Operator.sub;
                resultText.setText(resultText.getText() + "-");
            }
        }
    }
}