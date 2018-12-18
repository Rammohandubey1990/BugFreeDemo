package com.example.bugfreeram.samyak.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bugfreeram.samyak.Adapter.TransAdapter;
import com.example.bugfreeram.samyak.Models.TransData;
import com.example.bugfreeram.samyak.R;

import java.util.ArrayList;
import java.util.List;

public class Transaction_History extends Fragment {

    private RecyclerView rv_transaction;
    private List<TransData> transList;
    private TransAdapter transAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        transList = new ArrayList<>();
        transAdapter = new TransAdapter(this.getActivity());
        rv_transaction = (RecyclerView) view.findViewById(R.id.rv_transaction);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        rv_transaction.setLayoutManager(mLayoutManager);
        rv_transaction.setItemAnimator(new DefaultItemAnimator());
        rv_transaction.setAdapter(transAdapter);
/*        rv_transaction.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        rv_transaction.setNestedScrollingEnabled(false);*/


        return view;
    }

}
