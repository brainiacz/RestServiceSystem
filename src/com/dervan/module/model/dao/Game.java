package com.dervan.module.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
@JsonInclude(Include.NON_NULL)
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="GAME_ID")
	private int gameId;

	@Column(name="AGE_GRP")
	private String ageGrp;

	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_FROM")
	private Date dateFrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_TO")
	private Date dateTo;

	private String discipline;

	private String event;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME")
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	@Column(name="VENUE_ID")
	private BigDecimal venueId;

	public Game() {
	}

	public int getGameId() {
		return this.gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getAgeGrp() {
		return this.ageGrp;
	}

	public void setAgeGrp(String ageGrp) {
		this.ageGrp = ageGrp;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public BigDecimal getVenueId() {
		return this.venueId;
	}

	public void setVenueId(BigDecimal venueId) {
		this.venueId = venueId;
	}

}