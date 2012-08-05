package com.example.managedapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginOk extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.app_loginok);
	    // TODO Auto-generated method stub
	}
	//qr코드 스캐너 레이아웃으로 넘기는 인턴트버튼
	//지금 qr스캐너 추가 안했으므로 추가시 LinkPage를 qr스캐너 클래스로 변경해야한다.
	public void qrStart(View v){
		Intent qrStartIntent	=	new Intent(this, LinkPage.class);
		startActivity(qrStartIntent);
	}
	
	@Override
	public void onBackPressed(){
		MainBack();
	}
	
	//로그인후 백 버튼 입력시 화면을 메인페이지넘김 인턴트 로그아웃 기능을 넣어야함
	public void MainBack(){
		Intent logOutIntent	=	new Intent(this, MainPage.class);
		startActivity(logOutIntent);
	}

	//이게 왜있지?
	/*
	public void logOut(View v){
		Intent logOutIntent	=	new Intent(this, MainPage.class);
		startActivity(logOutIntent);
	}*/
}
