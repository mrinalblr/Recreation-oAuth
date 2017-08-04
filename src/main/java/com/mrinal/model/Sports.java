package com.mrinal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sports {
	@Id
	@GeneratedValue (strategy =GenerationType.AUTO)
	@Column(name="SPORTS_ID")
    private int sportsId;
	@Column(name="SPORTS_NAME")
	private String sportsName;
	@Column(name="SPORTS_HOST")
	private String host;
	@Column(name="SPORTS_VENUE")
	private String venue;
	@Column(name="SPORTS_DATE")
	private String date;
	@Column(name="SPORTS_TIME")
	private String time;
	@Column(name="SPORTS_DESCRIPTION")
	private String description;
	@OneToOne(mappedBy = "sports", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
	private MyActivities myActivities;
	public int getSportsId() {
		return sportsId;
	}
	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
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
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
