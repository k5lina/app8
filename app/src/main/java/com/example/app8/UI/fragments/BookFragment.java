package com.example.app8.UI.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app8.UI.adapters.BookAdapter;
import com.example.app8.UI.viewmodel.MainViewModel;
import com.example.app8.databinding.FragmentBookBinding;


public class BookFragment extends Fragment {
    FragmentBookBinding binding;

    private MainViewModel viewViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBookBinding.inflate(inflater);

        binding.listBooks.setLayoutManager(new LinearLayoutManager(requireContext()));
        BookAdapter adapter = new BookAdapter();
        binding.listBooks.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(v ->
                viewViewModel.addBook(binding.editTextBookName.getText().toString())
        );

        viewViewModel.getAllBooks().observe(getViewLifecycleOwner(), books ->
                adapter.setBookEntities(books));
        return binding.getRoot();
    }
}
