package com.example.evgeniy.yaltask3.ui.model;

import android.content.Context;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.data.model.AppealEntity;
import com.example.evgeniy.yaltask3.data.model.Performer;
import com.example.evgeniy.yaltask3.data.model.TicketFile;
import com.example.evgeniy.yaltask3.ui.contract.DetailContract;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeniy
 */
public class DetailModel implements DetailContract.DDModel {

    private long mId;
    private String mCategory;
    private String mTitle;
    private String mDescription;
    private Date mCreatedDate;
    private Date mStartDate;
    private Date mDeadline;
    private String mState;
    private List<String> mImageUrls;
    private String mResponsible;

    private DateFormat mFormatter;

    private String mEmptyString;

    public DetailModel(Context context, AppealEntity entity) {

        mEmptyString = context.getString(R.string.emptyString);
        String basePictureUrl = context.getString(R.string.base_picture_url);

        mId = entity.getId();
        mCategory = entity.getCategory().getName();
        mTitle = entity.getTicketId();
        mDescription = entity.getBody();
        mCreatedDate = entity.getCreatedDate();
        mStartDate = entity.getStartDate();
        mDeadline = entity.getDeadline();
        mState = entity.getState().getName();
        mImageUrls = new ArrayList<>();

        for (TicketFile f : entity.getFiles()) {
            mImageUrls.add(basePictureUrl + f.getFilename().trim());
        }

        List<Performer> performerList = entity.getPerformers();
        mResponsible = (!performerList.isEmpty()) ? performerList.get(0).getOrganization() : mEmptyString;

        mFormatter = android.text.format.DateFormat.getMediumDateFormat(context);
    }

    @Override
    public long getId() {
        return mId;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public String getState() {
        return mState;
    }

    @Override
    public List<String> getUrlList() {
        return mImageUrls;
    }

    @Override
    public String getDescription() {
        return mDescription;
    }

    @Override
    public String getResponsible() {
        return mResponsible;
    }

    @Override
    public String getCategory() {
        return mCategory;
    }

    @Override
    public String getStartDate() {
        return (mStartDate != null) ? mFormatter.format(mStartDate) : mEmptyString;
    }

    @Override
    public String getCreatedDate() {
        return (mCreatedDate != null) ? mFormatter.format(mCreatedDate) : mEmptyString;
    }

    @Override
    public String getDeadline() {
        return (mDeadline != null) ? mFormatter.format(mDeadline) : mEmptyString;
    }
}
