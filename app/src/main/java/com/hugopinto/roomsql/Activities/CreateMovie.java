package com.hugopinto.roomsql.Activities;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class CreateMovie extends AppCompatActivity {

    EditText name, studio, category;
    Button btn;

    List<Movie> movies;
    String sname, sstudio, scat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        btn = findViewById(R.id.btnRegistrar);
        name = findViewById(R.id.txtName);
        studio = findViewById(R.id.txtStudio);
        category = findViewById(R.id.txtCat);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString();
                sstudio = studio.getText().toString();
                scat = category.getText().toString();
                AppDatabase db = AppDatabase.getAppDataBase(getApplicationContext());
                db.moviesDAO().insertMovie(new Movies(sname, sstudio, scat));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }





}
