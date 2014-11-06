package com.wabao.android.app.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferencesManager {

	private SharedPreferences mSharePre;

	private static final String KEY_IS_LOGIN = "key_is_login";
	private static final String KEY_IS_FIRST_START = "key_is_first_start";
	private static final String TAG = "SharedPreferencesManager";

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

}
