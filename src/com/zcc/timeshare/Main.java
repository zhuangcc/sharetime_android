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
        	        .setTitle("��½��ʾ")
        	        .setMessage("�������û�����������е�¼��")
        	        .setCancelable(false)
					.setView(DialogView)
					.setPositiveButton("ȷ��",
							new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int arg1)
						{
							 tx1=(EditText) DialogView.findViewById(R.id.username);
						     tx2=(EditText) DialogView.findViewById(R.id.password);
				             String name= tx1.getText().toString();
				             String password =tx2.getText().toString();
				             if("zcc".equals(name) && "123".equals(password))   //�ж� �ʺź�����
				             {
				            	 Intent intent = new Intent();
				                  intent.setClass(Main.this,myActivity.class);
				                  startActivity(intent);
				                  //Toast.makeText(getApplicationContext(), "��¼�ɹ�", Toast.LENGTH_SHORT).show();
				               }
				             else if("".equals(name) || "".equals(password))   //�ж� �ʺź�����
				             {
				             	new AlertDialog.Builder(Main.this)
				     			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				     			.setTitle("��¼����")
				     			.setMessage("�ʺŻ������벻��Ϊ�գ�\n��������ٵ�¼��")
				     			.create().show();
				              }
				             else{
				                
				             	new AlertDialog.Builder(Main.this)
				     			.setIcon(getResources().getDrawable(R.drawable.login_error_icon))
				     			.setTitle("��¼ʧ��")
				     			.setMessage("�ʺŻ������벻��ȷ��\n������������룡")
				     			.create().show();
				             }
	                   }     	
                     })
			        .setNegativeButton("ȡ��",
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
  		.setMessage("ȷ���˳�����ʱ����")
          .setPositiveButton("��", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {                  	
              	finish();
              }
          })
          .setNeutralButton("��", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {                 			
              }
          }).create();
  		dialog.show();
  	}
  
}