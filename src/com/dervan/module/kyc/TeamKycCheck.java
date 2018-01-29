package com.dervan.module.kyc;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.util.dao.HibernateUtil;

public class TeamKycCheck {
	
	public static Map<String, Object> getKycCheckTeam(int teamID){
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();

		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET KYC_CHECK= :KYCCHECK  WHERE PART_TEAM_ID  = :TEAMID");
		query1.setParameter("KYCCHECK","Y");
		query1.setParameter("TEAMID", teamID);
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("TeamID", teamID);
		
		tx.commit();
		session.close();
		return data;
	
	}
}
