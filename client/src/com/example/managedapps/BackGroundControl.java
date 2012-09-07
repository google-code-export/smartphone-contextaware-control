package com.example.managedapps;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.IBinder;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.widget.Toast;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import android.content.Context;

public class BackGroundControl extends Service {
	private boolean isRunning;

	class goThread extends Thread {

		private Handler handler;
		private String[] items = { "백그라운드 돌아간다!", "잘돌아가는구나!" };
		

		public goThread(Handler handler) {
			this.handler = handler;
		}

		public void run() {
			int n = 0;
			while (!isRunning) {
				Message msg = new Message();
				msg.what = 0;
				msg.obj = items[n];
				handler.sendMessage(msg);
				try {
					sleep(100000);
				} catch (Exception e) {
				}
				n++;
				if (n >= items.length)
					n = 0;
			}
		}
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				String str = (String) msg.obj;
				Toast.makeText(BackGroundControl.this, str, Toast.LENGTH_SHORT)
						.show();
			}
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(BackGroundControl.this, "제어를 종료합니다.", Toast.LENGTH_LONG)
				.show();
		isRunning = true;
	}

	@Override
	public int onStartCommand(Intent intent, int flage, int startId) {
		super.onStartCommand(intent, flage, startId);
		isRunning = false;
		goThread bgc = new goThread(handler);
		bgc.start();
		return START_STICKY;
	}
	
	//와이파이 유지
	public void wifiss(){
		WifiManager.WifiLock wifiLock = null;
		//등록
		if (wifiLock == null) {
		    WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
			wifiLock = wifiManager.createWifiLock("wifilock");
			wifiLock.setReferenceCounted(true);
			wifiLock.acquire();
		}
		//해제
		if (wifiLock != null) {
		                wifiLock.release();
			wifiLock = null;
		}
	}
	
	public void wifidd(){
		PowerManager.WakeLock wakeLock = null;
		//등록
		if (wakeLock == null) {
			PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
			wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "wakelock");
			wakeLock.acquire();
		}
		//해제
		if (wakeLock != null) {
			wakeLock.release();
			wakeLock = null;
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
