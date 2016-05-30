package com.example.evgeniy.yaltask3.utils;

import android.content.Context;

import com.example.evgeniy.yaltask3.ui.contract.AppealListContract;
import com.example.evgeniy.yaltask3.ui.presenter.AppealListPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeniy
 */
public class AppealListPresenterHolder {

    private static Map<AppealListContract.ALView, AppealListContract.ALPresenter> sPresenters;

    public static AppealListContract.ALPresenter getPresenter(Context context, AppealListContract.ALView view, String filter) {

        if (sPresenters == null) {
            sPresenters = new HashMap<>();
        }

        AppealListContract.ALPresenter result = sPresenters.get(view);

        if (result == null) {
            result = new AppealListPresenter(context, view, filter);
            sPresenters.put(view, result);
        }

        return result;
    }
}
