package com.example.evgeniy.yaltask3.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.ui.contract.FacebookAccountContract;
import com.example.evgeniy.yaltask3.ui.presenter.FacebookAccountPresenter;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Evgeniy
 */
public class FacebookAccountActivity extends AppCompatActivity implements FacebookAccountContract.FView {

    @BindView(R.id.logout_btn)
    Button mBtnLogout;

    @BindView(R.id.profile_picture)
    ProfilePictureView mProfilePictureView;

    @BindView(R.id.user_name)
    TextView mTvName;

    private FacebookAccountContract.FPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook_account);
        ButterKnife.bind(this);

        mPresenter = new FacebookAccountPresenter(this, this);
        mPresenter.onCreate();
    }

    public void updateViews(Profile currentProfile) {
        mProfilePictureView.setProfileId(currentProfile.getId());
        mTvName.setText(currentProfile.getName());
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.logout_btn)
    public void onClickBtnLogout() {
        mPresenter.logOut();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

}
