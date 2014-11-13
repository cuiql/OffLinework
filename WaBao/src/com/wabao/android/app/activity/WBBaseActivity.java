package com.wabao.android.app.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

import com.wabao.android.app.R;

public class WBBaseActivity extends FragmentActivity {

	protected Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mContext = this;

	}

	protected void setTitle(String title) {

		TextView titleTextView = (TextView) findViewById(R.id.title);
		if (titleTextView == null) {

			Log.e("SetTitle", "not include title");
			return;
		}
		titleTextView.setText(title);

	}

	protected void jumpToActivity(Class<?> cls) {
		Intent intent = new Intent();
		intent.setClass(mContext, cls);

		startActivity(intent);
	}

}
