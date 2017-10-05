package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        EditText sum1 = (EditText) findViewById(R.id.sum1);
        int a = Integer.parseInt(sum1.getText().toString());

        EditText sum2 = (EditText) findViewById(R.id.sum2);
        int b = Integer.parseInt(sum2.getText().toString());

        int res = calculator.sum(a, b);

        TextView sumRes = (TextView)  findViewById(R.id.sumRes);
        sumRes.setText(res+"");
    }
}
