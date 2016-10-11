package com.zd.meidiaplayer.adapter;

import java.util.List;

import com.zd.meidiaplayer.R;
import com.zd.meidiaplayer.entity.Music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter{

	private Context context;
	private List<Music> musics;
	private LayoutInflater inflater;
	
	public MusicAdapter(Context context, List<Music> musics) {
		super();
		this.context = context;
		this.musics = musics;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return musics.size();
	}

	@Override
	public Music getItem(int position) {
		return musics.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		
		Music m = getItem(position);
		if(convertView == null){
			convertView = inflater.inflate(R.layout.music_item, null);
			holder = new ViewHolder();
			holder.ivIcon = (ImageView) convertView.findViewById(R.id.iv_icon);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tvSinger = (TextView) convertView.findViewById(R.id.tv_singer);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.tvTitle.setText(m.getTitle());
		holder.tvSinger.setText(m.getAuthor());
		
		return convertView;
	}

	class ViewHolder{
		ImageView ivIcon;
		TextView tvTitle;
		TextView tvSinger;		
	}
}
