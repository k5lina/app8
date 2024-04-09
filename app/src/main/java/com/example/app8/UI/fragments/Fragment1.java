package com.example.app8.UI.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.app8.Data.FileUtils;
import com.example.app8.Data.SharedPreference;
import com.example.app8.R;
import com.example.app8.UI.viewmodel.MainViewModel;
import com.example.app8.databinding.Fragment1Binding;

import java.util.Random;

public class Fragment1 extends Fragment {
    Fragment1Binding binding;

    private MainViewModel viewViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FileUtils.writeToFile(requireContext(), "example1.txt", "Fragment1");

        boolean successful = FileUtils.writeToExternalStorage("example2.txt", "данные");
        if (successful)
            Log.i("запись", "Данные успешно записаны в файл");
        else
            Log.i("запись", "Произошла ошибка");


        SharedPreference.saveData(requireContext(), "some_data");

        binding = Fragment1Binding.inflate(inflater, container, false);

        viewViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button1.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_bookFragment));

    }
}
