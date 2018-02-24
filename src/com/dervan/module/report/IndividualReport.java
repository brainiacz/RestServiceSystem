package com.dervan.module.report;

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
import com.dervan.module.util.dao.HibernateUtil;
import com.dervan.module.utils.CommonUtilities;

public class IndividualReport {

	public static Participant getParticipant(int partId, Session session, Transaction transaction) {

		SQLQuery query = session.createSQLQuery("SELECT * FROM PARTICIPANT WHERE PART_ID = " + partId + "");
		List<Object[]> dataList = query.list();

		Participant participant = new Participant();

		for (Object[] row : dataList) {
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
			participant.setBloodgroup(null != row[21] ? row[21].toString() : "");
			participant.setIdentitytype(null != row[22] ? row[22].toString() : "");
			participant.setIdentitynumber(null != row[23] ? row[23].toString() : "");

			break;
		}

		return participant;
	}

	public static List<EventData> getPartiGameData(int partId, Session session, Transaction transaction) {

		SQLQuery query1 = session.createSQLQuery(
				"SELECT GAME_ID, DISCIPLINE, AGE_GRP, CATEGORY, EVENT FROM SPORT_DATABASE.GAME WHERE GAME_ID IN (SELECT GAME_ID FROM PARTI_GAME WHERE PART_ID = "
						+ partId + ")");

		List<Object[]> dataList = query1.list();

		List<EventData> partiGameData = new ArrayList<>();
		for (Object[] row : dataList) {
			EventData data = new EventData();
			data.setEventid(null != row[0] ? row[0].toString() : "");
			data.setName(null != row[1] ? row[1].toString() : "");
			data.setMinage(null != row[2] ? row[2].toString().replace("U", "") : "");
			data.setText(null != row[4] ? row[4].toString() : "");

			partiGameData.add(data);
			data = null;
		}

		return partiGameData;
	}

	public static Map<String, Object> getPayment(int partid, int amt, String user) {

		boolean isInserted = false;
		Map<String, Object> data = new HashMap<>();

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		SQLQuery query2 = session
				.createSQLQuery("SELECT PAY_FLAG FROM PAY_REP_DTLS WHERE PART_TEAM_ID = " + partid + "");
		List<Object> dataList = query2.list();
		String payFlag = null;

		for (Object row : dataList) {
			payFlag = null != row ? row.toString() : "N";
			break;
		}

		if (null != payFlag && !payFlag.equals("Y")) {
			ReceiptMaster master = getReceipt(session, partid);
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET PAY_AMT = :PAYAMT, PAY_FLAG= :PAYFLAG , PAY_DT = :PAYDT, PAY_USR = :PAYUSR, RECEIPT_NBR = :RCTNBR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("PAYFLAG", "Y");
			query1.setParameter("PAYAMT", amt);
			query1.setParameter("PARTID", partid);
			query1.setParameter("PAYDT", CommonUtilities.getDate());
			query1.setParameter("RCTNBR", master.getReceiptNbr());
			query1.setParameter("PAYUSR", user);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInserted = true;
			}
			data.put("success", isInserted);
			data.put("receiptnumber", master.getReceiptNbr());
			data.put("message", "Payment Done Successfully");
			data.put("partID", partid);
		} else if (payFlag == null) {
			data.put("success", isInserted);
			data.put("receiptnumber", "");
			data.put("message", "Participant ID does not exist");
			data.put("partID", partid);
		} else {

			data.put("success", isInserted);
			data.put("receiptnumber", "");
			data.put("message", "Payment Already Done");
			data.put("partID", partid);
		}
		tx.commit();
		session.close();
		return data;

	}

	public static ReceiptMaster getReceipt(Session session, int partID) {
		session.clear();

		String sql = "From ReceiptMaster as receiptMaster where receiptMaster.assignedFlg = 'N'";
		Query query = session.createQuery(sql);
		query.setMaxResults(1);
		List<ReceiptMaster> master = query.list();

		ReceiptMaster data = (ReceiptMaster) master.get(0);

		Query query1 = session
				.createSQLQuery(
						"UPDATE RECEIPT_MASTER SET ASSIGNED_FLG= :FLAG, ASSIGNED_PART_ID= :PID WHERE RECEIPT_NBR  = :RCTNO")
				.setParameter("FLAG", 'Y').setParameter("PID", partID).setParameter("RCTNO", data.getReceiptNbr());

		query1.executeUpdate();
		return data;
	}

	public static Map<String, Object> changeReportStatusIndividual(Session session, Transaction tx, int partID,
			String reportedFlag, String KYCflag) {
		boolean isInsertedReportedFlag = false;
		boolean isInsertedKycFlag = false;
		Map<String, Object> data = new HashMap<>();

		SQLQuery query2 = session
				.createSQLQuery("SELECT REPORTED_FLG, KYC_CHECK FROM PAY_REP_DTLS WHERE PART_TEAM_ID = " + partID + "");
		List<Object[]> dataList = query2.list();
		String repFlag = null;
		String kycFlag = null;

		for (Object[] row : dataList) {
			repFlag = null != row[0] ? row[0].toString() : "N";
			kycFlag = null != row[1] ? row[1].toString() : "N";
			break;
		}


		if (!repFlag.equals("Y") && !kycFlag.equals("Y") && reportedFlag.equals("Y") && KYCflag.equals("Y")) {
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("RPTFLG", reportedFlag);
			query1.setParameter("RPTDT", CommonUtilities.getDate());
			query1.setParameter("RPTUSR", CommonUtilities.getUsername());
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();

			Query query3 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  KYC_CHECK = :KYC WHERE PART_TEAM_ID  = :PARTID");
			query3.setParameter("KYC", KYCflag);
			query3.setParameter("PARTID", partID);
			int result1 = query3.executeUpdate();
			if (result > 0 && reportedFlag.equals("Y")) {
				isInsertedReportedFlag = true;
			}
			
			if(result1 > 0 && KYCflag.equals("Y")){
				isInsertedKycFlag = true;
			}
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "Changes done successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		} else if (!repFlag.equals("N") && !kycFlag.equals("N") && reportedFlag.equals("N") && KYCflag.equals("N")) {
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("RPTFLG", reportedFlag);
			query1.setParameter("RPTDT", CommonUtilities.getDate());
			query1.setParameter("RPTUSR", CommonUtilities.getUsername());
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();

			Query query3 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  KYC_CHECK = :KYC WHERE PART_TEAM_ID  = :PARTID");
			query3.setParameter("KYC", KYCflag);
			query3.setParameter("PARTID", partID);
			int result1 = query3.executeUpdate();
			if (result > 0 && reportedFlag.equals("Y")) {
				isInsertedReportedFlag = true;
			}
			
			if(result1 > 0 && KYCflag.equals("Y")){
				isInsertedKycFlag = true;
			}
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "Changes done successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		}else if (!repFlag.equals("Y") && reportedFlag.equals("Y")) {
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("RPTFLG", reportedFlag);
			query1.setParameter("RPTDT", CommonUtilities.getDate());
			query1.setParameter("RPTUSR", CommonUtilities.getUsername());
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedReportedFlag = true;
			}
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "Reported Flag changed successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		} else if (!kycFlag.equals("Y") && reportedFlag.equals("Y")) {
			Query query1 = session
					.createSQLQuery("UPDATE PAY_REP_DTLS SET  KYC_CHECK = :KYC WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("KYC", KYCflag);
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedKycFlag = true;
			}
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "KYC Check done successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		}else if (!repFlag.equals("N") && reportedFlag.equals("N")) {
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("RPTFLG", reportedFlag);
			query1.setParameter("RPTDT", CommonUtilities.getDate());
			query1.setParameter("RPTUSR", CommonUtilities.getUsername());
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedReportedFlag = true;
			}
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "Reported Flag changed successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		} else if (!kycFlag.equals("N") && KYCflag.equals("N")) {
			Query query1 = session
					.createSQLQuery("UPDATE PAY_REP_DTLS SET  KYC_CHECK = :KYC WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("KYC", KYCflag);
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedKycFlag = true;
			}
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "KYC Check done successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		}else if (repFlag.equals("N") && reportedFlag.equals("Y")) {
			Query query1 = session.createSQLQuery(
					"UPDATE PAY_REP_DTLS SET  REPORTED_FLG = :RPTFLG, REPORTED_DT = :RPTDT, REPORT_USR = :RPTUSR WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("RPTFLG", reportedFlag);
			query1.setParameter("RPTDT", CommonUtilities.getDate());
			query1.setParameter("RPTUSR", CommonUtilities.getUsername());
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedReportedFlag = true;
			}
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "Reported Flag changed successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		} else if (kycFlag.equals("N") && KYCflag.equals("Y")) {
			Query query1 = session
					.createSQLQuery("UPDATE PAY_REP_DTLS SET  KYC_CHECK = :KYC WHERE PART_TEAM_ID  = :PARTID");
			query1.setParameter("KYC", KYCflag);
			query1.setParameter("PARTID", partID);
			int result = query1.executeUpdate();
			if (result > 0) {
				isInsertedKycFlag = true;
			}
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "KYC Check done successfully");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;

		}
		
		
		if (kycFlag.equals("Y") && repFlag.equals("Y") && KYCflag.equals("Y") && reportedFlag.equals("Y")) {
			data.put("kycStatus", isInsertedKycFlag);
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "KYC Check and Reporting already done");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;
		} else if (kycFlag.equals("N") && repFlag.equals("N") && KYCflag.equals("N") && reportedFlag.equals("N")) {
			data.put("kycStatus", isInsertedKycFlag);
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "KYC Check and Reporting remain unchanged");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;
		}else if (repFlag.equals("Y") && reportedFlag.equals("Y")) {
			data.put("reportingStatus", isInsertedReportedFlag);
			data.put("message", "Reporting already done");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;
		} else if (kycFlag.equals("Y") && KYCflag.equals("Y")) {
			data.put("kycStatus", isInsertedKycFlag);
			data.put("message", "KYC Check already done");
			data.put("partid", partID);
			tx.commit();
			session.close();
			return data;
		}

		tx.commit();
		session.close();

		return data;
	}

}
