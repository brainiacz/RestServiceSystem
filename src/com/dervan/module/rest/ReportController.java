package com.dervan.module.rest;

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

import com.dervan.module.model.dao.Participant;
import com.dervan.module.report.Reports;
import com.dervan.module.util.dao.HibernateUtil;

@Path("/reports")
public class ReportController {
	@POST
	@Path("/participantReport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getPartDump(){
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Map<String, Object> data = new HashMap<>();
		List<Object> participantList =  Reports.getParticipantReport(session, tx);
		data.put("participantReport", participantList);
		return data;
	}
	
	
	@POST
	@Path("/teamPartiReport")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Object> getTeamReport(Map<String, String> inputData){
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Map<String, Object> data = new HashMap<>();
		
		List<Participant> participantListAsPerGame = null;
		
		if(null != inputData){
			int gameId = Reports.getGameID(inputData.get("discipline"), inputData.get("category"), inputData.get("event"), session, tx);
			participantListAsPerGame = Reports.getTeamReport(gameId, session, tx);	
		}
		
		data.put("teamPartiReport", participantListAsPerGame);
		
		return data;
	}

}
