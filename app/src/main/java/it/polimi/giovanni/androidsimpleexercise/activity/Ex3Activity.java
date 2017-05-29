package it.polimi.giovanni.androidsimpleexercise.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Calculator;

public class Ex3Activity extends AppCompatActivity {

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);


    }

    public void sum(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sum(a, b);
        setResultView(res);
    }

    public void sub(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sub(a, b);
        setResultView(res);
    }

    public void mul(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.mul(a, b);
        setResultView(res);
    }

    public void fact(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int res = calculator.fact(a);
        setResultView(res);
    }

    public void pow(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.pow(a, b);
        setResultView(res);
    }

    private int getTermFromViewAtIndex(View view, int i){
        ViewGroup linearLayout = (ViewGroup) view.getParent();
        EditText editText = (EditText) linearLayout.getChildAt(i);

        return Integer.parseInt(editText.getText().toString());
    }



    private void setResultView(int res){
        TextView resView = (TextView) findViewById(R.id.res);
        resView.setText(""+res);
    }
}
