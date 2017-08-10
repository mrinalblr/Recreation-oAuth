package com.mrinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="MUSIC")
public class Music {

	@Id
	@GeneratedValue
	@Column(name="MUSIC_ID")
	private int musicId;
	@Column(name="MUSIC_NAME")
	private String MusicName;
	@Column(name="MUSIC_VENUE")
	private String venue;
	@Column(name="MUSIC_HOST")
	private String host;
	@Column(name="MUSIC_DATE")
	private String date;
	@Column(name="MUSIC_TIME")
	private String time;
	@Column(name="MUSIC_DESC")
	private String description;
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(String musicName, String venue, String host, String date, String time, String description) {
		super();
		MusicName = musicName;
		this.venue = venue;
		this.host = host;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getMusicName() {
		return MusicName;
	}
	public void setMusicName(String musicName) {
		MusicName = musicName;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
