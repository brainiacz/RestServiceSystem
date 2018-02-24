package com.dervan.module.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.EventData;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.Team;
import com.dervan.module.payment.IndividualPayment;
import com.dervan.module.payment.TeamPayment;
import com.dervan.module.report.IndividualReport;
import com.dervan.module.report.TeamReport;
import com.dervan.module.util.dao.HibernateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/teamReport")
public class TeamReportController {

	@POST
	@Path("/showInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  Map<String, Map<String, Object>> getReportData(Map<String, Integer> inputData) throws JsonProcessingException{
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	Map<String, Object> data = new HashMap<>();
    	Map<String, Map<String, Object>> parentData = new HashMap<>();
    	
		Team teamData = null;
		List<EventData> teamGameData = null;
		Participant captainData = null;
		List<Participant> participantDataList = null;
		PayRepDtl payDetails = null;
		if(inputData != null){
			teamData = TeamPayment.getTeamData(inputData.get("captainid"), session, tx);
			teamGameData = TeamPayment.getTeamGameData(inputData.get("captainid"), session, tx);
			captainData = TeamPayment.getCaptainData(inputData.get("captainid"), session, tx);
			participantDataList = TeamPayment.getParticipantsData(inputData.get("captainid"), session, tx);
			payDetails = TeamPayment.getPaymentDetails(inputData.get("captainid"), session, tx);
		}
		
		data.put("partidetails", getTeamCaptainData(teamData, captainData));
		data.put("tm", participantDataList);
		data.put("games",teamGameData);
		data.put("reportingflag", payDetails.getReportedFlg());
		data.put("kyccheck", payDetails.getKycCheck());
		data.put("paymentflag", payDetails.getPayFlag());
		
		parentData.put("record", data);
		session.close();
		return parentData;
	}
	
	
	@POST
	@Path("/changeInfo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String, Object> changeReportedInfo(Map<String, String> inputData ){

		int partId = null != inputData.get("captainid") ? Integer.parseInt(inputData.get("captainid")) : 0;
		String kycFlag = null != inputData.get("kycflag") ? String.valueOf(inputData.get("kycflag")) : "";
		String reportingFlag = null != inputData.get("reportingflag") ? String.valueOf(inputData.get("reportingflag")) : "";
		
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
    	
		Map<String, Object> dataMap = TeamReport.changeReportStatusTeam(session, tx, partId, reportingFlag, kycFlag);
		
		return dataMap;
	}
	
	
	public static Participant getTeamCaptainData(Team teamData, Participant participantData){
		
		Participant participant = new Participant();
		
		participant.setPartid(participantData.getPartid());
		participant.setFirstname(participantData.getFirstname());
		participant.setMiddlename(participantData.getMiddlename());
		participant.setLastname(participantData.getLastname());
		participant.setAddr1(participantData.getAddr1());
		participant.setAddr2(participantData.getAddr2());
		participant.setState(participantData.getState());
		participant.setCity(participantData.getCity());
		participant.setPincode(participantData.getPincode());
		participant.setNameOfSchoolOrClub(participantData.getNameOfSchoolOrClub());
		participant.setAddressOfSchoolOrClub(participantData.getAddressOfSchoolOrClub());
		participant.setAddress2OfSchoolOrClub(participantData.getAddress2OfSchoolOrClub());
		participant.setSchoolstate(participantData.getSchoolstate());
		participant.setSchoolcity(participantData.getSchoolcity());
		participant.setSchoolpincode(participantData.getSchoolpincode());
		participant.setDob(participantData.getDob());
		participant.setContactno(participantData.getContactno());
		participant.setAlternativeno(participantData.getAlternativeno());
		participant.setEmail(participantData.getEmail());
		participant.setGender(participantData.getGender());
		participant.setBloodgroup(participantData.getBloodgroup());
		participant.setIdentitynumber(participantData.getIdentitynumber());
		participant.setIdentitytype(participantData.getIdentitytype());
		participant.setAge(participantData.getAge());
		return participant;
	}
}
