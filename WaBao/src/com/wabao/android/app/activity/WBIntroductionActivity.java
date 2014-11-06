package com.wabao.android.app.activity;

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
		
		Button start = (Button)findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(WBIntroductionActivity.this,WBLoginActivity.class);
				startActivity(intent);
				
			}
			
		});
	}
	
	

}
