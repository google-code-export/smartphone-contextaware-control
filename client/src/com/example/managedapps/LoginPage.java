package com.example.managedapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.app_login);
	
	    // TODO Auto-generated method stub
	}
		String Id	=	"h";
		String Pw	=	"123";

	public void login_Click(View v){
		login_check();
	
	}

	public void login_check(){
	
		EditText IdEt = (EditText)findViewById(R.id.IdText);
		EditText PwEt = (EditText)findViewById(R.id.PwText);
		String IdText	=	IdEt.getText().toString();
		String PwText	=	PwEt.getText().toString();
	
	//지금 로그인 기능을 확인겸 클릭버튼안에 그냥 다 때려박았다. 각 함수로 수정요망
	
		if(IdText.equals(Id) && PwText.equals(Pw)){
			Intent loginOk	=	new Intent(this, LoginOk.class);
			startActivity(loginOk);
		}
		else{
			Toast loginFalse = Toast.makeText(this, "아이디 혹은 비밀번호가 다릅니다.", Toast.LENGTH_SHORT);
			loginFalse.show();
		}	
	}
}
