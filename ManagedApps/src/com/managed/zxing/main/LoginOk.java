package com.managed.zxing.main;

import com.managed.zxing.client.android.*;
import com.managed.zxing.main.MainPage;
import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginOk extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginok);
	}

	public void MyPageBtn(View v) {

	}

	public void qrStart(View v) {
		NetWorkChack();
		if (2 == NetWorkChack()) {
			Intent qrIntent = new Intent(this, CaptureActivity.class);
			startActivity(qrIntent);
		} else if (1 == NetWorkChack()) {
			Toast MbFuck = Toast.makeText(this, "모바일네트워크다, WIFI써라",
					Toast.LENGTH_LONG);
			MbFuck.show();
		}
	}

	public int NetWorkChack() {
		int MB = 1;
		int WF = 2;
		int NoNet = 0;
		ConnectivityManager cons = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

		if (cons.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) {
			// Toast moBiles = Toast.makeText(this, "챠촌고자모바일",
			// Toast.LENGTH_LONG);
			// moBiles.show();
			return MB;
		}

		else if (cons.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
			// Toast WiFis = Toast.makeText(this, "챠촌고자와이파이",
			// Toast.LENGTH_SHORT);
			// WiFis.show();
			return WF;
		} else {
			// Toast NoNetwork = Toast.makeText(this, "인터넷이 연결되어있지 않습니다.",
			// Toast.LENGTH_LONG);
			// NoNetwork.show();
			return NoNet;
		}
	}
}
