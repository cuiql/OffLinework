package com.wabao.android.app.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class WBBaseActivity extends FragmentActivity {

	protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContext = this;

	}

	protected void setTitle(String title) {

		if (title == null) {
			return;
		}

	}

	protected void jumpToActivity(Class<?> cls) {
		Intent intent = new Intent();
		intent.setClass(mContext, cls);

		startActivity(intent);
	}

}
