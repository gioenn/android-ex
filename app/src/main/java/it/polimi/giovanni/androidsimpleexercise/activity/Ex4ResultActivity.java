package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import it.polimi.giovanni.androidsimpleexercise.R;

public class Ex4ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_result);

        String title = getIntent().getStringExtra("title");
        String res = getIntent().getIntExtra("result", 0)+"";

        TextView titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText(title);

        TextView resText = (TextView) findViewById(R.id.resText);
        resText.setText(res);
    }
}
