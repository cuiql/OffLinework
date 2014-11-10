package com.wabao.android.app.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.wabao.android.app.entity.VersionInfo;

public class SharedPreferencesManager {

    private SharedPreferences mSharePre;

    private static final String KEY_IS_LOGIN = "key_is_login";
    private static final String KEY_IS_FIRST_START = "key_is_first_start";
    private static final String TAG = "SharedPreferencesManager";
    private static final String KEY_USER_ID = "key_user_id";

    private static final String KEY_SERVER_VERSION_ID = "key_server_version_id";
    private static final String KEY_SERVER_VERSION_DESCRIPTION = "key_server_version_description";
    private static final String KEY_SERVER_VERSION_PUBLISH_DATE = "key_server_version_publish_date";

    public SharedPreferencesManager(Context ctx) {
        mSharePre = PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public boolean isLogin() {
        return mSharePre.getBoolean(KEY_IS_LOGIN, false);

    }

    public void setLogined(boolean isLogin) {
        boolean result = mSharePre.edit().putBoolean(KEY_IS_LOGIN, isLogin)
                .commit();

        if (!result) {
            Log.e(TAG, "setLogined failed");
        }
    }

    public boolean isFirstStart() {
        return mSharePre.getBoolean(KEY_IS_FIRST_START, true);
    }

    public void setFirstStart(boolean isFirstStart) {
        boolean result = mSharePre.edit()
                .putBoolean(KEY_IS_FIRST_START, isFirstStart).commit();

        if (!result) {
            Log.e(TAG, "setFirstStart failed");
        }
    }

    public void saveUserId(String userId) {
        boolean result = mSharePre.edit().putString(KEY_USER_ID, userId)
                .commit();

        if (!result) {
            Log.e(TAG, "save user id failed");
        }
    }

    public void saveNewVersionInfo(VersionInfo versionInfo) {
        mSharePre
                .edit()
                .putString(KEY_SERVER_VERSION_ID, versionInfo.getVersionId())
                .putString(KEY_SERVER_VERSION_DESCRIPTION,
                        versionInfo.getDescription())
                .putLong(KEY_SERVER_VERSION_PUBLISH_DATE,
                        versionInfo.getPublishDate()).commit();

    }

    public VersionInfo getNewVersionInfo() {

        String versionId = mSharePre.getString(KEY_SERVER_VERSION_ID,
                Constants.CURRENT_VERSION);
        String des = mSharePre.getString(KEY_SERVER_VERSION_DESCRIPTION, "");
        long date = mSharePre.getLong(KEY_SERVER_VERSION_PUBLISH_DATE, 0);
        VersionInfo info = new VersionInfo(versionId, des, date);

        return info;
    }

}
