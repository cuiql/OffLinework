package com.wabao.android.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.wabao.android.app.R;

public class WBDetailActivity extends WBBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_detail);

		setTitle("活动详细");

		Button joinAnswer = (Button) findViewById(R.id.join_answer);

		joinAnswer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(WBDetailActivity.this,
						WBQuestionnaireActivity.class);
				startActivity(intent);

			}
		});
	}

}
