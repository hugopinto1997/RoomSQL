package com.hugopinto.roomsql.Classes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.hugopinto.roomsql.Adapter.Movie

@Database(entities = {Movie.class}, version = 1)
public class AppDatabase {
    private static AppDatabase INSTANCE;
    public abstract MoviesDAO moviesDAO();

    public static AppDatabase getAppDataBase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "movies-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
