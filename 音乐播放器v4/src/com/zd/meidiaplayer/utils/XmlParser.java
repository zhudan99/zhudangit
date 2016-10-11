package com.zd.meidiaplayer.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.zd.meidiaplayer.entity.Music;

public class XmlParser {

	public static List<Music> parseMusicList(InputStream is) throws Exception {
		
		List<Music> musics = new ArrayList<Music>();
		
		XmlPullParser parser = Xml.newPullParser();
		
		parser.setInput(is, "utf-8");
		
		int eventType = parser.getEventType();
		Music music = null;
		while(eventType != XmlPullParser.END_DOCUMENT){
			switch(eventType){
			case XmlPullParser.START_TAG:
				String tagName = parser.getName();
				if(tagName.equals("song")){
					music = new Music();
					musics.add(music);
				}else if(tagName.equals("artist_id")){
					music.setArtist_id(parser.nextText());
				}else if(tagName.equals("language")){
					music.setLanguage(parser.nextText());
				}else if(tagName.equals("pic_big")){
					music.setPic_big(parser.nextText());
				}else if(tagName.equals("pic_small")){
					music.setPic_small(parser.nextText());
				}else if(tagName.equals("lrclink")){
					music.setLrclink(parser.nextText());
				}else if(tagName.equals("all_artist_id")){
					music.setAll_artist_id(parser.nextText());
				}else if(tagName.equals("file_duration")){
					music.setFile_duration(parser.nextText());
				}else if(tagName.equals("song_id")){
					music.setSong_id(parser.nextText());
				}else if(tagName.equals("title")){
					music.setTitle(parser.nextText());
				}else if(tagName.equals("author")){
					music.setAuthor(parser.nextText());
				}else if(tagName.equals("album_id")){
					music.setAlbum_id(parser.nextText());
				}else if(tagName.equals("album_title")){
					music.setAlbum_title(parser.nextText());
				}else if(tagName.equals("artist_name")){
					music.setArtist_name(parser.nextText());
				}
				
				break;
			}
			
			eventType = parser.next();
		}
		
		
		return musics;
	}

}
