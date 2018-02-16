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
import com.dervan.module.payment.TeamPayment;
import com.dervan.module.utils.CommonUtilities;

public class UpdateTeamDetails {


	public static TeamRecordInner getUpdatedDetailsTeam(List<Participant> listOfPart,Participant partidetails, List<TeamGame> games, Session session,
			Transaction tx, int teamid) {
		
		TeamRecordInner recordInner = new TeamRecordInner();
	
		Participant participant = getPartiDetailsUpdated(partidetails, session, tx, teamid);
		List<Participant> tmDetails = getTeamParticipantUpdated(listOfPart, session, tx);
		List<TeamGame> gamesData = getGamesListUpdate(participant.getPartid(), games, session, tx);
		recordInner.setPartidetails(participant);
		recordInner.setGames(gamesData);
		recordInner.setTm(tmDetails);
		
		
		return recordInner;
	}

	
	public static List<Participant> getTeamParticipantUpdated(List<Participant> participants, Session session, Transaction tx){
		
		for(Participant participantData : participants){
			Query query = session.createSQLQuery(
					"UPDATE PARTICIPANT SET FNAME =:FNAME  , MNAME =:MNAME  , LNAME =:LNAME  , DOB =:DOB  , AGE =:AGE  , SCHOOL =:SCHOOL  , ADDRESS_LINE1 =:ADDRESSLINE1  , ADDRESS_LINE2 =:ADDRESSLINE2  , STATE =:STATE  , CITY =:CITY , PINCODE =:PINCODE , SCHOOL_ADDRESS_LINE1 =:SCHOOLADDRESSLINE1 , SCHOOL_ADDRESS_LINE2 =:SCHOOLADDRESSLINE2 , SCHOOL_STATE =:SCHOOLSTATE , SCHOOL_CITY =:SCHOOLCITY , SCHOOL_PINCODE =:SCHOOLPINCODE , GENDER =:GENDER , PHONE =:PHONE , EMER_PHONE =:EMERPHONE , EMAIL_ID =:EMAILID , BLOOD_GRP =:BLOODGRP , ID_TYPE =:IDTYPE , ID_INT =:IDINT WHERE PART_ID =:PARTID");
			query.setParameter("FNAME", participantData.getFirstname());
			query.setParameter("MNAME", participantData.getMiddlename());
			query.setParameter("LNAME", participantData.getLastname());
			query.setParameter("DOB", participantData.getDob());
			query.setParameter("AGE", participantData.getAge());
			query.setParameter("SCHOOL", participantData.getNameOfSchoolOrClub());
			query.setParameter("ADDRESSLINE1", participantData.getAddr1());
			query.setParameter("ADDRESSLINE2", participantData.getAddr2());
			query.setParameter("STATE", participantData.getState());
			query.setParameter("CITY", participantData.getCity());
			query.setParameter("PINCODE", participantData.getPincode());
			query.setParameter("SCHOOLADDRESSLINE1", participantData.getAddressOfSchoolOrClub());
			query.setParameter("SCHOOLADDRESSLINE2", participantData.getAddress2OfSchoolOrClub());
			query.setParameter("SCHOOLSTATE", participantData.getSchoolstate());
			query.setParameter("SCHOOLCITY", participantData.getSchoolcity());
			query.setParameter("SCHOOLPINCODE", participantData.getSchoolpincode());
			query.setParameter("GENDER", participantData.getGender());
			query.setParameter("PHONE", participantData.getContactno());
			query.setParameter("EMERPHONE", participantData.getAlternativeno());
			query.setParameter("EMAILID", participantData.getEmail());
			query.setParameter("BLOODGRP", participantData.getBloodgroup());
			query.setParameter("IDTYPE", participantData.getIdentitytype());
			query.setParameter("IDINT", participantData.getIdentitynumber());
			query.setParameter("PARTID", participantData.getPartid());
			
			query.executeUpdate();
		}
		
		return participants;
	}
	
	
	public static Participant getPartiDetailsUpdated(Participant partidetails, Session session, Transaction tx, int teamid) {
		
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
		
		Query query1 = session.createSQLQuery("UPDATE TEAM SET TEAM_NAME =:TEAMNAME, TEAM_SCHOOL =:TEAMSCHOOL, TEAM_SCHOOL_ADD1 =:TEAMSCHOOLADD1,TEAM_SCHOOL_ADD2 =:TEAMSCHOOLADD2,TEAM_SCHOOL_CITY =:TEAMSCHOOLCITY,TEAM_SCHOOL_STATE =:TEAMSCHOOLSTATE,TEAM_SCHOOL_PINCODE =:TEAMSCHOOLPINCODE WHERE TEAM_ID =:TEAMID");
		
		query1.setParameter("TEAMNAME", partidetails.getNameOfSchoolOrClub());
		query1.setParameter("TEAMSCHOOL", partidetails.getNameOfSchoolOrClub());
		query1.setParameter("TEAMSCHOOLADD1", partidetails.getAddressOfSchoolOrClub());
		query1.setParameter("TEAMSCHOOLADD2", partidetails.getAddress2OfSchoolOrClub());
		query1.setParameter("TEAMSCHOOLCITY", partidetails.getSchoolcity());
		query1.setParameter("TEAMSCHOOLSTATE", partidetails.getSchoolstate());
		query1.setParameter("TEAMSCHOOLPINCODE", partidetails.getSchoolpincode());
		query1.setParameter("TEAMID", teamid);
		int result1 = query1.executeUpdate();
		
		if(result > 0  && result1 > 0){
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
