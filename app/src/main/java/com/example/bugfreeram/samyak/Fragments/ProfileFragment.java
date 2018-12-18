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

import com.example.bugfreeram.samyak.Adapter.ProfileAdapter;
import com.example.bugfreeram.samyak.Models.ProfileData;
import com.example.bugfreeram.samyak.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ProfileData> movieList;
    private ProfileAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        movieList = new ArrayList<>();
        mAdapter = new ProfileAdapter(this.getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_profile_user);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
       /* recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setNestedScrollingEnabled(false);
*/

        return view;
    }

   /* @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("list", (Serializable) movieList);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {

            movieList = (List<String>) savedInstanceState.getSerializable("list");
        } else {
            if (movieList != null) {
                //returning from backstack, data is fine, do nothing
            } else {
                //newly created, compute data
                movieList = computeData();
            }
        }
    }*/
}