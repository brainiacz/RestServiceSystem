package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the venue database table.
 * 
 */
@Entity
@NamedQuery(name="Venue.findAll", query="SELECT v FROM Venue v")
public class Venue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VENUE_ID")
	private int venueId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME")
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	@Column(name="VENUE_NAME")
	private String venueName;

	@Column(name="VENUE_TYPE")
	private String venueType;

	public Venue() {
	}

	public int getVenueId() {
		return this.venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public Date getInsertDateTime() {
		return this.insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public String getInsertUserName() {
		return this.insertUserName;
	}

	public void setInsertUserName(String insertUserName) {
		this.insertUserName = insertUserName;
	}

	public Date getUpdateDateTime() {
		return this.updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getVenueName() {
		return this.venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueType() {
		return this.venueType;
	}

	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

}