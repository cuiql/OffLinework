package com.wabao.android.app.activity;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONArray;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.wabao.android.app.R;

public class WBLoginActivity extends WBBaseActivity {

	private AlertDialog mProcessDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);

		mActionBar.hide();

		setTitle(getString(R.string.title_login_activity));

		View login = findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				doLogin();

			}

		});

		RequestQueue requestQuene = Volley.newRequestQueue(this);

		JsonArrayRequest request = new JsonArrayRequest(
				"http://115.28.211.84/lamgod/promotion/get/all",
				new Response.Listener<JSONArray>() {

					@Override
					public void onResponse(JSONArray response) {
						System.out.println(response);

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						System.out.println(error);

					}
				});

		requestQuene.add(request);
	}

	private void doLogin() {
		mProcessDialog = new ProgressDialog(this);

		mProcessDialog.setMessage("登录中...");

		mProcessDialog.show();

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent();
				intent.setClass(WBLoginActivity.this, WBMainActivity.class);
				WBLoginActivity.this.startActivity(intent);
				mProcessDialog.dismiss();
				finish();
			}

		}, 3000);
	}

}
