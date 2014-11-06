package com.wabao.android.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wabao.android.app.R;

public class WBBaseActivity extends FragmentActivity {

	protected LinearLayout mContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	protected void setLeftButton(int resourceId, OnClickListener l) {
		ImageButton leftButton = (ImageButton) findViewById(R.id.btn_left);
		if (leftButton == null) {
			Log.e("", "Your didn't include activity_topbar.xml in view");
			return;
		}
		leftButton.setVisibility(View.VISIBLE);
		leftButton.setImageResource(resourceId);
		leftButton.setOnClickListener(l);

	}

	protected void setRightButton(int resourceId, OnClickListener l) {
		ImageButton rightButton = (ImageButton) findViewById(R.id.btn_right);
		if (rightButton == null) {
			Log.e("", "Your didn't include activity_topbar.xml in view");
			return;
		}
		rightButton.setVisibility(View.VISIBLE);
		rightButton.setImageResource(resourceId);
		rightButton.setOnClickListener(l);
	}

	protected void setTitle(String title) {
		TextView titleText = (TextView) findViewById(R.id.title);

		if (titleText == null) {
			Log.e("", "Your didn't include activity_topbar.xml in view");
			return;
		}
		titleText.setText(title);

	}

}
