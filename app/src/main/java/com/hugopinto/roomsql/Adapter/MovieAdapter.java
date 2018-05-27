package com.hugopinto.roomsql.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hugopinto.roomsql.Classes.Movie;
import com.hugopinto.roomsql.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>{

    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new MoviesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.name.setText(movies.get(position).getNomMovie());
        holder.category.setText(movies.get(position).getNomcategory());
        holder.studio.setText(movies.get(position).getNomstudio());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView name, studio, category;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.moviename);
            studio = itemView.findViewById(R.id.studio);
            category = itemView.findViewById(R.id.category);
        }
    }


}
