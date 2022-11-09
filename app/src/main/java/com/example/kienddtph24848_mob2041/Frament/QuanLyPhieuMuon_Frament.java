package com.example.kienddtph24848_mob2041.Frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kienddtph24848_mob2041.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class QuanLyPhieuMuon_Frament extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_qlphieumuon,container,false);

        RecyclerView recyclerQLPhieuMuon = view.findViewById(R.id.recycelQLPhieuMuon);
        FloatingActionButton floatADD = view.findViewById(R.id.floatADD);

        return view;

    }
}
