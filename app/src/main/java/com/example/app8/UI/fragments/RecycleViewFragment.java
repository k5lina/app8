package com.example.app8.UI.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app8.UI.adapters.BookAdapter;
import com.example.app8.UI.viewmodel.MainViewModel;
import com.example.app8.databinding.FragmentRecyclerViewBinding;

public class RecycleViewFragment extends Fragment {
    FragmentRecyclerViewBinding binding;
    private MainViewModel mainViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String data = getArguments().getString("key");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        BookAdapter adapter = new BookAdapter();
        binding.recyclerView.setAdapter(adapter);
    }
}
