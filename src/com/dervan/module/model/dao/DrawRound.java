package com.dervan.module.model.dao;

//@JsonInclude(Include.NON_NULL)
public class DrawRound {
	
	private int partTeamID;
	private String firstTeamName;
	private String lastTeamSchoolName;
	
//	@JsonInclude(Include.NON_NULL)
	private String matchId;
//	@JsonInclude(Include.NON_NULL)
	private String seed;

	
	public int getPartTeamID() {
		return partTeamID;
	}

	public void setPartTeamID(int partTeamID) {
		this.partTeamID = partTeamID;
	}

	public String getFirstTeamName() {
		return firstTeamName;
	}

	public void setFirstTeamName(String firstTeamName) {
		this.firstTeamName = firstTeamName;
	}

	public String getLastTeamSchoolName() {
		return lastTeamSchoolName;
	}

	public void setLastTeamSchoolName(String lastTeamSchoolName) {
		this.lastTeamSchoolName = lastTeamSchoolName;
	}

	public String getSeed() {
		return seed;
	}

	
	public void setSeed(String seed) {
		this.seed = seed;
	}

	public String getMatchId() {
		return matchId;
	}

	
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	
	
}
