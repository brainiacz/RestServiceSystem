package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamRecord implements Serializable{
		

	private static final long serialVersionUID = -8521612986302162578L;
	
	private List<Participant> participants;
	private List<TeamGame> games;
	private Team team;
	private int amount;
	private String selectionMode;
	
	
	/**
	 * @return the selectionMode
	 */
	public String getSelectionMode() {
		return selectionMode;
	}
	/**
	 * @param selectionMode the selectionMode to set
	 */
	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}
	/**
	 * @return the participants
	 */
	public List<Participant> getParticipants() {
		return participants;
	}
	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
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
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
}
