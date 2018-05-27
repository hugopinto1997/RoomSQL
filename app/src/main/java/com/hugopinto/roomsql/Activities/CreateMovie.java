package com.hugopinto.roomsql.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hugopinto.roomsql.Classes.AppDatabase;
import com.hugopinto.roomsql.Classes.Movie;
import com.hugopinto.roomsql.R;

import java.util.List;

public class CreateMovie extends AppCompatActivity {

    EditText name, studio, category;
    Button btn;

    List<Movie> movies;
    String sname, sstudio, scat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add a movie:");

        btn = findViewById(R.id.button);
        name = findViewById(R.id.addmovie);
        studio = findViewById(R.id.addstudio);
        category = findViewById(R.id.addcategory);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString();
                sstudio = studio.getText().toString();
                scat = category.getText().toString();
                if(sname.isEmpty() || sstudio.isEmpty() || scat.isEmpty()){
                    Toast.makeText(v.getContext(), "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    AppDatabase db = AppDatabase.getAppDataBase(getApplicationContext());
                    db.moviesDAO().insertMovie(new Movie(sname, scat, sstudio));
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

            }
        });
    }
}

