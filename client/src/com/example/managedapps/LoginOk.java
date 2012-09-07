package com.example.managedapps;

import com.managed.zxing.client.android.CaptureActivity;
import com.managed.zxing.client.android.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginOk extends Activity {

	public String s_dns1;
	public String s_dns2;
	public String s_gateway;
	public String s_ipAddress;
	public String s_leaseDuration;
	public String s_netmask;
	public String s_serverAddress;
	TextView info;
	DhcpInfo d;
	WifiManager wifii;

	public String temp_gateway = "192.168.0.1";
	public String temp_serverAdress = "192.168.0.2"; 
	//통상적으로 게이트웨이와 서버아이피는 같음.일반 가정에서도 가상ip를 통해 악용할수 있으니 보완이 시급
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginok);
	}

	public void qrStart(View v) {
		
		Intent qrIntent = new Intent(this, CaptureActivity.class);
		startActivity(qrIntent);
		/*
		NetWorkChack();
		dhcpInfo();

		if (2 == NetWorkChack()) {
			if (s_gateway.equals(temp_gateway) && s_serverAddress.equals(temp_serverAdress)) {
				Intent qrIntent = new Intent(this, CaptureActivity.class);
				startActivity(qrIntent);
			} else {
				Toast MbFuck = Toast.makeText(this, "지정된 wifi가 아닙니다.",
						Toast.LENGTH_LONG);
				MbFuck.show();
			}
		} 
		else if (1 == NetWorkChack()) {
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
		}*/
	}

	public void dhcpInfo() {

		wifii = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		d = wifii.getDhcpInfo();

		s_dns1 = FormatIP(d.dns1);
		s_dns2 = FormatIP(d.dns2);
		s_gateway = FormatIP(d.gateway);
		s_ipAddress = FormatIP(d.ipAddress);
		s_leaseDuration = FormatIP(d.leaseDuration);
		s_netmask = FormatIP(d.serverAddress);
		s_serverAddress = FormatIP(d.serverAddress);
	}

	public String FormatIP(int IpAddress) {
		return Formatter.formatIpAddress(IpAddress);
	}
	
	
	public void conBtn(View v){
		Intent intent	=	new Intent(LoginOk.this, BackGroundControl.class);
		startService(intent);
	}
	
	public void btn2(View v){
		Intent intent	=	new Intent(LoginOk.this, BackGroundControl.class);
		stopService(intent);
	}
}

