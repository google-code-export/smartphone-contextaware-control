package com.example.managedapps;

import com.managed.zxing.client.android.R;

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
	    setContentView(R.layout.loginpage);
	    // TODO Auto-generated method stub
	}

	String Id = "h";
	String Pw = "123";

	public void login_Click(View v) {
		login_check();

	}

	public void login_check() {

		EditText IdEt = (EditText) findViewById(R.id.IdText);
		EditText PwEt = (EditText) findViewById(R.id.PwText);
		String IdText = IdEt.getText().toString();
		String PwText = PwEt.getText().toString();


		if (IdText.equals(Id) && PwText.equals(Pw)) {
			Intent loginOk = new Intent(this, LoginOk.class);
			startActivity(loginOk);
		} else {
			Toast loginFalse = Toast.makeText(this, "ID �뱀� PW媛��ㅻ쫭�덈떎..",
					Toast.LENGTH_SHORT);
			loginFalse.show();
		}
	}
	
	public void CloseBtn2(View v){
		moveTaskToBack(true);
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}
