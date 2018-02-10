package com.dervan.module.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dervan.module.model.dao.TeamRecord;
import com.dervan.module.registration.TeamRegistration;

@Path("/teamRegister")
public class TeamRegistrationController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Map<String, String> getTeamRecordData(TeamRecord record) {
		
		Map<String, String> data = new HashMap<>();
		String partId = TeamRegistration.getRegistered(record.getRecord());
		data.put("captainID", partId);
		
		return data;
	}
	
}
