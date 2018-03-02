package com.dervan.module.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.PartiGame;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.util.dao.HibernateUtil;

public class BulkUpdate {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String line  = "";
		
		while((line = reader.readLine()) != null){
			
			String[] arr = line.split("\\|");
			
			Participant participant = new Participant();
			String sno = arr[0];
			participant.setMiddlename(null != arr[1] ? arr[1] : "");
			participant.setFirstname(null != arr[2] ? arr[3] : "");
			participant.setLastname(null != arr[3] ? arr[3] : "");
			participant.setDob(null != arr[4] ? arr[4] : "");
			participant.setNameOfSchoolOrClub(null != arr[5] ? arr[5] : "");
			participant.setCity(null != arr[6] ? arr[6] : "");
			participant.setPincode(null != arr[7] ? arr[7] : "");
			participant.setGender(null != arr[8] ? arr[8] : "");
			participant.setAge(null != arr[9] ? arr[9] : "");
			participant.setContactno(null != arr[10] ? arr[10] : "");
			participant.setAlternativeno(null != arr[11] ? arr[11] : "");
			participant.setIdentitynumber(null != arr[12] ? arr[12] : "");
			participant.setIdentitytype(null != arr[13] ? arr[13] : "");
			
			session.save(participant);
			session.flush();
			int partId = participant.getPartid();
 
			PartiGame game = new PartiGame();
			
			game.setPartId(partId);
			game.setGameId(null != arr[14] ? Integer.parseInt(arr[14].toString()) : 0);
			game.setInsertUserName(CommonUtilities.getUsername());
			game.setUpdateUserName(CommonUtilities.getUsername());
			game.setInsertDateTime(CommonUtilities.getDate());
			game.setUpdateDateTime(CommonUtilities.getDate());
			session.save(game);
			PayRepDtl payRepDtls = getPaymentDtls(session, partId);
			session.save(payRepDtls);
			tx.commit();
			session.close();
			
			System.out.println(sno + "|" + partId);
		}
	}
	
	
	public static PayRepDtl getPaymentDtls(Session session,  int partId){
		session.clear();
		PayRepDtl details = null;
			details = new PayRepDtl();
			//details.setPayAmt(amount);
			details.setPartTeamId(partId);
			//details.setReceiptNbr(master.getReceiptNbr());
			details.setPayFlag("N");
			details.setKycCheck("N");
			details.setReportedFlg("N");
		return details;
	}
}
