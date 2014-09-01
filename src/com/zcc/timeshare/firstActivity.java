package com.zcc.timeshare;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstActivity extends Activity {
	SubSearch subsearch;
	Button searchBtn;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.first);
	       // searchBtn=(Button)findViewById(R.id.search_btn);
	        
	 }
	  public void btnSearch(View v){
			if(subsearch!=null){
				subsearch.btnlist();
			}
			
		}
	   
}
