package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


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
	@Column(name="INSERT_DATE_TIME")
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
	private BigDecimal teamSchoolPincode;

	@Column(name="TEAM_SCHOOL_STATE")
	private String teamSchoolState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

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

	public BigDecimal getTeamSchoolPincode() {
		return this.teamSchoolPincode;
	}

	public void setTeamSchoolPincode(BigDecimal teamSchoolPincode) {
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

}