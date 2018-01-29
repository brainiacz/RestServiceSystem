package com.dervan.module.kyc;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IndividualKycCheck {

	public static Map<String, Object> getKycCheck(int partID, Session session, Transaction tx){
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();

		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET KYC_CHECK= :KYCCHECK  WHERE PART_TEAM_ID  = :PARTID");
		query1.setParameter("KYCCHECK","Y");
		query1.setParameter("PARTID", partID);
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("PartID", partID);
		
		tx.commit();
		session.close();
		return data;
	}
}
