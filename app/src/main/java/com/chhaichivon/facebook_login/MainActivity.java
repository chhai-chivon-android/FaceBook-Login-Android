package com.chhaichivon.facebook_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

	LoginButton loginButton;
	CallbackManager  callbackManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FacebookSdk.sdkInitialize(getApplicationContext());
		setContentView(R.layout.activity_main);


		loginButton = (LoginButton) findViewById(R.id.login_button);
		callbackManager = CallbackManager.Factory.create();

		loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				Toast.makeText(MainActivity.this, loginResult.getAccessToken().getUserId(), Toast.LENGTH_LONG).show();
			}

			@Override
			public void onCancel() {
				Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onError(FacebookException error) {
				Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
			}
		});
	}
}
