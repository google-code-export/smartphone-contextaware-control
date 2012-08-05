package com.example.managedapps;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class LinkPage extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.app_linkpage);
	    // TODO Auto-generated method stub
	}
	
	@Override
	public void onBackPressed() {
		Toast awesomeToast = Toast.makeText(this, "수업중입니다.", Toast.LENGTH_SHORT);
		Toast awesomeToast2 = Toast.makeText(this, "수업에 집중해주세요.", Toast.LENGTH_SHORT);
		awesomeToast.show();
		awesomeToast2.show();
	//해당 엑티비티에서 Back버튼을 눌러도 Back버튼이 동작되지 않도록 하는 메소드
	//아마 이 안에 다른 함수를 넣을경우 백 키를 누를시 다른 기능으로 동작할수 있을것같다. 토스트 출력예정
	//2012-07-31 12:36 - 토스트 출력완료 실험성공
	//서버에서 인증 시작시 키가 먹통이 되도록 해야함
	}
	
	@Override
	public void onAttachedToWindow() {
	    this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
	    super.onAttachedToWindow();
	    //홈키를 제어하는 메소드 동작 방식을 모르겟다 젠장;
	}
}
