package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEAM_ID")
	private int teamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME", insertable=false)
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	@Column(name="TEAM_NAME")
	private String teamName;

	@Column(name="TEAM_SCHOOL")
	private String teamSchool;

	@Column(name="TEAM_SCHOOL_ADD1")
	private String teamSchoolAdd1;

	@Column(name="TEAM_SCHOOL_ADD2")
	private String teamSchoolAdd2;

	@Column(name="TEAM_SCHOOL_CITY")
	private String teamSchoolCity;

	@Column(name="TEAM_SCHOOL_PINCODE")
	private int teamSchoolPincode;

	@Column(name="TEAM_SCHOOL_STATE")
	private String teamSchoolState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME", insertable=false)
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;
	
	@Column(name="CAPTAIN_PART_ID")
	private int captainPartId;
	

	public Team() {
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
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

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamSchool() {
		return this.teamSchool;
	}

	public void setTeamSchool(String teamSchool) {
		this.teamSchool = teamSchool;
	}

	public String getTeamSchoolAdd1() {
		return this.teamSchoolAdd1;
	}

	public void setTeamSchoolAdd1(String teamSchoolAdd1) {
		this.teamSchoolAdd1 = teamSchoolAdd1;
	}

	public String getTeamSchoolAdd2() {
		return this.teamSchoolAdd2;
	}

	public void setTeamSchoolAdd2(String teamSchoolAdd2) {
		this.teamSchoolAdd2 = teamSchoolAdd2;
	}

	public String getTeamSchoolCity() {
		return this.teamSchoolCity;
	}

	public void setTeamSchoolCity(String teamSchoolCity) {
		this.teamSchoolCity = teamSchoolCity;
	}

	public int getTeamSchoolPincode() {
		return this.teamSchoolPincode;
	}

	public void setTeamSchoolPincode(int teamSchoolPincode) {
		this.teamSchoolPincode = teamSchoolPincode;
	}

	public String getTeamSchoolState() {
		return this.teamSchoolState;
	}

	public void setTeamSchoolState(String teamSchoolState) {
		this.teamSchoolState = teamSchoolState;
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

	/**
	 * @return the captainPartId
	 */
	public int getCaptainPartId() {
		return captainPartId;
	}

	/**
	 * @param captainPartId the captainPartId to set
	 */
	public void setCaptainPartId(int captainPartId) {
		this.captainPartId = captainPartId;
	}
	
	

}