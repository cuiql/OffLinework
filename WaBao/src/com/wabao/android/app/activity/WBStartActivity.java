package com.wabao.android.app.activity;

import android.content.Intent;
import android.os.Bundle;

import com.wabao.android.app.util.SharedPreferencesManager;

public class WBStartActivity extends WBBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferencesManager preManager = new SharedPreferencesManager(this);

		if (preManager.isFirstStart()) {
			showIntroductionView();
		} else if (preManager.isLogin()) {
			showLoadingView();
		} else {
			showLoginView();
		}

	}

	private void showIntroductionView() {
		Intent intent = new Intent();
		intent.setClass(this, WBIntroductionActivity.class);
		startActivity(intent);
		finish();
	}

	private void showLoadingView() {

	}

	private void showLoginView() {
		Intent intent = new Intent();
		intent.setClass(this, WBLoginActivity.class);

		startActivity(intent);

		finish();
	}

}
