package com.dervan.module.payment;

import java.util.ArrayList;
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
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.util.dao.HibernateUtil;

public class TeamPayment {
	

	
	
	public static Team getTeamData(int teamId, Session session, Transaction transaction){
		
	
		SQLQuery query = session.createSQLQuery("SELECT * from Team where team_id = "+teamId+"");
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
			
			break;
		}
		
		return team;
	}
	
	public static PayRepDtl getPaymentDetails(int teamId, Session session, Transaction transaction){
		
		SQLQuery query2 = session.createSQLQuery("SELECT * from Pay_Rep_Dtls where part_team_id = "+teamId+"");
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
	
	public static List<TeamGame> getTeamGameData(int teamId, Session session, Transaction transaction){
		
		SQLQuery query1 = session.createSQLQuery("SELECT * from Team_game where team_id = "+teamId+"");
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
	
	
	public static Map<String, Object> getPayment(int teamId){
		
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query1 = session.createSQLQuery("UPDATE pay_rep_dtls SET PAY_FLAG= :PAYFLAG , REPORTED_FLG = :REPOFLAG WHERE PART_TEAM_ID  = :TEAMID");
		query1.setParameter("PAYFLAG","Y");
		query1.setParameter("REPOFLAG","Y");
		query1.setParameter("TEAMID", teamId);
		
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

}
