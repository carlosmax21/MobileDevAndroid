package id.ac.umn.lectureassignment01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String operate = "";
    boolean isNewOp = true;
    String oldNumber = "";
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
        ed1.setKeyListener(null);
    }

    public void numberEvent(View view){
        if(isNewOp) ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch(view.getId()){
            case R.id.oneButton:
                number += "1";
                break;
            case R.id.twoButton:
                number += "2";
                break;
            case R.id.threeButton:
                number += "3";
                break;
            case R.id.fourButton:
                number += "4";
                break;
            case R.id.fiveButton:
                number += "5";
                break;
            case R.id.sixButton:
                number += "6";
                break;
            case R.id.sevenButton:
                number += "7";
                break;
            case R.id.eightButton:
                number += "8";
                break;
            case R.id.nineButton:
                number += "9";
                break;
            case R.id.zeroButton:
                if(number.length() != 0)
                    number += "0";
                break;
            case R.id.comaButton:
                if(!number.contains("."))
                    number += ".";
                break;
            case R.id.negativeButton:
                if(number.length() == 0) break;
                else if(!number.contains("-")){
                    number = "-" + number;
                }
                else {
                    number = number.substring(1);
                }
                break;
            case R.id.CButton:
                number = "0";
                isNewOp = true;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch(view.getId()){
            case R.id.plusButton:
                operate = "+";
                break;
            case R.id.minusButton:
                operate = "-";
                break;
            case R.id.timesButton:
                operate = "*";
                break;
            case R.id.divisionButton:
                operate = "/";
                break;
        }
    }

    public void equalEvent(View view){
        String newNumber = ed1.getText().toString();
        if(newNumber == "")
            newNumber = "0";
        double result = 0.0;
        switch(operate){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                if(oldNumber != "0")
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                else
                {
                    isNewOp = false;
                    return;
                }
                break;

        }

        String res = String.valueOf(result);
        res = res.indexOf(".") < 0 ? res : res.replaceAll("0*$", "").replaceAll("\\.$", "");
        ed1.setText(res+"");
    }

    public void clearAllEvent(View view){
        ed1.setText("0");
        oldNumber = "";
        isNewOp = true;
    }

    public void backEvent(View view){
        String number = ed1.getText().toString();

        if(number.length() == 2 && number.charAt(0) == '-') return;
        else if(number.length() > 1)
            number = number.substring(0,number.length() - 1);

        ed1.setText(number);
    }
}