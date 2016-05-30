package com.example.evgeniy.yaltask3.ui.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.activities.DetailActivity;
import com.example.evgeniy.yaltask3.adapters.AppealRecyclerAdapter;
import com.example.evgeniy.yaltask3.data.model.AppealEntity;
import com.example.evgeniy.yaltask3.ui.contract.AppealListContract;
import com.example.evgeniy.yaltask3.ui.contract.DetailContract;
import com.example.evgeniy.yaltask3.ui.model.AppealListModel;
import com.example.evgeniy.yaltask3.ui.model.DetailModel;

import java.util.List;

/**
 * Created by Evgeniy
 */
public class AppealListPresenter implements  AppealListContract.ALPresenter, AppealRecyclerAdapter.OnItemClickListener {

    AppealListContract.ALModel mModel;
    AppealListContract.ALView mView;
    Context mContext;

    AppealRecyclerAdapter mAppealAdapter;

    private boolean mLoading;

    public AppealListPresenter(Context context, AppealListContract.ALView view, String filter) {
        mView = view;
        mContext = context;
        mAppealAdapter = new AppealRecyclerAdapter(context, this);
        mModel = new AppealListModel(context, filter);
    }

    @Override
    public void init() {

   mModel.getCachedData(new AppealListContract.ALModel.Callback() {
            @Override
            public void getResult(List<AppealEntity> data) {
                mAppealAdapter.addAll(data);
                                mAppealAdapter.notifyDataSetChanged();

                                        mLoading = false;
            }
        });


        mView.setAdapter(mAppealAdapter);
        if (mAppealAdapter.size() == 0) {
            getNextPage();
        }
    }

    @Override
    public void getNextPage() {
        mLoading = true;

        mAppealAdapter.add(null);
        final int nullPosition = mAppealAdapter.size() - 1;
        mAppealAdapter.notifyItemInserted(nullPosition);

        mModel.getDataPage(false, new AppealListContract.ALModel.Callback() {
            @Override
            public void getResult(List<AppealEntity> data) {

                mAppealAdapter.remove(nullPosition);

                for (AppealEntity entity : data) {
                    if (!mAppealAdapter.contains(entity)) {
                        mAppealAdapter.add(entity);
                    }
                }
                mAppealAdapter.notifyDataSetChanged();
                mLoading = false;
            }
        });
    }

    @Override
    public void onItemClick(AppealEntity entity) {

        DetailContract.DDModel model = new DetailModel(mContext, entity);

        Intent intent = new Intent(mContext, DetailActivity.class);
        intent.putExtra(mContext.getString(R.string.key_for_entity), model);
        mContext.startActivity(intent);
    }
}
