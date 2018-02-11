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
	
	public Map<String, Object> getSuccessForPay(Map<String, String> inputData){
		int partID = null != inputData.get("partID") ? Integer.parseInt(inputData.get("partID")) : 0;
		int amount = null != inputData.get("amt") ? Integer.parseInt(inputData.get("amt")) : 0;
		String user = null != inputData.get("user") ? inputData.get("user") : "";
		Map<String, Object> mapData = IndividualPayment.getPayment(partID,amount,user );
		return mapData;
	}
}
