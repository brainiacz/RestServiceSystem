package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamRecordInner implements Serializable{
		

	private static final long serialVersionUID = -8521612986302162578L;
	
	private Participant partidetails;
	private List<Participant> tm;
	private List<TeamGame> games;
	private int amt;
	private String type;
	/**
	 * @return the partidetails
	 */
	public Participant getPartidetails() {
		return partidetails;
	}
	/**
	 * @param partidetails the partidetails to set
	 */
	public void setPartidetails(Participant partidetails) {
		this.partidetails = partidetails;
	}
	/**
	 * @return the tm
	 */
	public List<Participant> getTm() {
		return tm;
	}
	/**
	 * @param tm the tm to set
	 */
	public void setTm(List<Participant> tm) {
		this.tm = tm;
	}
	/**
	 * @return the games
	 */
	public List<TeamGame> getGames() {
		return games;
	}
	/**
	 * @param games the games to set
	 */
	public void setGames(List<TeamGame> games) {
		this.games = games;
	}
	/**
	 * @return the amt
	 */
	public int getAmt() {
		return amt;
	}
	/**
	 * @param amt the amt to set
	 */
	public void setAmt(int amt) {
		this.amt = amt;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}
