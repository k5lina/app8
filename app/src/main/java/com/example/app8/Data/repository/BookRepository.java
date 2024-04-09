package com.example.app8.Data.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.app8.Data.BookDatabase;
import com.example.app8.Data.model.BookEntity;

import java.util.List;
public class BookRepository {
    private BookDatabase bookDatabase;

    public BookRepository(Application application) {
        bookDatabase = BookDatabase.getDataBase(application);
    }
    public LiveData<List<BookEntity>> getAllBooks() {
        return bookDatabase.bookDao().getAllItems();
    }

    public void addBooks(BookEntity book) {
        BookDatabase.databaseWriterExecutor.execute(() -> {
            bookDatabase.bookDao().insert(book);
        });
    }

}
