package it.polimi.giovanni.androidsimpleexercise.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Calculator;

public class Ex4Activity extends AppCompatActivity {

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);
    }

    public void sum(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sum(a, b);
        startResultActivity(res, getString(R.string.result_sum));
    }

    public void sub(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.sub(a, b);
        startResultActivity(res, getString(R.string.result_sub));
    }

    public void mul(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.mul(a, b);
        startResultActivity(res, getString(R.string.result_mul));
    }

    public void fact(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int res = calculator.fact(a);
        startResultActivity(res, getString(R.string.result_fact));
    }

    public void pow(View view){
        int a = getTermFromViewAtIndex(view, 0);
        int b = getTermFromViewAtIndex(view, 2);
        int res = calculator.pow(a, b);
        startResultActivity(res, getString(R.string.result_pow));
    }

    private int getTermFromViewAtIndex(View view, int i){
        ViewGroup linearLayout = (ViewGroup) view.getParent();
        EditText editText = (EditText) linearLayout.getChildAt(i);

        return Integer.parseInt(editText.getText().toString());
    }


    private void startResultActivity(int res, String title){
        Intent intent = new Intent(this, Ex4ResultActivity.class);
        intent.putExtra("result", res);
        intent.putExtra("title", getString(R.string.result_title)+" "+title);
        startActivity(intent);
    }
}
