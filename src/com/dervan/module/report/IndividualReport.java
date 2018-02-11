package com.dervan.module.report;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.util.dao.HibernateUtil;
import com.dervan.module.utils.CommonUtilities;

public class IndividualReport {

	public static Map<String, Object> changeReportStatusIndividual(Session session, Transaction tx, int partID){
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
		query1.setParameter("RPTFLG","Y");
		query1.setParameter("RPTDT", CommonUtilities.getDate());
		query1.setParameter("RPTUSR", CommonUtilities.getUsername());
		query1.setParameter("PARTID", partID);
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("captainID", partID);
		
		tx.commit();
		session.close();
		return data;
	}

}
