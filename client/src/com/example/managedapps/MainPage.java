package com.example.managedapps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainPage extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_main, menu);
        return true;
    }
    
    public void login_Page(View v){
    	Intent loginPageIntent =	new Intent(this, LoginPage.class);
    	startActivity(loginPageIntent);
    } //로그인페이지로 넘기는 인턴트

}

