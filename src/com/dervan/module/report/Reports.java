package com.dervan.module.report;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Game;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;

public class Reports {
	
public static List<Object> getParticipantReport(Session session, Transaction transaction){
		
		SQLQuery query = session.createSQLQuery("select participant.*,pay_rep_dtls.KYC_CHECK from participant join pay_rep_dtls "
				+ "on participant.PART_ID=pay_rep_dtls.PART_TEAM_ID");
		
		List<Object[]> dataList = query.list();
		List<Object> participantReportList = new ArrayList<Object>();
		
		for(Object[] row : dataList){
			Participant participant = new Participant();
			PayRepDtl payRepDtl = new PayRepDtl();
			participant.setPartid(Integer.parseInt(row[0].toString()));
			participant.setFirstname(null != row[1] ? row[1].toString() : "");
			participant.setMiddlename(null != row[2] ? row[2].toString() : "");
			participant.setLastname(null != row[3] ? row[3].toString() : "");
			participant.setDob(null != row[4] ? row[4].toString() : "");	
			participant.setAge(null != row[5] ? row[5].toString() : "");
			participant.setNameOfSchoolOrClub(null != row[6] ? row[6].toString() : "");
			participant.setAddr1(null != row[7] ? row[7].toString() : "");
			participant.setAddr2(null != row[8] ? row[8].toString() : "");
			participant.setState(null != row[9] ? row[9].toString() : "");
			participant.setCity(null != row[10] ? row[10].toString() : "");
			participant.setPincode(null != row[11] ?row[11].toString():"");
			participant.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
			participant.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
			participant.setSchoolstate(null != row[14] ? row[14].toString() : "");
			participant.setSchoolcity(null != row[15] ? row[15].toString() : "");
			participant.setSchoolpincode(null != row[16] ? row[16].toString(): "");
			participant.setGender(null != row[17] ? row[17].toString() : "");
			participant.setContactno(null != row[18] ? row[18].toString() : "");
			participant.setAlternativeno(null != row[19] ? row[19].toString() : "");
			participant.setEmail(null != row[20] ? row[20].toString() : "");
			participant.setBloodgroup(null != row[21] ? row[21].toString() : "");
			participant.setIdentitytype(null != row[22] ? row[22].toString() : "");
			participant.setIdentitynumber(null != row[23] ? row[23].toString() : "");
			
			payRepDtl.setKycCheck(null != row[24] ? row[24].toString() : "N");
			
			participantReportList.add(participant);
			participantReportList.add(payRepDtl);
			
			participant=null;
			payRepDtl=null;
		}
		
		
		return participantReportList;
	}

public static List<Participant> getTeamReport(int gameID, Session session, Transaction transaction){
	
	SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID  IN ("+
			"SELECT PART_ID FROM PARTI_GAME WHERE GAME_ID ="+gameID+");");
	
	List<Object[]> dataList = query.list();
	List<Participant> participantList = new ArrayList<Participant>();
	
	for(Object[] row : dataList){
		Participant participant = new Participant();
		participant.setPartid(Integer.parseInt(row[0].toString()));
		participant.setFirstname(null != row[1] ? row[1].toString() : "");
		participant.setMiddlename(null != row[2] ? row[2].toString() : "");
		participant.setLastname(null != row[3] ? row[3].toString() : "");
		participant.setDob(null != row[4] ? row[4].toString() : "");	
		participant.setAge(null != row[5] ? row[5].toString() : "");
		participant.setNameOfSchoolOrClub(null != row[6] ? row[6].toString() : "");
		participant.setAddr1(null != row[7] ? row[7].toString() : "");
		participant.setAddr2(null != row[8] ? row[8].toString() : "");
		participant.setState(null != row[9] ? row[9].toString() : "");
		participant.setCity(null != row[10] ? row[10].toString() : "");
		participant.setPincode(null != row[11] ?row[11].toString():"");
		participant.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
		participant.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
		participant.setSchoolstate(null != row[14] ? row[14].toString() : "");
		participant.setSchoolcity(null != row[15] ? row[15].toString() : "");
		participant.setSchoolpincode(null != row[16] ? row[16].toString(): "");
		participant.setGender(null != row[17] ? row[17].toString() : "");
		participant.setContactno(null != row[18] ? row[18].toString() : "");
		participant.setAlternativeno(null != row[19] ? row[19].toString() : "");
		participant.setEmail(null != row[20] ? row[20].toString() : "");
		participant.setBloodgroup(null != row[21] ? row[21].toString() : "");
		participant.setIdentitytype(null != row[22] ? row[22].toString() : "");
		participant.setIdentitynumber(null != row[23] ? row[23].toString() : "");
		participantList.add(participant);
		participant=null;
	}
	
	
	return participantList;
}

public static int getGameID(String discipline, String category, String event, Session session, Transaction transaction){
	
	SQLQuery query = session.createSQLQuery("SELECT GAME_ID FROM GAME WHERE DISCIPLINE ='"+discipline+"' and CATEGORY = '"+category+"' and EVENT = '"+event+"'");
	Object data = query.uniqueResult();
	Game game = new Game();
	game.setEventid(Integer.parseInt(data.toString()));
	
	return game.getEventid();
}

}
