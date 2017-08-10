package com.mrinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyActivity {
	@Id
	@GeneratedValue (strategy =GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="ACTIVITY_NAME")
	private String activtyName;
	@Column(name="ACTIVITY_ID",unique=true)
	private int activityId;
	@Column(name="ACTIVITY_HOST")
	private String activityHost;
	@Column(name="ACTIVITY_VENUE")
	private String activityVenue;
	@Column(name="ACTIVITY_DTAE")
	private String activityDate;
	@Column(name="ACTIVITY_TIME")
	private String activityTime;
	@Column(name="ACTIVITY_DESC")
	private String activityDescription;
	@Column(name="ACTIVITY_STATUS")
	private String status;   //EXPIRED,ACTIVE,SCHEDULED.
	public MyActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyActivity(String activtyName, int activityId, String activityHost, String activityVenue,
			String activityDate, String activityTime, String activityDescription, String status) {
		super();
		this.activtyName = activtyName;
		this.activityId = activityId;
		this.activityHost = activityHost;
		this.activityVenue = activityVenue;
		this.activityDate = activityDate;
		this.activityTime = activityTime;
		this.activityDescription = activityDescription;
		this.status = status;
	}
	public String getActivtyName() {
		return activtyName;
	}
	public void setActivtyName(String activtyName) {
		this.activtyName = activtyName;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int i) {
		this.activityId = i;
	}
	public String getActivityHost() {
		return activityHost;
	}
	public void setActivityHost(String activityHost) {
		this.activityHost = activityHost;
	}
	public String getActivityVenue() {
		return activityVenue;
	}
	public void setActivityVenue(String activityVenue) {
		this.activityVenue = activityVenue;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public String getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
