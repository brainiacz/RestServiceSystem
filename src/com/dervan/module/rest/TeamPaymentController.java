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

import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.payment.TeamPayment;
import com.dervan.module.util.dao.HibernateUtil;

@Path("/teamPayment")
public class TeamPaymentController {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
public  Map<String, Object> getPaymentUpdated(Map<String, Integer> inputData){
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	Map<String, Object> data = new HashMap<>();
    	
		Team teamData = null;
		PayRepDtl payData = null;
		List<TeamGame> teamGameData = null;
		
		if(inputData != null){
			
			
			teamData = TeamPayment.getTeamData(inputData.get("teamId"), session, tx);
			payData = TeamPayment.getPaymentDetails(inputData.get("teamId"), session, tx);
			teamGameData = TeamPayment.getTeamGameData(inputData.get("teamId"), session, tx);
		}
		
		data.put("participant", teamData);
		data.put("payData", payData);
		data.put("partiGame",teamGameData);
		
				
		return data;
	}
}
