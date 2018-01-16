package com.dervan.module.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dervan.module.Login.LoginController;
import com.dervan.module.model.dao.Member;
import com.dervan.module.model.dao.Participant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;



@Path("/Login")
public class LoginRestController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String login( Member inputData){
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configOverride(Participant.class).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.ARRAY));
		String json = "";
		Member member = LoginController.getAutheticated(inputData);
		member.setPass("");
		 try {
	           json =  mapper.writeValueAsString(member);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return json;
	}
	
}
