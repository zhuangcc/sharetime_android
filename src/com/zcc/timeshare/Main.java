package com.zcc.timeshare;


import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TableLayout.LayoutParams;
import android.widget.Toast;

public class Main extends Activity {
	Button login_button;
	Button register_button;
	EditText tx1;
	EditText tx2;
   ImageButton ShakeBtn;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MainTab maintab =new MainTab(this);
		maintab.show();
      /*  TabWidget tabwidget=mtabHost.getTabWidget();
        for(int i=0;i<tabwidget.getChildCount();i++)
        {
        	View child=tabwidget.getChildAt(i);
        	LinearLayout.LayoutParams lp=(LayoutParams)child.getLayoutParams();
        	lp.width=LayoutParams.MATCH_PARENT;
        	lp.height=80;
        	lp.weight=0.0f;
        }*/
      //   mtabHost.setCurrentTab(1);
		ShakeBtn=(ImageButton)findViewById(R.id.shake_btn);
        login_button=(Button)findViewById(R.id.login);
        register_button=(Button)findViewById(R.id.register);
        ShakeBtn.setOnClickListener(new OnClickListener(){
        	public void onClick(View a){
        		Intent intent = new Intent(Main.this, ShakeActivity.class);
    			startActivity(intent);
        	}
        });
        login_button.setOnClickListener( new OnClickListener(){
        	public void onClick(View arg0){
        		Intent it=new Intent(Main.this,login.class);
        		startActivity(it);
        		/* LayoutInflater factory=LayoutInflater.from(Main.this);
				 final View DialogView=factory.inflate(R.layout.dialog , null);
				 AlertDialog dialog=new AlertDialog.Builder(Main.this)
        	        .setTitle("登陆提示")
        	        .setMessage("请输入用户名和密码进行登录！")
        	        .setCancelable(false)
					.setView(DialogView)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int arg1)
						{
							 tx1=(EditText) DialogView.findViewById(R.id.username);
						     tx2=(EditText) DialogView.findViewById(R.id.password);
				             String name= tx1.getText().toString();
				             String password =tx2.getText().toString();
				             if("zcc".equals(name) && "123".equals(password))   //判断 帐号和密码
				             {
				            	 Intent intent = new Intent();
				                  intent.setClass(Main.this,myActivity.class);
				                  startActivity(intent);
				                  //Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
				               }
				             else if("".equals(name) || "".equals(password))   //判断 帐号和密码
				             {
				             	new AlertDialog.Builder(Main.this)
				     			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				     			.setTitle("登录错误")
				     			.setMessage("帐号或者密码不能为空，\n请输入后再登录！")
				     			.create().show();
				              }
				             else{
				                
				             	new AlertDialog.Builder(Main.this)
				     			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				     			.setTitle("登录失败")
				     			.setMessage("帐号或者密码不正确，\n请检查后重新输入！")
				     			.create().show();
				             }
	                   }     	
                     })
			        .setNegativeButton("取消",
							new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int arg1)
						    {dialog.dismiss();}
						})
					.create();
				 dialog.show();*/
        		 }
        });
        register_button.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
        		Intent it=new Intent(Main.this,register.class);
        		startActivity(it);
        	}       	
        } );    
    } 
    public void onBackPressed() {
  		// TODO Auto-generated method stub
  		//super.onBackPressed();
  		Dialog dialog = new AlertDialog.Builder(Main.this)
  		.setMessage("确定退出分享时间吗")
          .setPositiveButton("是", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {                  	
              	finish();
              }
          })
          .setNeutralButton("否", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {                 			
              }
          }).create();
  		dialog.show();
  	}
  
}