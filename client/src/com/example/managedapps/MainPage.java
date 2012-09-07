package com.example.managedapps;

import com.managed.zxing.client.android.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainPage extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mainpage);
	    // TODO Auto-generated method stub
	}
	public void login_Page(View v){
		Intent loginPageIntent	=	new Intent(this, LoginPage.class);
		startActivity(loginPageIntent);
		finish();
	}
	public void CloseBtn(View v){
		moveTaskToBack(true);
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}
