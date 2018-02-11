package com.dervan.module.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.Team;
import com.dervan.module.payment.TeamPayment;
import com.dervan.module.util.dao.HibernateUtil;
import com.dervan.module.utils.CommonUtilities;

public class TeamReport {

	public static Map<String, Object> getDetails(Session session, Transaction tx, int teamID){
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		SQLQuery query = session.createSQLQuery("SELECT * FROM PAY_REP_DTLS WHERE PART_TEAM_ID = "+teamID+"");
		List<Object[]> dataList = query.list();
		
		PayRepDtl dtls = new PayRepDtl();
		for(Object[] row : dataList ){
			dtls.setReportedFlg(null != row[8] ? row[8].toString() : "");
			break;
		}
		data.put("reportedflag", dtls.getReportedFlg());
		return data;
	}
	public static Map<String, Object> changeTeamReportStatus(Session session, Transaction tx, int captainID){
		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();
		Team teamData = TeamPayment.getTeamData(captainID, session, tx);
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		Query query1 = session.createSQLQuery("UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :TEAMID");
		query1.setParameter("RPTFLG","Y");
		query1.setParameter("RPTDT", CommonUtilities.getDate());
		query1.setParameter("RPTUSR", CommonUtilities.getUsername());
		query1.setParameter("TEAMID", teamData.getTeamId());
		int result = query1.executeUpdate();
		
		if(result > 0){
			isInserted = true;
		}
		
		data.put("success", isInserted);
		data.put("captainID", captainID);
		
		tx.commit();
		session.close();
		return data;
	}
}
