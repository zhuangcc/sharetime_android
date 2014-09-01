package com.zcc.timeshare;



import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class Welcome extends Activity {
	private ViewPager mViewPager;	
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	private ImageView mPage4;
	private ImageView mPage5;
		
	private int currIndex = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.anim_welcome);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		//overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);   //全屏显示
		//Toast.makeText(getApplicationContext(), "孩子！好好背诵！", Toast.LENGTH_LONG).show();
		//overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
		
	/*new Handler().postDelayed(new Runnable(){
		public void run(){
			Intent intent = new Intent (Welcome.this,Main.class);			
			startActivity(intent);			
			Welcome.this.finish();
		}
	}, 1000);*/
		 mViewPager = (ViewPager)findViewById(R.id.viewpager);        
	        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	       
	        
	       // mPage0 = (ImageView)findViewById(R.id.page0);
	        mPage1 = (ImageView)findViewById(R.id.page1);
	        mPage2 = (ImageView)findViewById(R.id.page2);
	        mPage3 = (ImageView)findViewById(R.id.page3);
	        mPage4 = (ImageView)findViewById(R.id.page4);
	        mPage5 = (ImageView)findViewById(R.id.page5);
	        
	      //将要分页显示的View装入数组中
	        LayoutInflater mLi = LayoutInflater.from(this);
	        View view1 = mLi.inflate(R.layout.whats1, null);
	        View view2 = mLi.inflate(R.layout.whats2, null);
	        View view3 = mLi.inflate(R.layout.whats3, null);
	        View view4 = mLi.inflate(R.layout.whats4, null);
	        View view5 = mLi.inflate(R.layout.whats5, null);
	       // View view6 = mLi.inflate(R.layout.whats6, null);
	        
	      //每个页面的view数据
	        final ArrayList<View> views = new ArrayList<View>();
	        views.add(view1);
	        views.add(view2);
	        views.add(view3);
	        views.add(view4);
	        views.add(view5);
	       // views.add(view6);
	        
	        //填充ViewPager的数据适配器
	        PagerAdapter mPagerAdapter = new PagerAdapter() {
				
				public boolean isViewFromObject(View arg0, Object arg1) {
					return arg0 == arg1;
				}
				
				public int getCount() {
					return views.size();
				}

				public void destroyItem(View container, int position, Object object) {
					((ViewPager)container).removeView(views.get(position));
				}
				
				
				
				public Object instantiateItem(View container, int position) {
					((ViewPager)container).addView(views.get(position));
					return views.get(position);
				}
			};
			
			mViewPager.setAdapter(mPagerAdapter);
	    }    
	    

	    public class MyOnPageChangeListener implements OnPageChangeListener {
			public void onPageSelected(int arg0) {
				switch (arg0) {
				case 0:				
					mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					//mPage0.setImageDrawable(getResources().getDrawable(R.drawable.page));
					mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 1:
					mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					mPage1.setImageDrawable(getResources().getDrawable(R.drawable.page));
					mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 2:
					mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
					mPage2.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 3:
					mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					mPage3.setImageDrawable(getResources().getDrawable(R.drawable.page));
					mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				case 4:
					mPage5.setImageDrawable(getResources().getDrawable(R.drawable.page_now));
					mPage4.setImageDrawable(getResources().getDrawable(R.drawable.page));
					break;
				}
				currIndex = arg0;
				//animation.setFillAfter(true);// True:图片停在动画结束位置
				//animation.setDuration(300);
				//mPageImg.startAnimation(animation);
			}
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			public void onPageScrollStateChanged(int arg0) {
			}
		}
	    public void startbutton(View v) {  
	      	Intent intent = new Intent();
			intent.setClass(Welcome.this,newDoor.class);
			startActivity(intent);
			this.finish();
	      }  
	    
	}


