package it.polimi.giovanni.androidsimpleexercise.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import it.polimi.giovanni.androidsimpleexercise.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] optionsLabels = {"EX 1", "EX 2", "EX 3", "EX 4", "EX 5", "EX 6", "EX 7", "EX 8", "EX 9", "EX 10", "EX 11"};

        final List<Class<?>> options = new ArrayList<>();
        options.add(Ex1Activity.class);
        options.add(Ex2Activity.class);
        options.add(Ex3Activity.class);
        options.add(Ex4Activity.class);
        options.add(Ex5Activity.class);
        options.add(Ex6Activity.class);
        options.add(Ex7Activity.class);
        options.add(Ex8Activity.class);
        options.add(Ex9Activity.class);
        options.add(Ex10Activity.class);
        options.add(Ex11Activity.class);

        GridView mainMenu = (GridView) findViewById(R.id.mainMenu);

        mainMenu.setAdapter(new ArrayAdapter<String>(this, R.layout.menu_item, optionsLabels));

        mainMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, options.get(position));
                startActivity(intent);
            }
        });

    }
}
