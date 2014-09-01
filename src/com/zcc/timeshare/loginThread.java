package com.zcc.timeshare;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class loginThread extends Thread{
	int times=0;
	String username;
	String psw;
	public loginThread(int times,String username,String psw){
		this.times=times;
		this.username=username;
		this.psw=psw;	
	}
	@Override
    public void run(){
    	Looper.prepare();
    	if(times==3){
    		UiFactory.alertError(login.this,"Á¬½Ó³¬Ê±","ÍøÂç´íÎó");
    		return;
    	}
    	User user=null;
    	HttpPost url=new HttpPost();
    	List<NameValuePair>namevaluepairs=new ArrayList<NameValuePair>(2);
    	namevaluepairs.add(new BasicNameValuePair("username",username));
    	namevaluepairs.add(new BasicNameValuePair("password",psw));
    	try {
    		url.setEntity(new UrlEncodedFormEntity(namevaluepairs));
    		HttpResponse httpResponse=new DefaultHttpClient().execute(url);
    		user=XMLFactory.getUserByXML(httpResponse.getEntity().getContent());
    	}
        catch(SocketException e){
        	new loginThread(++times,username,psw).start();
        	e.printStackTrace();
        	return;
        	}
    	catch(Exception e){
    		UiFactory.alertError(Login.this,"Á¬½Ó´íÎó","ÍøÂç´íÎó");
    		e.printStackTrace();
    		return;
    	}
    	Message message=new Message();
    	Bundle data =new Bundle();
    	data.putSerializable("user","user");
    	message.setData(data);
    	handleUser.sendMessage(message);
    	super.run();
    	Looper.loop();
    }
}
  private Handler handlerUser=new Handler(){
    @Override
    public void handlerMessage(Message message){
    	progressDialog.dismiss();
    	User u=(User)msg.getData.get("user");
    	if(u==null){
    		UiFactory.alertError(login.this,"ÑéÖ¤Ê§°Ü","´íÎó");	
    	}
    	else{checkUser();}
    } 
  };
  public void checkUser(){
	  Intent it=new Intent(Login.this,my.class);
	  it.putExtra("user",u);
	  startActivity(it);
	  login.this.finish();
	  
  }
}
}
public class XMLFactory(){
	
}
