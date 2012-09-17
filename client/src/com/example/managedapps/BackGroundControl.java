package com.example.managedapps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

public class BackGroundControl extends Service {
	private boolean isRunning;
	
	Thread mThread;

	ArrayList<String> mPackageFilter;
	private static boolean mPassApp = false;

	private final static String TAG = "App_log";

	public void runLog() {
		
		Process process = null;
		Log.i(TAG, "run");
		try {
			Runtime.getRuntime().exec("/system/bin/logcat -c"); // 로그 플러쉬
			process = Runtime.getRuntime().exec(
					"/system/bin/logcat -b main -s ActivityManager:I");
			// 로그캣으로 ActivityManager로 시작하는 Info 로그를 찾아서 프로세스에 저장.
			Log.i(TAG, getPackageName());
		} catch (IOException e) {
			Log.e(getPackageName(), e.toString());
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					process.getInputStream())); // 프로세스 실행정보..
			Log.i(TAG, "" + reader);
			String line;
			// 프로세스 검사
			while (!isRunning) {
				line = reader.readLine();
				Log.i(TAG, line);

				if (!line.contains("Starting: Intent")) { 
					// 인텐트 전환이 아닌것에 대해서는패스
					mPassApp = true;
				} else {
					// 화이트리스트 목록에 현재 프로세스가 있는지 검사.
					for (int i = 0; i < mPackageFilter.size(); i++) {
						if (line.contains("cmp=" + mPackageFilter.get(i))) { 
							// 필터에 있을때 아래 실행
							mPassApp = true;
							break; // 이미 true 로 바뀌었기 때문에 더이상의 검사는 무의미
						}
					}
				}

				if (!mPassApp) {
					popupLock(); // 백그라운드!
					Log.i(TAG, "background");
					mPassApp = true;
				} else {
					mPassApp = false;
				}
			}
		} catch (IOException e) {
			Log.e(getPackageName(), e.toString());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				Log.e(getPackageName(), e.toString());
			}
			process.destroy();
			process = null;
			reader = null;
		}
	}

	public void popupLock() { // 이게 백그라운드로 날리는 명령.
		Intent i = new Intent();
		i.setAction(Intent.ACTION_MAIN);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		i.addCategory(Intent.CATEGORY_HOME);
		startActivity(i);

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

	Runnable worker = new Runnable() {
		public void run() {
			runLog();
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		isRunning = false;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(BackGroundControl.this, "제어를 종료합니다.", Toast.LENGTH_LONG)
				.show();
		isRunning = true;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		Log.i(TAG, "Service Start1111");
		// run
		//mPackageFilter = intent.getStringArrayListExtra("PACKAGE_FILTER");
		// 실행가능한 패키지 리스트 가져옴
		

		mPackageFilter = new ArrayList<String>();
		mPackageFilter.add("com.android.browser");
		mPackageFilter.add("com.android.launcher");
		// mPackageFilter.add("com.kakao.talk/.Kakaotalk");
		mPackageFilter.add("com.android.settings/.Settings");


		mThread = new Thread(worker); // 스레드 생성
		mThread.setDaemon(true); // 데몬으로 설정
		mThread.start();
		return START_REDELIVER_INTENT;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
