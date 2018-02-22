package com.dervan.module.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.dervan.module.model.dao.DrawRound;

public class DrawRoundsImplementor {

	
	public static List<DrawRound> getParticipantDetails(Integer gameId,Session session){
	
		SQLQuery sqlQuery = session.createSQLQuery( "SELECT PART_ID,FNAME,LNAME FROM PARTICIPANT WHERE PART_ID IN (SELECT PART_ID FROM PARTI_GAME WHERE GAME_ID ="+ gameId + ");");
		List<Object[]> partList = sqlQuery.list();
		
		List<DrawRound> partiDtl = new ArrayList<DrawRound>();
		
		for(Object[] list :partList){
			
			DrawRound participant = new DrawRound();
			participant.setPartTeamID(null != list[0] ? Integer.parseInt(list[0].toString()) : -1);
			participant.setFirstTeamName(null != list[1] ? list[1].toString() : "");
			participant.setLastTeamSchoolName(null != list[2] ? list[2].toString() : "");			
			partiDtl.add(participant);	
		}
		return partiDtl;
	}
	
	
	public static List<DrawRound> getTeamDetails(Integer gameId,Session session){
		
		SQLQuery sqlQuery = session.createSQLQuery("SELECT TEAM_ID,TEAM_NAME,TEAM_SCHOOL FROM TEAM WHERE TEAM_ID IN (SELECT TEAM_ID FROM TEAM_GAME WHERE GAME_ID ="+ gameId +");");
		List<Object[]> teamList = sqlQuery.list();
		
		List<DrawRound> teamDtl = new ArrayList<>();
		
		for(Object[] team : teamList){
			
			DrawRound curTeam = new DrawRound();
			curTeam.setPartTeamID(null != team[0] ? Integer.parseInt(team[0].toString()) : -1);
			curTeam.setFirstTeamName(null != team[1] ? team[1].toString() : "");
			curTeam.setLastTeamSchoolName(null != team[2] ? team[1].toString() : "");
			teamDtl.add(curTeam);
		}
		
		return teamDtl;
		
	}
	
}
