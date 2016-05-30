package com.example.evgeniy.yaltask3.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.ui.contract.AppealListContract;
import com.example.evgeniy.yaltask3.utils.AppealListPresenterHolder;

/**
 * Created by Evgeniy
 */
public class AppealRecyclerFragment extends Fragment implements AppealListContract.ALView {

    private static final String STATE_KEY = "filter";
    private AppealListContract.ALPresenter mPresenter;

    private RecyclerView mRecyclerView;

    public static Fragment getInstance(String state) {

        Fragment fragment = new AppealRecyclerFragment();

        Bundle bundle = new Bundle();
        bundle.putString(STATE_KEY, state);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String mFilter = null;
        Bundle params = getArguments();
        if (params != null) {
            mFilter = params.getString(STATE_KEY, null);
        }
        mPresenter = AppealListPresenterHolder.getPresenter(getContext(), this, mFilter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mPresenter.init();

        return mRecyclerView;
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);

    }
}
