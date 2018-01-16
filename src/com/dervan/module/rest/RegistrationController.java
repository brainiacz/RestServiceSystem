package com.dervan.module.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dervan.module.model.dao.Record;
import com.dervan.module.registration.IndividualRegistration;

@Path("/registration")
public class RegistrationController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Map<String, String> getRecordData(Record record){
		
		Map<String, String> data = new HashMap<>();
		String partId = IndividualRegistration.getRegistered(record);
		data.put("partId", partId);
		
		return data;
	}
	
}
