package com.dervan.module.model.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCHEDULE_ID")
	private int scheduleId;

	@Column(name="GAME_ID")
	private int gameId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="INSERT_DATE_TIME")
	private Date insertDateTime;

	@Column(name="INSERT_USER_NAME")
	private String insertUserName;

	@Column(name="LOSSER_PART_ID")
	private BigDecimal losserPartId;

	@Column(name="LOSSER_SCORE")
	private BigDecimal losserScore;

	@Column(name="MATCH_NO")
	private BigDecimal matchNo;

	@Column(name="PART_ID1")
	private BigDecimal partId1;

	@Column(name="PART_ID2")
	private BigDecimal partId2;

	@Column(name="ROUND_NO")
	private BigDecimal roundNo;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;

	@Column(name="UPDATE_USER_NAME")
	private String updateUserName;

	@Column(name="WINNER_PART_ID")
	private BigDecimal winnerPartId;

	@Column(name="WINNER_SCORE")
	private BigDecimal winnerScore;

	public Schedule() {
	}

	public int getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getGameId() {
		return this.gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
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

	public BigDecimal getLosserPartId() {
		return this.losserPartId;
	}

	public void setLosserPartId(BigDecimal losserPartId) {
		this.losserPartId = losserPartId;
	}

	public BigDecimal getLosserScore() {
		return this.losserScore;
	}

	public void setLosserScore(BigDecimal losserScore) {
		this.losserScore = losserScore;
	}

	public BigDecimal getMatchNo() {
		return this.matchNo;
	}

	public void setMatchNo(BigDecimal matchNo) {
		this.matchNo = matchNo;
	}

	public BigDecimal getPartId1() {
		return this.partId1;
	}

	public void setPartId1(BigDecimal partId1) {
		this.partId1 = partId1;
	}

	public BigDecimal getPartId2() {
		return this.partId2;
	}

	public void setPartId2(BigDecimal partId2) {
		this.partId2 = partId2;
	}

	public BigDecimal getRoundNo() {
		return this.roundNo;
	}

	public void setRoundNo(BigDecimal roundNo) {
		this.roundNo = roundNo;
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

	public BigDecimal getWinnerPartId() {
		return this.winnerPartId;
	}

	public void setWinnerPartId(BigDecimal winnerPartId) {
		this.winnerPartId = winnerPartId;
	}

	public BigDecimal getWinnerScore() {
		return this.winnerScore;
	}

	public void setWinnerScore(BigDecimal winnerScore) {
		this.winnerScore = winnerScore;
	}

}