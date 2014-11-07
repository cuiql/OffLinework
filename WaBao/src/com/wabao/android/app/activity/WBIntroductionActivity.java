package com.wabao.android.app.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wabao.android.app.R;

public class WBIntroductionActivity extends WBBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_introduction);

		Timer timer = new Timer();

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent();
				intent.setClass(WBIntroductionActivity.this,
						WBLoginActivity.class);
				startActivity(intent);
				finish();

			}

		}, 3000);
	}

}
