package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the team_game database table.
 * 
 */
@Entity
@Table(name="team_game")
@NamedQuery(name="TeamGame.findAll", query="SELECT t FROM TeamGame t")
public class TeamGame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEAM_GAME_ID")
	private int teamGameId;

	@Column(name="GAME_ID")
	private int eventid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME", insertable=false)
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	@Column(name="TEAM_ID")
	private int teamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME", insertable=false)
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	/**
	 * @return the teamGameId
	 */
	public int getTeamGameId() {
		return teamGameId;
	}

	/**
	 * @param teamGameId the teamGameId to set
	 */
	public void setTeamGameId(int teamGameId) {
		this.teamGameId = teamGameId;
	}

	/**
	 * @return the eventid
	 */
	public int getEventid() {
		return eventid;
	}

	/**
	 * @param eventid the eventid to set
	 */
	public void setEventid(int eventid) {
		this.eventid = eventid;
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

	
}