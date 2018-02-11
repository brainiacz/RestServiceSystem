package com.dervan.module.rest;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.report.TeamReport;
import com.dervan.module.util.dao.HibernateUtil;

@Path("/teamReport")
public class TeamReportController {

	@POST
	@Path("/showInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String showReportedInfo(Map<String, Integer> inputData){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Map<String, Object> dataMap = TeamReport.getDetails(session, tx, inputData.get("partID"));
		
		return null;
	}
	
	@POST
	@Path("/changeInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String changeReportedInfo(Map<String, Integer> partID){
		return "request2";
	}
}
