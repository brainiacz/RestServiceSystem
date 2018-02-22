package com.dervan.module.update;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Game;
import com.dervan.module.model.dao.PartiGame;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.RecordInner;
import com.dervan.module.utils.CommonUtilities;

public class UpdateIndividualDetails {

	public static RecordInner getUpdatedDetailsInd(Participant partidetails,/* List<Game> games,*/ Session session,
			Transaction tx) {
		
		RecordInner recordInner = new RecordInner();
	
		Participant participant = getPartiDetailsUpdated(partidetails, session, tx);
		//List<Game> gamesData = getGamesListUpdate(participant.getPartid(), games, session, tx);
		recordInner.setPartidetails(participant);
		//recordInner.setGames(gamesData);
		
		
		return recordInner;
	}
	
	public static RecordInner getGamesUpdatedDetailsInd(Participant participant,   List<Game> games, Session session,Transaction tx) {
		
		RecordInner recordInner = new RecordInner();
	
		//Participant participant = getPartiDetailsUpdated(partidetails, session, tx);
		List<Game> gamesData = getGamesListUpdate(participant.getPartid(), games, session, tx);
		//recordInner.setPartidetails(participant);
		recordInner.setGames(gamesData);
		
		
		return recordInner;
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
		
		if(result > 0){
			return partidetails;
		}
		return partidetails;
	}
	
	public static List<Game> getGamesListUpdate(int partid, List<Game> gamedata, Session session, Transaction tx){
		Query query = session.createSQLQuery("DELETE FROM PARTI_GAME WHERE PART_ID = :PARTID");
		query.setParameter("PARTID", partid);
		int result = query.executeUpdate();
		
		if (result > 0) {
		    System.out.println("Deleted the existing games.");
		}
		
		for(Game games : gamedata){
			
			PartiGame partGame = new PartiGame();
			
			partGame.setGameId(games.getEventid());
			partGame.setPartId(partid);
			partGame.setInsertUserName(CommonUtilities.getUsername());
			partGame.setUpdateUserName(CommonUtilities.getUsername());
			partGame.setInsertDateTime(CommonUtilities.getDate());
			partGame.setUpdateDateTime(CommonUtilities.getDate());
			session.save(partGame);
			partGame = null;
		}
		tx.commit();
		session.close();
		return gamedata;
	}
}
