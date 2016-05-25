package com.example.evgeniy.yaltask3.data;


import com.example.evgeniy.yaltask3.R;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeniy
 */
public class AppealEntity implements Serializable {

    @SerializedName("id")
    private long mId;

    @SerializedName("ticket_id")
    private String mNumber;

    @SerializedName("title")
    private String mCategory;

    @SerializedName("state")
    private State mState;

    @SerializedName("created_date")
    private Date mCreated;

    @SerializedName("start_date")
    private Date mRegistered;

    @SerializedName("deadline")
    private Date mDeadline;


    private String mResponsible;

    @SerializedName("body")
    private String mFullText;
    @SerializedName("files")
    private List<String> mImages;


    private int mIconId = R.drawable.ic_build;

    @SerializedName("likes_counter")
    private int mLikeAmount;

    public AppealEntity() {
        mImages = new ArrayList<>();
    }

    public AppealEntity(long id, String number, String category, State state,
                        Date created, Date registered, Date deadline, String responsible,
                        int iconId, int likeAmount,
                        String fullText,
                        List<String> images) {
        mId = id;
        mNumber = number;
        mCategory = category;
        mState = state;
        mCreated = created;
        mRegistered = registered;
        mDeadline = deadline;
        mResponsible = responsible;
        mIconId = iconId;
        mLikeAmount = likeAmount;
        mImages = images;
        mFullText = fullText;
    }


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getFullText() {
        return mFullText;
    }

    public void setFullText(String fullText) {
        mFullText = fullText;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }

    public Date getCreated() {
        return mCreated;
    }

    public void setCreated(Date created) {
        mCreated = created;
    }

    public Date getRegistered() {
        return mRegistered;
    }

    public void setRegistered(Date registered) {
        mRegistered = registered;
    }

    public Date getDeadline() {
        return mDeadline;
    }

    public void setDeadline(Date deadline) {
        mDeadline = deadline;
    }

    public String getResponsible() {
        return mResponsible;
    }

    public void setResponsible(String responsible) {
        mResponsible = responsible;
    }

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int iconId) {
        mIconId = iconId;
    }

    public int getLikeAmount() {
        return mLikeAmount;
    }

    public void setLikeAmount(int likeAmount) {
        mLikeAmount = likeAmount;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void setImages(List<String> images) {
        mImages = images;
    }

    public int getDaysAmount() {
        Date nowDate = new Date();
        int result = 0;
        if (mCreated != null) {
            result = (int) ((nowDate.getTime() - mCreated.getTime()) / (1000 * 24 * 3600));
        }

        return result;
    }
}
