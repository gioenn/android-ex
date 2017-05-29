package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import it.polimi.giovanni.androidsimpleexercise.R;

public class Ex5ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_result);

        List<String> elements = getIntent().getStringArrayListExtra("results");

        ListView listView = (ListView) findViewById(R.id.listResults);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, elements));
    }
}
