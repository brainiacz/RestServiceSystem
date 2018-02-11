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
	private String teamSchoolPincode;

	@Column(name="TEAM_SCHOOL_STATE")
	private String teamSchoolState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME", insertable=false)
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;
	
	@Column(name="CAPTAIN_PART_ID")
	private int captainPartId;

	/**
	 * @return the teamId
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @param teamId the teamId to set
	 */
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return the insertDateTime
	 */
	public Date getInsertDateTime() {
		return insertDateTime;
	}

	/**
	 * @param insertDateTime the insertDateTime to set
	 */
	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	/**
	 * @return the insertUserName
	 */
	public String getInsertUserName() {
		return insertUserName;
	}

	/**
	 * @param insertUserName the insertUserName to set
	 */
	public void setInsertUserName(String insertUserName) {
		this.insertUserName = insertUserName;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the teamSchool
	 */
	public String getTeamSchool() {
		return teamSchool;
	}

	/**
	 * @param teamSchool the teamSchool to set
	 */
	public void setTeamSchool(String teamSchool) {
		this.teamSchool = teamSchool;
	}

	/**
	 * @return the teamSchoolAdd1
	 */
	public String getTeamSchoolAdd1() {
		return teamSchoolAdd1;
	}

	/**
	 * @param teamSchoolAdd1 the teamSchoolAdd1 to set
	 */
	public void setTeamSchoolAdd1(String teamSchoolAdd1) {
		this.teamSchoolAdd1 = teamSchoolAdd1;
	}

	/**
	 * @return the teamSchoolAdd2
	 */
	public String getTeamSchoolAdd2() {
		return teamSchoolAdd2;
	}

	/**
	 * @param teamSchoolAdd2 the teamSchoolAdd2 to set
	 */
	public void setTeamSchoolAdd2(String teamSchoolAdd2) {
		this.teamSchoolAdd2 = teamSchoolAdd2;
	}

	/**
	 * @return the teamSchoolCity
	 */
	public String getTeamSchoolCity() {
		return teamSchoolCity;
	}

	/**
	 * @param teamSchoolCity the teamSchoolCity to set
	 */
	public void setTeamSchoolCity(String teamSchoolCity) {
		this.teamSchoolCity = teamSchoolCity;
	}

	/**
	 * @return the teamSchoolPincode
	 */
	public String getTeamSchoolPincode() {
		return teamSchoolPincode;
	}

	/**
	 * @param teamSchoolPincode the teamSchoolPincode to set
	 */
	public void setTeamSchoolPincode(String teamSchoolPincode) {
		this.teamSchoolPincode = teamSchoolPincode;
	}

	/**
	 * @return the teamSchoolState
	 */
	public String getTeamSchoolState() {
		return teamSchoolState;
	}

	/**
	 * @param teamSchoolState the teamSchoolState to set
	 */
	public void setTeamSchoolState(String teamSchoolState) {
		this.teamSchoolState = teamSchoolState;
	}

	/**
	 * @return the updateDateTime
	 */
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the updateUserName
	 */
	public String getUpdateUserName() {
		return updateUserName;
	}

	/**
	 * @param updateUserName the updateUserName to set
	 */
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