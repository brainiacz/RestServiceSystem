package com.dervan.module.rest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;

import com.dervan.module.model.dao.DrawRound;
import com.dervan.module.service.DrawRoundsImplementor;
import com.dervan.module.service.RoundStatistic;
import com.dervan.module.util.dao.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("/drawround/")
public class DrawRoundsController {

	@POST
	@Path("/partiteamdtl/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Object> getParticipantDetails(Map<String,Integer> request) throws JsonProcessingException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Map<String,Object> partiTeamDtl = new HashMap<String, Object>();
		
		/*1==Participant 2==Team*/
		if(null != request && null != request.get("type") &&  request.get("type").equals(1)){
			List<DrawRound> partiList = DrawRoundsImplementor.getParticipantDetails(null != request.get("gameId") ? request.get("gameId") : -1,session);
			partiTeamDtl.put("details", partiList);
		}else{
			List<DrawRound> teamList = DrawRoundsImplementor.getTeamDetails(null != request.get("gameId") ? request.get("gameId") : -1, session);
			partiTeamDtl.put("details", teamList);
		}
		return partiTeamDtl;
	}
	
	
	// INPUT : [{ "partid": "1", "firstName": "Gulshan", "lastName": "Khubnani", "seed": "-1" }]
	// OUTPUT [{participantFirst:"Second  Name", participantSecond:"Second Name" }]
	@POST
	@Path("/seed/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Object> drawRounds(Map<String,Object> request) throws JsonProcessingException{
	
		Map<String,Object> finalRound = new HashMap<>();
		List<DrawRound> finalList = new ArrayList<>();
		ArrayList founderList = (ArrayList) request.get("details");
		
		//Get Maximum Seed
		ArrayList<Integer> maxSeedNum = new ArrayList<>();
		for(Object lst : founderList){
			HashMap<String,String> map =  (HashMap<String, String>) lst;
			System.out.println(map.get("seed"));
			maxSeedNum.add(Integer.valueOf(map.get("seed")));
		}
		
		int maxSeed = Collections.max(maxSeedNum)+1;
		
		System.out.println("");
		TreeMap<Integer,HashMap<String,String>> sortedMap = new TreeMap<>();
		for(Object lst : founderList){
			HashMap<String,String> map =  (HashMap<String, String>) lst;
			if(map.get("seed").equals("-1") || map.get("seed").equals(-1)){
				sortedMap.put(maxSeed++, map);
			}else{
				sortedMap.put(Integer.valueOf(map.get("seed")), map);
			}
		}
		
		System.out.println(" New sortedMap " +sortedMap );
	
		int min = 1;
		int maxThreshold = 0;
		
		if(null != founderList){
			maxThreshold = getMaxBye(founderList.size());
		}
		Map<Integer,ArrayList<Integer>> partTeamStat = getRoundStastic(maxThreshold);
		
		while(min <= (maxThreshold / 2)){
			
			DrawRound drawRound = new DrawRound();
			
			ArrayList<Integer> playerList = partTeamStat.get(min);
			
			if(null != sortedMap && null != sortedMap.get((min))){
				HashMap<String,String> partiOne =   sortedMap.get(playerList.get(0));
				drawRound.setFirstTeamName(partiOne.get("firstTeamName") + " " + partiOne.get("lastTeamSchoolName"));
				
				if(null != partTeamStat && null != partTeamStat.get((min)) && null != sortedMap.get(playerList.get(1)) ){
					Map<String,String> partiTwo =  sortedMap.get(playerList.get(1));
					drawRound.setLastTeamSchoolName(partiTwo.get("firstTeamName") +" "+ partiTwo.get("lastTeamSchoolName"));
				}else{
					drawRound.setLastTeamSchoolName("Bye");
				}
				drawRound.setMatchId(String.valueOf(min));
			}
			min++;
			finalList.add(drawRound);
		}
		
		finalRound.put("rounds", finalList);
	
		return finalRound;	
	}
	
	private int getMaxBye(int maxLength){		
		int min = 2;
		int max = 1;
		while( max < maxLength){
			max = max * min;
		}
		return max;
	}
	private Map<Integer,ArrayList<Integer>> getRoundStastic(int threshold){
		Map<Integer,ArrayList<Integer>> partTeamSize = null;
		if(threshold == 2){
			partTeamSize = RoundStatistic.partTeam2inSize;
		}else if(threshold == 4){
			partTeamSize = RoundStatistic.partTeam4inSize;
		}else if(threshold == 8){
			partTeamSize = RoundStatistic.partTeam8inSize;
		}else if(threshold == 16){
			partTeamSize = RoundStatistic.partTeam16inSize;
		}else if(threshold == 32){
			partTeamSize = RoundStatistic.partTeam32inSize;
		}else if(threshold == 64){
			partTeamSize = RoundStatistic.partTeam64inSize;
		}
		return partTeamSize;
	}
	
//	public static void main(String args[]){
//		int i = 64;
//		Map<Integer,Integer> partTeam4inSize = null;
//		if(i ==1){
//		partTeam4inSize = RoundStatistic.partTeam4inSize;
//		}else if(i ==64){
//		partTeam4inSize = RoundStatistic.partTeam64inSize;
//		}
//		
//		
//		System.out.println("....." + partTeam4inSize);
//	}
	
}
