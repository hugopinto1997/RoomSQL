package com.hugopinto.roomsql.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hugopinto.roomsql.Adapter.MovieAdapter;
import com.hugopinto.roomsql.*;
import com.hugopinto.roomsql.Classes.AppDatabase;
import com.hugopinto.roomsql.Classes.Movie;
import com.hugopinto.roomsql.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MovieAdapter adapter;
    List<Movie> movies;
    FloatingActionButton fab;
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv=findViewById(R.id.recycler);
        adapter = new MovieAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));

        db = AppDatabase.getAppDataBase(getApplicationContext());
        movies = db.moviesDAO().getALL();

        Thread hilo = new Thread(movies,rv,adapter,db);
        hilo.execute();

        fab  = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateMovie.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
