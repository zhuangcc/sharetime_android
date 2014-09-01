package com.zcc.timeshare;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.w3c.dom.Document;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.sax.Element;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity{
	EditText edt1;
	EditText edt2;
	Button loginBtn;
	HashMap<String,String> session=new HashMap<String,String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		edt1=(EditText)findViewById(R.id.edt1);
		edt2=(EditText)findViewById(R.id.edt2);
		loginBtn=(Button)findViewById(R.id.login);
		loginBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				if(checkUser()){
					Toast.makeText(arg0.getContext(), "µÇÂ½³É¹¦", Toast.LENGTH_SHORT).show();
					Intent intent=new Intent(arg0.getContext(),myActivity.class);
					Bundle map=new Bundle();
					map.putSerializable("sessionid", session);
					intent.putExtra("session", map);
					startActivity(intent);
				}
				else
					Toast.makeText(arg0.getContext(), "µÇÂ¼Ê§°Ü", Toast.LENGTH_SHORT).show();
				
			}});
	}

	protected boolean checkUser() {
		String user=edt1.getText().toString();
		String pass=edt2.getText().toString();
		DefaultHttpClient mclient=new DefaultHttpClient();
		HttpPost mpost=new HttpPost();
		List<BasicNameValuePair>pairs=new ArrayList<BasicNameValuePair>();
		pairs.add(new BasicNameValuePair("username",user));
		pairs.add(new BasicNameValuePair("password",pass));
		try{
			mpost.setEntity(new UrlEncodedFormEntity(pairs,HTTP.UTF_8));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			HttpResponse response=mclient.execute(mpost);
			int res=response.getStatusLine().getStatusCode();
			if(res==200){
				HttpEntity entity=response.getEntity();
				if(entity!=null){
					String info=EntityUtils.toString(entity);
					Log.i("entity",info);
					JSONObject json=null;
					String flag="";
					String name="";
					String userid="";
					String sessionid="";
					try{
						json=new JSONObject(info);
						flag=json.getString("flag");
						name=json.getString("name");
						userid=json.getString("userid");
						sessionid=json.getString("sessionid");						
					}
					catch(Exception e){
						e.printStackTrace();
					}
					if(flag.equals("success")){
						session.put("userid",userid);
						session.put("sessionid",sessionid);
						return true;
					}
					else return false;
				}
			else return false;
				}
		}
		catch(ClientProtocolException e){
			e.printStackTrace();}
		catch(IOException e){
			e.printStackTrace();}
		return false;
	}	
}
 class loginThread extends Thread{
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
public class XMLFactory(){
	public static User getUserByXML(InputStream is)throws Exception{
		DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbfactory.newDocumentBuilder();
		Document doc=db.parse(is);
		Element root=(Element) doc.getDocumentElement();
		String login ="0";
		login=root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue();
		User user=null;
		if("1".equals(login)){
			user=new User(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
			user.setname(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
			user.setname(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
			user.setname(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
			user.setname(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
			user.setname(root.getElementsByTagName("login").item(0).getFirstChild().getNodeValue());
		}
		return user;
	}
}
				
		
	}
	
}
