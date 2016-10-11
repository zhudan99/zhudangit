package com.zd.meidiaplayer.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zd.meidiaplayer.R;
import com.zd.meidiaplayer.adapter.MusicAdapter;
import com.zd.meidiaplayer.entity.Music;
import com.zd.meidiaplayer.model.MusicModel;
import com.zd.meidiaplayer.model.MusicModel.MusicListCallBack;

public class NewMusicListFragment extends Fragment{
	private ListView listView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * ���������ڷ����������Զ�����
		 * ��viewpager��Ҫ��ȡFragment��view����ʱ
		 */
		View view = inflater.inflate(R.layout.list_music_item, null);
		
		listView = (ListView) view.findViewById(R.id.listView);
		//����ҵ������  �����¸���б�
		MusicModel model = new MusicModel();
		model.getNewMusicList(0,20,new MusicListCallBack() {
			@Override
			public void onMusicListLoaded(List<Music> musics) {
				MusicAdapter adapter = new MusicAdapter(getActivity(),musics);
				listView.setAdapter(adapter);
			}
		});
		
		return view;
	}
}
