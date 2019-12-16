package com.example.siangmalam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.siangmalam.R;

public class HomeFragmentUser extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SQLiteHelper dbHelper;
    private FoodAdapterUser adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        populaterecyclerView();
        return view;
    }


    private void populaterecyclerView(){
        dbHelper = new SQLiteHelper(getActivity());
        adapter = new FoodAdapterUser(dbHelper.foodList(),getActivity(), mRecyclerView);
        mRecyclerView.setAdapter(adapter);

    }
}
