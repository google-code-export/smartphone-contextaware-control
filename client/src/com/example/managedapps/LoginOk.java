package com.example.managedapps;

import com.managed.zxing.client.android.CaptureActivity;
import com.managed.zxing.client.android.R;

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
	    // TODO Auto-generated method stub
	}

	public void MyPageBtn(View v) {

	}

	public void qrStart(View v) {
		NetWorkChack();
		if (2 == NetWorkChack()) {
			Intent qrIntent = new Intent(this, CaptureActivity.class);
			startActivity(qrIntent);
		} else if (1 == NetWorkChack()) {
			Toast MbFuck = Toast.makeText(this, "모바일네트워크 안된다, WIFI연결해",
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
			// Toast moBiles = Toast.makeText(this, "梨좎큿怨좎옄紐⑤컮��,
			// Toast.LENGTH_LONG);
			// moBiles.show();
			return MB;
		}

		else if (cons.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
			// Toast WiFis = Toast.makeText(this, "梨좎큿怨좎옄��씠�뚯씠",
			// Toast.LENGTH_SHORT);
			// WiFis.show();
			return WF;
		} else {
			// Toast NoNetwork = Toast.makeText(this, "�명꽣�룹씠 �곌껐�섏뼱�덉� �딆뒿�덈떎.",
			// Toast.LENGTH_LONG);
			// NoNetwork.show();
			return NoNet;
		}
	}
}
