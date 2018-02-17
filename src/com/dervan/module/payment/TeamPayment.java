package com.dervan.module.payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.EventData;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.ReceiptMaster;
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.util.dao.HibernateUtil;
import com.dervan.module.utils.CommonUtilities;
import com.sun.java.swing.plaf.motif.resources.motif;

public class TeamPayment {

	public static Team getTeamData(int captainID, Session session, Transaction transaction){
			
		SQLQuery query = session.createSQLQuery("SELECT * FROM TEAM WHERE CAPTAIN_PART_ID = "+captainID+"");
		List<Object[]> dataList = query.list();
		
		Team team = new Team();
		
		for(Object[] row : dataList ){
			team.setTeamId(Integer.parseInt(row[0].toString()));
			team.setTeamName(null != row[1] ? row[1].toString() : "");
			team.setTeamSchool(null != row[2] ? row[2].toString() : "");
			team.setTeamSchoolAdd1(null != row[3] ? row[3].toString() : "");
			team.setTeamSchoolAdd2(null != row[4] ? row[4].toString() : "");
			team.setTeamSchoolCity(null != row[5] ? row[5].toString() : "");
			team.setTeamSchoolState(null != row[6] ? row[6].toString() : "");
			team.setTeamSchoolPincode(null != row[7] ? row[7].toString() : "");
			team.setCaptainPartId(null != row[12] ? Integer.parseInt(row[12].toString()) : -1);
			
			break;
		}
		
		return team;
	}
	
	public static PayRepDtl getPaymentDetails(int captainID, Session session, Transaction transaction){
		
		SQLQuery query2 = session.createSQLQuery("SELECT * FROM PAY_REP_DTLS WHERE PART_TEAM_ID IN (SELECT TEAM_ID FROM TEAM WHERE CAPTAIN_PART_ID ="+ captainID+")");
		List<Object[]> dataList = query2.list();
		
		PayRepDtl dtls = new PayRepDtl();
		for(Object[] row : dataList){
			dtls.setPayId(Integer.valueOf(row[0].toString()));
			dtls.setPartTeamId(Integer.valueOf(row[1].toString()));
			dtls.setPayAmt(Integer.valueOf(row[2].toString()));
			dtls.setPayFlag(null != row[3] ? row[3].toString() : "");
			dtls.setPayUsr(null != row[5] ? row[5].toString() : "");
			dtls.setReceiptNbr(null != row[6] ? Integer.valueOf(row[1].toString()) : -1);
			dtls.setKycCheck(null != row[11] ? row[11].toString() : "N");
			dtls.setReportedFlg(null != row[8] ? row[8].toString() : "N");
			break;
		}
		
		return dtls;
	}
	
	public static List<EventData> getTeamGameData(int captainID, Session session, Transaction transaction){
		
		SQLQuery query1 = session.createSQLQuery("SELECT GAME_ID, DISCIPLINE, AGE_GRP, CATEGORY, EVENT FROM SPORT_DATABASE.GAME WHERE GAME_ID IN (SELECT GAME_ID FROM TEAM_GAME WHERE TEAM_ID IN (SELECT TEAM_ID FROM TEAM WHERE CAPTAIN_PART_ID ="+ captainID+"))");
		List<Object[]> dataList = query1.list();
		
		List<EventData> teamGameData  = new ArrayList<>();
		
		
		for(Object[] row : dataList){
			EventData data = new EventData();
			data.setEventid(null != row[0] ? row[0].toString() : "");
			data.setName(null != row[1] ? row[1].toString() : "");
			data.setMinage(null != row[2] ? row[2].toString().replace("U", "") : "");
			data.setText(null != row[4] ? row[4].toString() : "");
			
			teamGameData.add(data);
			data = null;}
		
		return teamGameData;
	}
	
	
	public static Participant getCaptainData(int captainID, Session session, Transaction transaction){

		SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID = "+captainID+"");
		List<Object[]> dataList = query.list();
		
		Participant captainData = new Participant();
		
		for(Object[] row : dataList ){
			captainData.setPartid(null != row[0] ? Integer.parseInt(row[0].toString()) : -1);
			captainData.setFirstname(null != row[1] ? row[1].toString() : "");
			captainData.setMiddlename(null != row[2] ? row[2].toString() : "");
			captainData.setLastname(null != row[3] ? row[3].toString() : "");
			captainData.setDob(null != row[4] ? row[4].toString() : "");
			captainData.setAge(null != row[5] ? row[5].toString() : "");
			captainData.setNameOfSchoolOrClub(null != row[6] ? row[6].toString() : "");
			captainData.setAddr1(null != row[7] ? row[7].toString() : "");
			captainData.setAddr2(null != row[8] ? row[8].toString() : "");
			captainData.setState(null != row[9] ? row[9].toString() : "");
			captainData.setCity(null != row[10] ? row[10].toString() : "");
			captainData.setPincode(null != row[11] ? row[11].toString() : "");
			captainData.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
			captainData.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
			captainData.setSchoolstate(null != row[14] ? row[14].toString() : "");
			captainData.setSchoolcity(null != row[15] ? row[15].toString() : "");
			captainData.setSchoolpincode(null != row[16] ? row[16].toString() : "");
			captainData.setGender(null != row[17] ? row[17].toString() : "");
			captainData.setContactno(null != row[18] ? row[18].toString() : "");
			captainData.setAlternativeno(null != row[19] ? row[19].toString() : "");
			captainData.setEmail(null != row[20] ? row[20].toString() : "");
			captainData.setBloodgroup(null != row[26] ? row[26].toString() : "");
			captainData.setIdentitytype(null != row[28] ? row[28].toString() : "");
			captainData.setIdentitynumber(null != row[27] ? row[27].toString() : "");

			
			break;
		}
		
		return captainData;
	
	}
	
	public static List<Participant> getParticipantsData(int captainID, Session session, Transaction transaction){

		SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID IN (SELECT PART_ID FROM TEAM_PARTI WHERE TEAM_ID IN (SELECT TEAM_ID FROM TEAM WHERE CAPTAIN_PART_ID = "+captainID+"))");
		List<Object[]> dataList = query.list();
		
		List<Participant> participantDataList = new ArrayList<>();
		
		for(Object[] row : dataList ){
			
			Participant participant = new Participant();
			
			participant.setPartid(null != row[0] ? Integer.parseInt(row[0].toString()) : -1);
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
			participant.setPincode(null != row[11] ? row[11].toString() : "");
			participant.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
			participant.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
			participant.setSchoolstate(null != row[14] ? row[14].toString() : "");
			participant.setSchoolcity(null != row[15] ? row[15].toString() : "");
			participant.setSchoolpincode(null != row[16] ? row[16].toString() : "");
			participant.setGender(null != row[17] ? row[17].toString() : "");
			participant.setContactno(null != row[18] ? row[18].toString() : "");
			participant.setAlternativeno(null != row[19] ? row[19].toString() : "");
			participant.setEmail(null != row[20] ? row[20].toString() : "");
			participant.setBloodgroup(null != row[26] ? row[26].toString() : "");
			participant.setIdentitytype(null != row[28] ? row[28].toString() : "");
			participant.setIdentitynumber(null != row[27] ? row[27].toString() : "");

			participantDataList.add(participant);
			participant = null;
		}
		
		return participantDataList;
	}
	
	
	
	public static int getTeamID(int captainID, Session session, Transaction transaction){
		SQLQuery query = session.createSQLQuery("SELECT * FROM TEAM WHERE CAPTAIN_PART_ID = "+captainID+"");
		List<Object[]> dataList = query.list();	
		Team team = new Team();		
		for(Object[] row : dataList ){
			team.setTeamId(Integer.parseInt(row[0].toString()));		
			break;
		}
		return team.getTeamId();
	
	}
	
	
	public static Map<String, Object> getPayment(int teamId, int captainId, int amount, String user, String payMode, String refNumber){
		
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		SQLQuery query2 = session.createSQLQuery("SELECT PAY_FLAG FROM PAY_REP_DTLS WHERE PART_TEAM_ID = "+teamId+"");
		List<Object> dataList = query2.list();
		String payFlag = null;
		
		for(Object row : dataList){
			payFlag = null != row ? row.toString() : "N";
			break;
		}
	
		
		if (null != payFlag && !payFlag.equals("Y")) {
			ReceiptMaster master = getReceipt(session, teamId);
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET PAY_FLAG= :PAYFLAG, PAY_USR = :PAYUSR, PAY_AMT = :PAYAMT, PAY_DT = :PAYDT, RECEIPT_NBR = :RCTNBR, PAYMENT_MODE =:PAYMODE ,REF_NUMBER= :REFNO WHERE PART_TEAM_ID  = :TEAMID");
			query1.setParameter("PAYFLAG", "Y");
			query1.setParameter("TEAMID", teamId);
			query1.setParameter("PAYDT", CommonUtilities.getDate());
			query1.setParameter("RCTNBR", master.getReceiptNbr());
			query1.setParameter("PAYUSR", user);
			query1.setParameter("PAYAMT", amount);
			query1.setParameter("PAYMODE", payMode);
			query1.setParameter("REFNO", refNumber);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInserted = true;
			}
			data.put("success", isInserted);
			data.put("captainId", captainId);
			data.put("receiptnumber", master.getReceiptNbr());
			data.put("message", "Payment Done Successfully");
			
		}else if(payFlag == null){
			data.put("success", isInserted);
			data.put("receiptnumber", "");
			data.put("message", "Captain ID does not exist");
			data.put("captainId", captainId);
		}
		else {
			data.put("success", isInserted);
			data.put("receiptnumber", "");
			data.put("message", "Payment Already Done");
			data.put("captainId", captainId);
		}
		tx.commit();
		session.close();
		return data;
		
	}

	public static ReceiptMaster getReceipt(Session session, int teamID){
		session.clear();
		
		String sql = "From ReceiptMaster as receiptMaster where receiptMaster.assignedFlg = 'N'";
		Query query = session.createQuery(sql);
		query.setMaxResults(1);
		List<ReceiptMaster> master = query.list();
		
		ReceiptMaster data = (ReceiptMaster)master.get(0);
		
		Query query1 = session.createSQLQuery("UPDATE RECEIPT_MASTER SET ASSIGNED_FLG= :FLAG, ASSIGNED_PART_ID= :PID WHERE RECEIPT_NBR  = :RCTNO")
		.setParameter("FLAG", 'Y')
		.setParameter("PID", teamID)
		.setParameter("RCTNO", data.getReceiptNbr());
		
		query1.executeUpdate();
		return data;
	}

}
