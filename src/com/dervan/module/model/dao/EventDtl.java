package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the event_dtls database table.
 * 
 */
@Entity
@Table(name="event_dtls")
@NamedQuery(name="EventDtl.findAll", query="SELECT e FROM EventDtl e")
public class EventDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EVENT_DTLS_ID")
	private int eventDtlsId;

	@Column(name="FIRST_RUNNERUP_PART_ID")
	private BigDecimal firstRunnerupPartId;

	@Column(name="GAME_ID")
	private int gameId;

	@Column(name="INSER_USER_NAME")
	private String inserUserName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME", insertable=false)
	private Date insertDateTime;

	@Column(name="NO_OF_MATHCES")
	private BigDecimal noOfMathces;

	@Column(name="NO_OF_ROUNDS")
	private BigDecimal noOfRounds;

	@Column(name="NUMBER_OF_PARTICIPANTS")
	private BigDecimal numberOfParticipants;

	@Column(name="SEC_RUNNERUP_PART_ID")
	private BigDecimal secRunnerupPartId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME", insertable=false)
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	@Column(name="VOLUNTEER_NAMES")
	private String volunteerNames;

	@Column(name="WINNER_PART_ID")
	private BigDecimal winnerPartId;

	public EventDtl() {
	}

	public int getEventDtlsId() {
		return this.eventDtlsId;
	}

	public void setEventDtlsId(int eventDtlsId) {
		this.eventDtlsId = eventDtlsId;
	}

	public BigDecimal getFirstRunnerupPartId() {
		return this.firstRunnerupPartId;
	}

	public void setFirstRunnerupPartId(BigDecimal firstRunnerupPartId) {
		this.firstRunnerupPartId = firstRunnerupPartId;
	}

	public int getGameId() {
		return this.gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getInserUserName() {
		return this.inserUserName;
	}

	public void setInserUserName(String inserUserName) {
		this.inserUserName = inserUserName;
	}

	public Date getInsertDateTime() {
		return this.insertDateTime;
	}

	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	public BigDecimal getNoOfMathces() {
		return this.noOfMathces;
	}

	public void setNoOfMathces(BigDecimal noOfMathces) {
		this.noOfMathces = noOfMathces;
	}

	public BigDecimal getNoOfRounds() {
		return this.noOfRounds;
	}

	public void setNoOfRounds(BigDecimal noOfRounds) {
		this.noOfRounds = noOfRounds;
	}

	public BigDecimal getNumberOfParticipants() {
		return this.numberOfParticipants;
	}

	public void setNumberOfParticipants(BigDecimal numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public BigDecimal getSecRunnerupPartId() {
		return this.secRunnerupPartId;
	}

	public void setSecRunnerupPartId(BigDecimal secRunnerupPartId) {
		this.secRunnerupPartId = secRunnerupPartId;
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

	public String getVolunteerNames() {
		return this.volunteerNames;
	}

	public void setVolunteerNames(String volunteerNames) {
		this.volunteerNames = volunteerNames;
	}

	public BigDecimal getWinnerPartId() {
		return this.winnerPartId;
	}

	public void setWinnerPartId(BigDecimal winnerPartId) {
		this.winnerPartId = winnerPartId;
	}

}