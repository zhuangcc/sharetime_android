package com.zcc.timeshare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SubSearch {
	Context context;
	EditText search;
	ListView listfood;
	View mylayout;

	public SubSearch(Context context,View view) {
		this.context = context;
		mylayout=view;
	}

	public void btnlist(){
		List<Map<String, Object>> data=new ArrayList<Map<String,Object>>();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("a", "sddd");
		data.add(map);
	Intent intent=new Intent();
	intent.setClass(context, data.class);
	intent.putExtra("data", "aa");
	//intent.putExtra("data", data);
//	intent.putCharSequenceArrayListExtra(name, value)("efood", data);
	
	context.startActivity(intent);
	}
	public void invilateView() {
		
		if(mylayout==null){
			LayoutInflater mLi = LayoutInflater.from(context);
			mylayout= mLi.inflate(R.layout.first, null);
		}
		
	//	search = (EditText) (mylayout).findViewById(R.id.search);
	}


}
