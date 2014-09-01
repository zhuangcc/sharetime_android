package com.zcc.timeshare;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainTab {
	Context context;
	private ViewPager mTabPager;
	private ImageView mTabImg;
	private ImageView mTab1, mTab2, mTab3, mTab4;
	private int zero = 0;	
	private int currIndex = 0;
	private int one;
	private int two;
	private int three;

	
	public MainTab(Context context) {
		this.context = context;
	}

	public void show() {

		Display currDisplay = ((Activity) context).getWindowManager()
				.getDefaultDisplay();		
		int displayWidth = currDisplay.getWidth();
		one = displayWidth / 4; 
		two = one * 2;
		three = one * 3;
		mTabPager = (ViewPager) ((Activity) context)
				.findViewById(R.id.tabpager);
		mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());

		mTab1 = (ImageView) ((Activity) context).findViewById(R.id.img_first);
		mTab2 = (ImageView) ((Activity) context).findViewById(R.id.img_list);
		mTab3 = (ImageView) ((Activity) context).findViewById(R.id.img_my);
		mTab4 = (ImageView) ((Activity) context)
				.findViewById(R.id.img_more);
		mTabImg = (ImageView) ((Activity) context)
				.findViewById(R.id.img_tab_now);
		mTab1.setOnClickListener(new MyOnClickListener(0));
		mTab2.setOnClickListener(new MyOnClickListener(1));
		mTab3.setOnClickListener(new MyOnClickListener(2));
		mTab4.setOnClickListener(new MyOnClickListener(3));
		addViewPage();

	}

	public View view1;
	public View view2 ;
	public View view3;
	public View view4;
	public void addViewPage() {
		
		LayoutInflater mLi = LayoutInflater.from(context);
		View view1 = mLi.inflate(R.layout.first, null);
		View view2 = mLi.inflate(R.layout.list, null);
		View view3 = mLi.inflate(R.layout.my, null);
		View view4 = mLi.inflate(R.layout.more, null);

		
		final ArrayList<View> views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		
		PagerAdapter mPagerAdapter = new PagerAdapter() {

			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			public int getCount() {
				return views.size();
			}

			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};

		mTabPager.setAdapter(mPagerAdapter);
	}

	/**
	 * 婢跺瓨鐖ｉ悙鐟板毊閻╂垵鎯�	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		public void onClick(View v) {
			mTabPager.setCurrentItem(index);
		/*	switch(index){
			case 0:
				mTab1.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_weixin_pressed));
			case 1:
				mTab2.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_address_pressed));
			case 2:
				mTab3.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_find_frd_pressed));
			case 3:
				mTab4.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_settings_pressed));
			}*/
		}
	};


	public class MyOnPageChangeListener implements OnPageChangeListener {
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				mTab1.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_weixin_pressed));
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
					mTab2.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_address_normal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, 0, 0, 0);
					mTab3.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_find_frd_normal));
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(three, 0, 0, 0);
					mTab4.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_settings_normal));
				}
				break;
			case 1:
				mTab2.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_address_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one, 0, 0);
					mTab1.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_weixin_normal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, one, 0, 0);
					mTab3.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_find_frd_normal));
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(three, one, 0, 0);
					mTab4.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_settings_normal));
				}
				break;
			case 2:
				mTab3.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_find_frd_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, two, 0, 0);
					mTab1.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_weixin_normal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, two, 0, 0);
					mTab2.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_address_normal));
				} else if (currIndex == 3) {
					animation = new TranslateAnimation(three, two, 0, 0);
					mTab4.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_settings_normal));
				}
				break;
			case 3:
				mTab4.setImageDrawable(context.getResources().getDrawable(
						R.drawable.tab_settings_pressed));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, three, 0, 0);
					mTab1.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_weixin_normal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, three, 0, 0);
					mTab2.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_address_normal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, three, 0, 0);
					mTab3.setImageDrawable(context.getResources().getDrawable(
							R.drawable.tab_find_frd_normal));
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);
			mTabImg.startAnimation(animation);
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		public void onPageScrollStateChanged(int arg0) {
		}
	}

}
