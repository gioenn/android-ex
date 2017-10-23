package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.SevenAndHalf;

public class Ex11StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11_stats);

        List<SevenAndHalf.Result> stats = SevenAndHalf.sharedGame().stats().getResult();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stats));

    }
}
