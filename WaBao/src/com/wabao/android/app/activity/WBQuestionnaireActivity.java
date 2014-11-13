package com.wabao.android.app.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.wabao.android.app.R;

public class WBQuestionnaireActivity extends WBBaseActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_questionnaire);

		ImageView back = (ImageView) findViewById(R.id.back);

		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}

		});

		ImageView question1 = (ImageView) findViewById(R.id.imageView1);
		ImageView question2 = (ImageView) findViewById(R.id.imageView2);
		ImageView question3 = (ImageView) findViewById(R.id.imageView3);
		ImageView question4 = (ImageView) findViewById(R.id.imageView4);
		ImageView question5 = (ImageView) findViewById(R.id.imageView5);
		ImageView question6 = (ImageView) findViewById(R.id.imageView6);
		ImageView question7 = (ImageView) findViewById(R.id.imageView7);

		question1.setOnClickListener(this);
		question2.setOnClickListener(this);
		question3.setOnClickListener(this);
		question4.setOnClickListener(this);
		question5.setOnClickListener(this);
		question6.setOnClickListener(this);
		question7.setOnClickListener(this);

	}

	private void showPopup() {
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View contentView = inflater.inflate(R.layout.dialog_question, null);

		final PopupWindow mPopupWindow = new PopupWindow(contentView,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);

		mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_bg));
		mPopupWindow.update();

		mPopupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
		
		contentView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				mPopupWindow.dismiss();
				
			}
			
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageView1:
		case R.id.imageView2:
		case R.id.imageView3:
		case R.id.imageView4:
		case R.id.imageView5:
		case R.id.imageView6:
		case R.id.imageView7:
			showPopup();
			break;

		}

	}

}
