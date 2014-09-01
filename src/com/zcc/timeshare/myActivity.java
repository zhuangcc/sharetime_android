package com.zcc.timeshare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class myActivity extends Activity {
	private HashMap<String,String>session;
	String userid;
	String username;
	String sessionid;
	 @SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.my);
	       session=(HashMap<String,String>)this.getIntent()
	    		   .getBundleExtra("session").getSerializable("sessionid");
	      userid=session.get("userid");
	      username=session.get("username");
	      sessionid=session.get("sessionid");
	      // if(getuserInfo()){}
	 }

}

