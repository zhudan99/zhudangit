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
		 * ���������ڷ����������Զ�����
		 * ��viewpager��Ҫ��ȡFragment��view����ʱ
		 */
		View view = inflater.inflate(R.layout.list_music_item, null);
		return view;
	}
}
