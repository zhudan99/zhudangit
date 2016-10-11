package com.zd.meidiaplayer.model;

import java.io.InputStream;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.zd.meidiaplayer.entity.Music;
import com.zd.meidiaplayer.utils.HttpUtils;
import com.zd.meidiaplayer.utils.UrlFactory;
import com.zd.meidiaplayer.utils.XmlParser;

public class MusicModel {
	/**
	 * ����¸����б�
	 * @param offset
	 * @param size
	 */
	public void getNewMusicList(final int offset,final int size,final MusicListCallBack callback) {
		AsyncTask<String, String, List<Music>> task = new AsyncTask<String, String, List<Music>>(){

			@Override
			protected List<Music> doInBackground(String... params) {
								
				try {
					String url = UrlFactory.getNewMusicListUrl(offset,size);
					InputStream is = HttpUtils.get(url);
					//����is�е�xml���� ��ȡList<Music>
					List<Music> musics = XmlParser.parseMusicList(is);
					return musics;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return null;
			}
			@Override
			protected void onPostExecute(List<Music> musics) {
				
				callback.onMusicListLoaded(musics);
				
				Log.w("zd", "�¸��"+musics.toString());
			}
			
		};
		task.execute();
	}

	public interface MusicListCallBack{
		public void onMusicListLoaded(List<Music> musics);
	}
}
