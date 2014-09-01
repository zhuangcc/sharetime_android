package com.zcc.timeshare;

import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class listActivity extends ListActivity {
	Button createButton;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);
	        List<Map<String,Bitmap>>items=fillArray();
	        ArrayAdapter<Map<String,Bitmap>>adapter=new ArrayAdapter<Map<String,Bitmap>>(this,R.layout.list_row,items);
	        this.setListAdapter(adapter);
	        createButton=(Button)findViewById(R.id.create);
	        createButton. setOnClickListener(new OnClickListener(){
	        	public void onClick(View arg0){
	        		Intent it=new Intent(listActivity.this,createActivity.class);
	        		startActivity(it);
	        	}
	        });
	 }

	private List<Map<String, Bitmap>> fillArray() {
		
		return null;
	}
	
}
