package com.hugopinto.roomsql.Threads;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.hugopinto.roomsql.Adapter.MovieAdapter;
import com.hugopinto.roomsql.Classes.AppDatabase;

import java.util.List;

public class Thread extends AsyncTask {


    private List<Movie> movies;
    private RecyclerView rv;
    private MovieAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movie> movies, RecyclerView rv, MovieAdapter adapter, AppDatabase db){
        this.movies = movies;
        this.rv = rv;
        this.adapter = adapter;
        this.db = db;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        addMovie(movies);
        adapter = new MovieAdapter(movies);
        rv.setAdapter(adapter);
        return null;
    }

    public void addMovie(List<Movie> movies){
        movies.add(new Movie("Avergers: Parciality War","DEI/UCA", "Violence"));
        movies.add(new Movie("Surviving Android","PDM", "Drama"));
    }

}
