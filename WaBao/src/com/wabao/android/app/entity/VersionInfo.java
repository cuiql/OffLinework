package com.wabao.android.app.entity;

public class VersionInfo {

    private String mVersionId;

    private String mDescription;

    private long mPublishDate;

    public VersionInfo(String versionId, String des, long publishdate) {
        mVersionId = versionId;
        mDescription = des;
        mPublishDate = publishdate;
    }

    public String getVersionId() {
        return mVersionId;

    }

    public String getDescription() {
        return mDescription;
    }

    public long getPublishDate() {
        return mPublishDate;
    }

}
