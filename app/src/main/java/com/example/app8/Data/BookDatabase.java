package com.example.app8.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app8.Data.model.BookEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    public abstract BookDAO bookDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static BookDatabase getDataBase(final Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                BookDatabase.class, "book_database").build();
    }
}
