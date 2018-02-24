package com.dervan.module.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.EventData;
import com.dervan.module.model.dao.Game;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.Record;
import com.dervan.module.model.dao.RecordInner;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.model.dao.TeamRecord;
import com.dervan.module.model.dao.TeamRecordInner;
import com.dervan.module.payment.IndividualPayment;
import com.dervan.module.payment.TeamPayment;
import com.dervan.module.update.UpdateIndividualDetails;
import com.dervan.module.update.UpdateTeamDetails;
import com.dervan.module.util.dao.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/updateDetails")
public class UpdateDetailsController {
	
	
	@POST
	@Path("/participant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Map<String, Object>> getStoredDetails(Map<String, Integer> inputData) throws JsonProcessingException{
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	Map<String, Object> data = new HashMap<>();
    	Map<String, Map<String, Object>> parentMap = new HashMap<String, Map<String,Object>>();
		Participant participantData = null;
		//List<EventData> partiGameData = null;
		
		if(inputData != null){
			
			participantData = IndividualPayment.getParticipant(inputData.get("partid"), session, tx);
			//partiGameData = IndividualPayment.getPartiGameData(inputData.get("partid"), session, tx);
		}
		
		data.put("partidetails", participantData);
		//data.put("payData", payData);
		//data.put("games", partiGameData);
		parentMap.put("record", data);
		
		tx.commit();
		session.close();
		
		return parentMap;
	}
	
	
	@POST
	@Path("/partUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Record updateStoredDetails(Record inputData){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Record record = null;
		RecordInner recordInner = null;
		Participant participant = null;
		String amount = null;
		String type = null;
		//List<Game> partiGameData = null;
	
		
		
		
		if(inputData != null){
			record = (Record) inputData;
			participant = record.getRecord().getPartidetails();
			//partiGameData = record.getRecord().getGames();
			//amount = record.getRecord().getAmt();
			//type = record.getRecord().getType();
			
		}
		
		recordInner = UpdateIndividualDetails.getUpdatedDetailsInd(participant,/* partiGameData, */session, tx);
		//recordInner.setAmt(amount);
		//recordInner.setType(type);
		record.setRecord(recordInner);
		tx.commit();
		session.close();
		return record;
	}
	
	
	@POST
	@Path("/partigames")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Map<String, Object>> getGamesStoredDetails(Map<String, Integer> inputData) throws JsonProcessingException{
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	Map<String, Object> data = new HashMap<>();
    	Map<String, Map<String, Object>> parentMap = new HashMap<String, Map<String,Object>>();
		Participant participantData = null;
		List<EventData> partiGameData = null;
		
		if(inputData != null){
			//participantData = IndividualPayment.getParticipant(inputData.get("partid"), session, tx);
			partiGameData = IndividualPayment.getPartiGameData(inputData.get("partid"), session, tx);
		}
		
		//data.put("partidetails", participantData);
		//data.put("payData", payData);
		data.put("games", partiGameData);
		parentMap.put("record", data);
		
		tx.commit();
		session.close();
		
		return parentMap;
	}
	
	
	
	@POST
	@Path("/partGamesUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Record updateGamesStoredDetails(Record inputData){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Record record = null;
		RecordInner recordInner = new RecordInner();
		Participant participant = null;
		String amount = null;
		String type = null;
		List<Game> partiGameData = null;
		List<TeamGame> teamGame = null;
		type = inputData.getRecord().getType();
		int teamid = TeamPayment.getTeamID(inputData.getRecord().getPartidetails().getPartid(), session, tx);
		
		
		
		if(inputData != null){
			record = (Record) inputData;
			participant = record.getRecord().getPartidetails();
			
			if(type.equals("IND")){
				partiGameData = record.getRecord().getGames();
			}else{
				teamGame = getTeamGame(record.getRecord().getGames());
			}
			
			//amount = record.getRecord().getAmt();
			
			
		}
		
		if(type.equals("IND")){
			recordInner = UpdateIndividualDetails.getGamesUpdatedDetailsInd(participant,partiGameData, session, tx);
		}else{
			teamGame = UpdateTeamDetails.getGamesListUpdate(teamid, teamGame, session, tx);
			partiGameData = getGame(teamGame);
		}
		
		recordInner.setGames(partiGameData);
		//recordInner.setAmt(amount);
		//recordInner.setType(type);
		record.setRecord(recordInner);
		tx.commit();
		return record;
	}

	

/**
 * Author : Ajinkya
 * Description : Below part of code is for team aspirants;
 */
	
	@POST
	@Path("/team")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Map<String, Object>> getStoredTeamDetails(Map<String, Integer> inputData) throws JsonProcessingException{
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	
		Map<String, Object> data = new HashMap<>();
    	Map<String, Map<String, Object>> parentMap = new HashMap<String, Map<String,Object>>();
    	
		Participant participantData = null;
		List<EventData> partiGameData = null;
		List<Participant> teamPartiData = null;
		
		if(inputData != null){
			
			participantData = TeamPayment.getCaptainData(inputData.get("captainid"), session, tx);
			partiGameData = TeamPayment.getTeamGameData(inputData.get("captainid"), session, tx);
			teamPartiData = TeamPayment.getParticipantsData(inputData.get("captainid"), session, tx);
			
		}
		
		data.put("partidetails", participantData);
		//data.put("payData", payData);
		data.put("games", partiGameData);
		data.put("tm", teamPartiData);
		parentMap.put("record", data);
		
		tx.commit();
		session.close();
		
		return parentMap;
	}
	
	
	@POST
	@Path("/teamUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TeamRecord updateTeamStoredDetails(TeamRecord inputData){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		TeamRecord record = null;
		TeamRecordInner recordInner = null;
		Participant participant = null;
		List<Participant> listOfParticipants = null;
		int amount = 0;
		String type = null;
		
		List<TeamGame> teamGameData = null;
	
		
		
		
		if(inputData != null){
			record = (TeamRecord) inputData;
			participant = record.getRecord().getPartidetails();
			teamGameData = record.getRecord().getGames();
			amount = record.getRecord().getAmt();
			type = record.getRecord().getType();
			listOfParticipants = record.getRecord().getTm();
			
		}
		
		int teamid = TeamPayment.getTeamID(participant.getPartid(), session, tx);
		recordInner = UpdateTeamDetails.getUpdatedDetailsTeam(listOfParticipants, participant, teamGameData, session, tx, teamid);
		recordInner.setAmt(amount);
		recordInner.setType(type);
		record.setRecord(recordInner);
		tx.commit();
		session.close();
		return record;
	}
	
	
	public static List<TeamGame> getTeamGame(List<Game> games){
		
		List<TeamGame> teamGamesList = new ArrayList<>();
		for(Game game : games){	
			TeamGame teamGame = new TeamGame();
			teamGame.setEventid(game.getEventid());
			teamGamesList.add(teamGame);
		}
		
		return teamGamesList;
	}
	
	public static List<Game> getGame(List<TeamGame> games){
		
		List<Game> gamesList = new ArrayList<>();
		for(TeamGame teaGame : games){	
			Game game = new Game();
			game.setEventid(teaGame.getEventid());
			gamesList.add(game);
		}
		
		return gamesList;
	}

}
