package com.dervan.module.model.dao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

public class RecordInner implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Participant partidetails;
		private List<Game> games;
		private String amt;
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
		 * @return the amt
		 */
		public String getAmt() {
			return amt;
		}
		/**
		 * @param amt the amt to set
		 */
		public void setAmt(String amt) {
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
