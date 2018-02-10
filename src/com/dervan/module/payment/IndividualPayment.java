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

import com.dervan.module.model.dao.PartiGame;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.util.dao.HibernateUtil;

public class IndividualPayment {
	
	
	public static Participant getParticipant(int partId, Session session, Transaction transaction){
		
		SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID = "+partId+"");
		List<Object[]> dataList = query.list();
		
		Participant participant = new Participant();
		
		for(Object[] row : dataList ){
			participant.setPartId(null != row[0] ? Integer.parseInt(row[0].toString()) : -1);
			participant.setFirstname(null != row[1] ? row[1].toString() : "");
			participant.setMiddlename(null != row[2] ? row[2].toString() : "");
			participant.setLastname(null != row[3] ? row[3].toString() : "");
			participant.setDob(null != row[4] ? row[4].toString() : "");
			participant.setAge(null != row[5] ? Integer.parseInt(row[5].toString()) : -1);
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
			
			break;
		}
		
		return participant;
	}
	
	public static PayRepDtl getPaymentDetails(int partId, Session session, Transaction transaction){
		
		SQLQuery query2 = session.createSQLQuery("SELECT * FROM PAY_REP_DTLS WHERE PART_TEAM_ID = "+partId+"");
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
	
	public static List<PartiGame> getPartiGameData(int partId, Session session, Transaction transaction){
		
		SQLQuery query1 = session.createSQLQuery("SELECT * FROM PARTI_GAME WHERE PART_ID = "+partId+"");
		List<Object[]> dataList = query1.list();
		
		List<PartiGame> partiGameData  = new ArrayList<>();
		
		
		for(Object[] row : dataList){
			PartiGame game = new PartiGame();
			game.setPartiGameId(Integer.valueOf(row[0].toString()));
			game.setPartId(Integer.valueOf(row[1].toString()));
			game.setGameId(Integer.valueOf(row[2].toString()));
			partiGameData.add(game);
		}
		
		return partiGameData;
	}
	
	
	public static Map<String, Object> getPayment(int partid){
		
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET PAY_FLAG= :PAYFLAG , REPORTED_FLG = :REPOFLAG, PAY_DT = :PAYDT WHERE PART_TEAM_ID  = :PARTID");
		query1.setParameter("PAYFLAG","Y");
		query1.setParameter("REPOFLAG","Y");
		query1.setParameter("PARTID", partid);
		query1.setParameter("PAYDT", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("partID", partid);
		
		tx.commit();
		session.close();
		return data;
		
	}
}
 