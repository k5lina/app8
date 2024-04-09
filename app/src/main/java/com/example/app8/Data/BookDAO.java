package com.example.app8.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.app8.Data.model.BookEntity;

import java.util.List;

@Dao
public interface BookDAO {
    @Query("SELECT * FROM bookentity")
    LiveData<List<BookEntity>> getAllItems();
    @Insert
    void insert(BookEntity entity);
    @Delete
    void delete(BookEntity entity);
}
