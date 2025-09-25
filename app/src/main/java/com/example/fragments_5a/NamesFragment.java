package com.example.fragments_5a;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NamesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NamesFragment extends ListFragment {

    OnNameClicked parent;

    public interface OnNameClicked{
        public void onClick(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parent = (OnNameClicked) context;
    }

    public NamesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_names, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setListAdapter(new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, names));

        setListAdapter(new PassengerAdapter(requireContext(), R.layout.single_passenger_item_design, MyApplication.passengers));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        parent.onClick(position);
    }
}