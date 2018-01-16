package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the team_parti database table.
 * 
 */
@Entity
@Table(name="team_parti")
@NamedQuery(name="TeamParti.findAll", query="SELECT t FROM TeamParti t")
public class TeamParti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEAM_PARTI_ID")
	private int teamPartiId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME")
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	@Column(name="PART_ID")
	private int partId;

	@Column(name="TEAM_ID")
	private int teamId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	public TeamParti() {
	}

	public int getTeamPartiId() {
		return this.teamPartiId;
	}

	public void setTeamPartiId(int teamPartiId) {
		this.teamPartiId = teamPartiId;
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

	public int getPartId() {
		return this.partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
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