package com.example.bugfreeram.samyak.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bugfreeram.samyak.Activity.CameraDemo;
import com.example.bugfreeram.samyak.Activity.GroupInfo;
import com.example.bugfreeram.samyak.Activity.JoinGroup;
import com.example.bugfreeram.samyak.Activity.SelectImage;
import com.example.bugfreeram.samyak.Adapter.GroupAdapter;
import com.example.bugfreeram.samyak.Models.GroupData;
import com.example.bugfreeram.samyak.R;

import java.util.ArrayList;
import java.util.List;

public class GroupFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<GroupData> movieList;
    private GroupAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_group_fragment, container, false);
        movieList = new ArrayList<>();
        mAdapter = new GroupAdapter(this.getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_group);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        TextView tv_create_group = (TextView) view.findViewById(R.id.tv_create_group);
        tv_create_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreateGroup = new Intent(getActivity(), SelectImage.class);
                startActivity(intentCreateGroup);
            }
        });
        TextView tv_join_group = (TextView) view.findViewById(R.id.tv_join_group);
        tv_join_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreateGroup = new Intent(getActivity(), JoinGroup.class);
                startActivity(intentCreateGroup);
            }
        });
        return view;
    }
}