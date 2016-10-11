package com.zd.meidiaplayer.fragment;

import com.zd.meidiaplayer.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HotMusicListFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * 该生命周期方法由容器自动调用
		 * 当viewpager需要获取Fragment的view对象时
		 */
		View view = inflater.inflate(R.layout.list_music_item, null);
		return view;
	}
}
