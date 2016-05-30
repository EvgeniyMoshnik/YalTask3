package com.example.evgeniy.yaltask3.ui.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.data.model.AppealEntity;
import com.example.evgeniy.yaltask3.ui.contract.AppealListContract;
import com.example.evgeniy.yaltask3.utils.ServiceApiHolder;
import com.example.evgeniy.yaltask3.utils.TicketService;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Evgeniy
 */
public class AppealListModel implements AppealListContract.ALModel {

    public static final String ERROR_TAG = "RETROFIT ERROR";

    private String mFilter;

    private long[] mQueryFilter;

    private TicketService mTicketService;
    private Realm mRealmService;

    private int mPageSize;
    private int mOffset;

    public AppealListModel(Context contex, String filter) {

        Context context = contex;
        mFilter = filter;

        if (!TextUtils.isEmpty(mFilter)) {

            String[] filterParts = mFilter.split(context.getString(R.string.str_filter_delimiter));

            mQueryFilter = new long[filterParts.length];
            for (int i = 0; i < filterParts.length; i++) {
                mQueryFilter[i] = Long.parseLong(filterParts[i]);
            }

            mTicketService = ServiceApiHolder.getTicketService(context);
            mRealmService = ServiceApiHolder.getRealmService(context);

            mPageSize = context.getResources().getInteger(R.integer.data_page_size);
            mOffset = 0;

        }
    }

        @Override
        public void getDataPage(boolean first, final Callback callback) {
            if (first) {
                mRealmService.executeTransactionAsync(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmQuery<AppealEntity> query = getIssueEntityRealmQuery(realm);
                        query.findAll().deleteAllFromRealm();
                    }
                });
                mOffset = 0;
            }

            Call<List<AppealEntity>> call = mTicketService.getListByStateFilter(mFilter, mPageSize, mOffset);

            call.enqueue(new retrofit2.Callback<List<AppealEntity>>() {
                @Override
                public void onResponse(Call<List<AppealEntity>> call, Response<List<AppealEntity>> response) {
                    final List<AppealEntity> result = response.body();

                    mOffset += result.size();

                    mRealmService.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.copyToRealmOrUpdate(result);
                        }
                    });
                    callback.getResult(result);
                }

            @Override
            public void onFailure(Call<List<AppealEntity>> call, Throwable t) {
                Log.d(ERROR_TAG, t.getLocalizedMessage());
                callback.getResult(new ArrayList<AppealEntity>());
            }
        });
    }

    @Override
    public void getCachedData(final Callback callback) {

        RealmQuery<AppealEntity> query = getIssueEntityRealmQuery(mRealmService);
        RealmResults<AppealEntity> result = query.findAll();
        mOffset = result.size();
        callback.getResult(result);
    }

    @NonNull
    private RealmQuery<AppealEntity> getIssueEntityRealmQuery(Realm realm) {
        RealmQuery<AppealEntity> query = realm.where(AppealEntity.class);
        if (mQueryFilter != null) {
            boolean nonFirst = false;
            for (long param : mQueryFilter) {
                if (nonFirst) query.or();
                nonFirst = true;
                query.equalTo("state.id", param);
            }
        }

        return query;
    }

}
