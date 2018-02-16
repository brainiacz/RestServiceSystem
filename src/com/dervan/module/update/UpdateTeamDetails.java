package com.dervan.module.update;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.model.dao.TeamRecordInner;
import com.dervan.module.utils.CommonUtilities;

public class UpdateTeamDetails {


	public static TeamRecordInner getUpdatedDetailsTeam(List<Participant> listOfPart,Participant partidetails, List<TeamGame> games, Session session,
			Transaction tx) {
		
		TeamRecordInner recordInner = new TeamRecordInner();
	
		Participant participant = getPartiDetailsUpdated(partidetails, session, tx);
		List<Participant> tmDetails = getTeamParticipantUpdated(listOfPart, session, tx);
		List<TeamGame> gamesData = getGamesListUpdate(participant.getPartid(), games, session, tx);
		recordInner.setPartidetails(participant);
		recordInner.setGames(gamesData);
		recordInner.setTm(tmDetails);
		
		
		return recordInner;
	}

	
	public static List<Participant> getTeamParticipantUpdated(List<Participant> participants,Session session, Transaction tx){
		
		for(Participant participantData : participants){
			session.update(participantData);
		}
		return participants;
	}
	
	
	public static Participant getPartiDetailsUpdated(Participant partidetails, Session session, Transaction tx) {
		Query query = session.createSQLQuery(
				"UPDATE PARTICIPANT SET FNAME =:FNAME  , MNAME =:MNAME  , LNAME =:LNAME  , DOB =:DOB  , AGE =:AGE  , SCHOOL =:SCHOOL  , ADDRESS_LINE1 =:ADDRESSLINE1  , ADDRESS_LINE2 =:ADDRESSLINE2  , STATE =:STATE  , CITY =:CITY , PINCODE =:PINCODE , SCHOOL_ADDRESS_LINE1 =:SCHOOLADDRESSLINE1 , SCHOOL_ADDRESS_LINE2 =:SCHOOLADDRESSLINE2 , SCHOOL_STATE =:SCHOOLSTATE , SCHOOL_CITY =:SCHOOLCITY , SCHOOL_PINCODE =:SCHOOLPINCODE , GENDER =:GENDER , PHONE =:PHONE , EMER_PHONE =:EMERPHONE , EMAIL_ID =:EMAILID , BLOOD_GRP =:BLOODGRP , ID_TYPE =:IDTYPE , ID_INT =:IDINT WHERE PART_ID =:PARTID");
		query.setParameter("FNAME", partidetails.getFirstname());
		query.setParameter("MNAME", partidetails.getMiddlename());
		query.setParameter("LNAME", partidetails.getLastname());
		query.setParameter("DOB", partidetails.getDob());
		query.setParameter("AGE", partidetails.getAge());
		query.setParameter("SCHOOL", partidetails.getNameOfSchoolOrClub());
		query.setParameter("ADDRESSLINE1", partidetails.getAddr1());
		query.setParameter("ADDRESSLINE2", partidetails.getAddr2());
		query.setParameter("STATE", partidetails.getState());
		query.setParameter("CITY", partidetails.getCity());
		query.setParameter("PINCODE", partidetails.getPincode());
		query.setParameter("SCHOOLADDRESSLINE1", partidetails.getAddressOfSchoolOrClub());
		query.setParameter("SCHOOLADDRESSLINE2", partidetails.getAddress2OfSchoolOrClub());
		query.setParameter("SCHOOLSTATE", partidetails.getSchoolstate());
		query.setParameter("SCHOOLCITY", partidetails.getSchoolcity());
		query.setParameter("SCHOOLPINCODE", partidetails.getSchoolpincode());
		query.setParameter("GENDER", partidetails.getGender());
		query.setParameter("PHONE", partidetails.getContactno());
		query.setParameter("EMERPHONE", partidetails.getAlternativeno());
		query.setParameter("EMAILID", partidetails.getEmail());
		query.setParameter("BLOODGRP", partidetails.getBloodgroup());
		query.setParameter("IDTYPE", partidetails.getIdentitytype());
		query.setParameter("IDINT", partidetails.getIdentitynumber());
		query.setParameter("PARTID", partidetails.getPartid());
		int result = query.executeUpdate();
		
		Team team = new Team();
		
		team.setTeamName(partidetails.getNameOfSchoolOrClub());
		team.setTeamSchool(partidetails.getNameOfSchoolOrClub());
		team.setTeamSchoolAdd1(partidetails.getAddressOfSchoolOrClub());
		team.setTeamSchoolAdd2(partidetails.getAddress2OfSchoolOrClub());
		team.setTeamSchoolCity(partidetails.getSchoolcity());
		team.setTeamSchoolState(partidetails.getSchoolstate());
		team.setTeamSchoolPincode(partidetails.getSchoolpincode());
		session.update(team);
		
		team = null;
		
		if(result > 0){
			return partidetails;
		}
		return null;
	}
	
	public static List<TeamGame> getGamesListUpdate(int teamid, List<TeamGame> gamedata, Session session, Transaction tx){
		Query query = session.createSQLQuery("DELETE FROM TEAM_GAME WHERE TEAM_ID = :TEAMID");
		query.setParameter("TEAMID", teamid);
		int result = query.executeUpdate();
		
		if (result > 0) {
		    System.out.println("Deleted the existing games.");
		}
		
		List<TeamGame> listOfGames = new ArrayList<>();
		for(TeamGame games : gamedata){
			
			TeamGame teamGame = new TeamGame();
			
			teamGame.setEventid(games.getEventid());
			teamGame.setTeamId(teamid);
			teamGame.setInsertUserName(CommonUtilities.getUsername());
			teamGame.setUpdateUserName(CommonUtilities.getUsername());
			teamGame.setInsertDateTime(CommonUtilities.getDate());
			teamGame.setUpdateDateTime(CommonUtilities.getDate());
			session.save(teamGame);
			
			listOfGames.add(teamGame);
			teamGame = null;
		}
		return listOfGames;
	}

}
