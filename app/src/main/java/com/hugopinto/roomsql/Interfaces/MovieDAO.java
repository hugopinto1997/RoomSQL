package com.hugopinto.roomsql.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.hugopinto.roomsql.Adapter.Movie;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDAO {

    @Query("SELECT * FROM MOVIES")
    List<Movie> getALL();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movie movie);

}
