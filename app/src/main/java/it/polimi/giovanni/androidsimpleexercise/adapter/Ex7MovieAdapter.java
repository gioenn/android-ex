package it.polimi.giovanni.androidsimpleexercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import it.polimi.giovanni.androidsimpleexercise.R;
import it.polimi.giovanni.androidsimpleexercise.model.Movie;

/**
 * Created by giovanniquattrocchi on 29/05/17.
 */

public class Ex7MovieAdapter extends ArrayAdapter<Movie> {

    public Ex7MovieAdapter(Context context, List<Movie> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movie movie = getItem(position);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView = layoutInflater.inflate(R.layout.movie_row_ex11, null);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.titleView);
        TextView directorView = (TextView) convertView.findViewById(R.id.directorView);

        titleView.setText(movie.getTitle());
        directorView.setText(movie.getDirector());

        return convertView;

    }
}
