package com.dervan.module.rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.payment.TeamPayment;
import com.dervan.module.util.dao.HibernateUtil;

@Path("/acceptTeamPay")
public class AcceptPaymentTeamController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Map<String, Object> getSuccessForPay(Map<String, Integer> inputData){
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Map<String, Object> mapData = TeamPayment.getPayment(TeamPayment.getTeamData(inputData.get("captainID"), session, tx).getTeamId());		
		return mapData;
	}

	
}
