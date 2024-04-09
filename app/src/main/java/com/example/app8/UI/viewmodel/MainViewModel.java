package com.example.app8.UI.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.app8.Data.model.BookEntity;
import com.example.app8.Data.repository.BookRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    BookRepository bookRepository;

    public LiveData<List<BookEntity>> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String name) {
        bookRepository.addBooks(new BookEntity(name));
    }

    public MainViewModel(@NonNull Application application) {
        super(application);

        bookRepository = new BookRepository(application);
    }

}
