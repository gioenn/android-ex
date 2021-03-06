package it.polimi.giovanni.androidsimpleexercise.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.adapter.Ex12MovieAdapter;
import it.polimi.giovanni.androidsimpleexercise.model.Movie;

public class Ex12Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12);

        ListView listView = (ListView) findViewById(R.id.movieList);
        listView.setAdapter(new Ex12MovieAdapter(this, Movie.getMovies()));
    }


}
