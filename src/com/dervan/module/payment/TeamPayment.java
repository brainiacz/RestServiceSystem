package com.dervan.module.payment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.ReceiptMaster;
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.util.dao.HibernateUtil;

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
			team.setTeamSchoolPincode(Integer.parseInt(row[7].toString()));
			team.setCaptainPartId(Integer.parseInt(row[12].toString()));
			
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
			break;
		}
		
		return dtls;
	}
	
	public static List<TeamGame> getTeamGameData(int captainID, Session session, Transaction transaction){
		
		SQLQuery query1 = session.createSQLQuery("SELECT * FROM TEAM_GAME WHERE TEAM_ID IN (SELECT TEAM_ID FROM TEAM WHERE CAPTAIN_PART_ID ="+ captainID+")");
		List<Object[]> dataList = query1.list();
		
		List<TeamGame> teamGameData  = new ArrayList<>();
		
		
		for(Object[] row : dataList){
			TeamGame game = new TeamGame();
			game.setTeamGameId(Integer.parseInt(row[0].toString()));
			game.setTeamId(Integer.parseInt(row[1].toString()));
			game.setGameId(Integer.parseInt(row[2].toString()));
			teamGameData.add(game);
		}
		
		return teamGameData;
	}
	
	
	public static Participant getCaptainData(int captainID, Session session, Transaction transaction){

		SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID = "+captainID+"");
		List<Object[]> dataList = query.list();
		
		Participant captainData = new Participant();
		
		for(Object[] row : dataList ){
			captainData.setPartId(null != row[0] ? Integer.parseInt(row[0].toString()) : -1);
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
			captainData.setPincode(null != row[11] ? Integer.parseInt(row[11].toString()) : -1);
			captainData.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
			captainData.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
			captainData.setSchoolstate(null != row[14] ? row[14].toString() : "");
			captainData.setSchoolcity(null != row[15] ? row[15].toString() : "");
			captainData.setSchoolpincode(null != row[16] ? Integer.parseInt(row[16].toString()) : -1);
			captainData.setGender(null != row[17] ? row[17].toString() : "");
			captainData.setContactno(null != row[18] ? row[18].toString() : "");
			captainData.setAlternativeno(null != row[19] ? row[19].toString() : "");
			captainData.setEmail(null != row[20] ? row[20].toString() : "");
			captainData.setBloodgroup(null != row[21] ? row[21].toString() : "");
			captainData.setIdentitytype(null != row[22] ? row[22].toString() : "");
			captainData.setIdentitynumber(null != row[23] ? row[23].toString() : "");

			
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
			
			participant.setPartId(null != row[0] ? Integer.parseInt(row[0].toString()) : -1);
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
			participant.setPincode(null != row[11] ? Integer.parseInt(row[11].toString()) : -1);
			participant.setAddressOfSchoolOrClub(null != row[12] ? row[12].toString() : "");
			participant.setAddress2OfSchoolOrClub(null != row[13] ? row[13].toString() : "");
			participant.setSchoolstate(null != row[14] ? row[14].toString() : "");
			participant.setSchoolcity(null != row[15] ? row[15].toString() : "");
			participant.setSchoolpincode(null != row[16] ? Integer.parseInt(row[16].toString()) : -1);
			participant.setGender(null != row[17] ? row[17].toString() : "");
			participant.setContactno(null != row[18] ? row[18].toString() : "");
			participant.setAlternativeno(null != row[19] ? row[19].toString() : "");
			participant.setEmail(null != row[20] ? row[20].toString() : "");
			participant.setBloodgroup(null != row[21] ? row[21].toString() : "");
			participant.setIdentitytype(null != row[22] ? row[22].toString() : "");
			participant.setIdentitynumber(null != row[23] ? row[23].toString() : "");

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
	
	
	public static Map<String, Object> getPayment(int teamId){
		
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ReceiptMaster master = getReceipt(session, teamId);
		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET PAY_FLAG= :PAYFLAG , REPORTED_FLG = :REPOFLAG, PAY_DT = :PAYDT, RECEIPT_NBR: RCTNBR WHERE PART_TEAM_ID  = :TEAMID");
		query1.setParameter("PAYFLAG","Y");
		query1.setParameter("REPOFLAG","Y");
		query1.setParameter("TEAMID", teamId);
		query1.setParameter("PAYDT", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		query1.setParameter("RCTNBR", master.getReceiptNbr());
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("TeamId", teamId);
		
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
