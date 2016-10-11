package com.zd.meidiaplayer.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.zd.meidiaplayer.R;
import com.zd.meidiaplayer.fragment.HotMusicListFragment;
import com.zd.meidiaplayer.fragment.NewMusicListFragment;

public class MainActivity extends FragmentActivity {

	private RadioGroup radioGroup;
	private RadioButton rbNew;
	private RadioButton rbHot;
	private ViewPager viewPager;
	private ArrayList<Fragment> fragments;
	private MainPagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initViews();
		//Œ™viewPager…Ë÷√  ≈‰∆˜
		setPagerAdapter();
		//…Ë÷√º‡Ã˝∆˜
		setListeners();
		
		
		
	}

	private void setListeners() {
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_new:
					viewPager.setCurrentItem(0);
					break;
				case R.id.rb_hot:
					viewPager.setCurrentItem(1);
					break;
				default:
					break;
				}
			}
		});
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					rbNew.setChecked(true);
					break;
				case 1:
					rbHot.setChecked(true);
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
	}

	private void setPagerAdapter() {
		
		fragments = new ArrayList<Fragment>();
		fragments.add(new NewMusicListFragment());
		fragments.add(new HotMusicListFragment());
		pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(pagerAdapter);
	}

	private void initViews() {
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		rbNew = (RadioButton) findViewById(R.id.rb_new);
		rbHot = (RadioButton) findViewById(R.id.rb_hot);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
	}

	/**
	 * viewpagerµƒ  ≈‰∆˜
	 */
	class MainPagerAdapter extends FragmentPagerAdapter{

		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}
		
	}

}
