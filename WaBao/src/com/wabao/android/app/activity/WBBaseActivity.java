package com.wabao.android.app.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wabao.android.app.R;

public class WBBaseActivity extends FragmentActivity {

	protected LinearLayout mContainer;

	protected ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActionBar = getActionBar();
		// 设置ActionBar左边默认的图标是否可用
		mActionBar.setDisplayShowHomeEnabled(false);

		mActionBar.setBackgroundDrawable(this.getResources().getDrawable(
				R.drawable.action_bar_bg));

	}

	protected void setTitle(String title) {

		if (title == null) {
			return;
		}
		mActionBar.setTitle(title);

	}

}
