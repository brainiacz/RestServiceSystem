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

import com.dervan.module.model.dao.EventData;
import com.dervan.module.model.dao.PartiGame;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.payment.IndividualPayment;
import com.dervan.module.util.dao.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/indPayment")
public class IndividualPaymentController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Map<String, Object>> getPaymentUpdated(Map<String, Integer> inputData) throws JsonProcessingException{
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	Map<String, Object> data = new HashMap<>();
    	Map<String, Map<String, Object>> parentMap = new HashMap<String, Map<String,Object>>();
		Participant participantData = null;
		List<EventData> partiGameData = null;
		
		if(inputData != null){
			
			participantData = IndividualPayment.getParticipant(inputData.get("partid"), session, tx);
			partiGameData = IndividualPayment.getPartiGameData(inputData.get("partid"), session, tx);
		}
		
		data.put("partidetails", participantData);
		//data.put("payData", payData);
		data.put("games", partiGameData);
		parentMap.put("record", data);
		session.close();		
		return parentMap;
	}
	
	
	
	
	
}
