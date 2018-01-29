package com.dervan.module.rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dervan.module.payment.IndividualPayment;

@Path("/acceptIndPay")
public class AcceptPaymentIndController {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Map<String, Object> getSuccessForPay(Map<String, Integer> inputData){
		Map<String, Object> mapData = IndividualPayment.getPayment(inputData.get("partID"));
		return mapData;
	}
}
