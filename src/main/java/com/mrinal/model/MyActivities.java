package com.mrinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="MY_ACTIVITIES")
public class MyActivities {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACTIVITY_ID")
	private int activityId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SPORTS_ID",unique=true)
	private Sports sports;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public MyActivities(int activityId, Sports sports) {
		super();
		this.activityId = activityId;
		this.sports = sports;
	}

	public MyActivities() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
