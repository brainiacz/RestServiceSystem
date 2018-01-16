package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.List;

public class Record implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Participant participant;
		private List<Game> games;
		private String amount;
		private String selectMode;
	/**
	 * @return the participant
	 */
	public Participant getParticipant() {
		return participant;
	}
	/**
	 * @param participant the participant to set
	 */
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	/**
	 * @return the games
	 */
	public List<Game> getGames() {
		return games;
	}
	/**
	 * @param games the games to set
	 */
	public void setGames(List<Game> games) {
		this.games = games;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the selectMode
	 */
	public String getSelectMode() {
		return selectMode;
	}
	/**
	 * @param selectMode the selectMode to set
	 */
	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}
	
	
}
