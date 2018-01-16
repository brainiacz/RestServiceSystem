package com.dervan.module.registration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.dervan.module.model.dao.Game;
import com.dervan.module.model.dao.PartiGame;
import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.ReceiptMaster;
import com.dervan.module.model.dao.Record;
import com.dervan.module.util.dao.HibernateUtil;

public class IndividualRegistration {
	
	public static String getRegistered(Record record){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Participant participant = record.getParticipant();
		int amount = Integer.parseInt(record.getAmount());
		
		session.save(participant);
		session.flush();
		int partId = participant.getPartId();
		
		
		List<PartiGame> partiGame = getPartiGameDtls(record, partId);
		for(PartiGame data : partiGame){
			session.save(data);
		}
		
		
		ReceiptMaster master = getReceipt(session, partId);
		PayRepDtl dtls = getPaymentDtls(session, master, amount, partId);
		session.save(dtls);
		
		
		tx.commit();
		session.close();	
		
		return String.valueOf(partId);
	}
	
	public static PayRepDtl getPaymentDtls(Session session, ReceiptMaster master, int amount, int partId){
		session.clear();
		PayRepDtl details = null;
		
		if(master != null){
			details = new PayRepDtl();
			details.setPayAmt(amount);
			details.setPartTeamId(partId);
			details.setReceiptNbr(master.getReceiptNbr());
		}
		
		return details;
		
	
	}
	
	
	public static List<PartiGame> getPartiGameDtls(Record record, int partId){
		
		List<PartiGame> partiGame = new ArrayList<>();
		List<Game> games = record.getGames();
		
		for(Game game : games){
			PartiGame partiGameTemp = new PartiGame();
			partiGameTemp.setPartId(partId);
			partiGameTemp.setPartiGameId(game.getGameId());
			partiGameTemp.setGameId(game.getGameId());
			partiGame.add(partiGameTemp);
			partiGameTemp = null;
		}
		
		return partiGame;

	}
	
	
	public static ReceiptMaster getReceipt(Session session, int partID){
		session.clear();
		
		String sql = "From ReceiptMaster as receiptMaster where receiptMaster.assignedFlg = 'N'";
		Query query = session.createQuery(sql);
		query.setMaxResults(1);
		List<ReceiptMaster> master = query.list();
		
		ReceiptMaster data = (ReceiptMaster)master.get(0);
		
		Query query1 = session.createSQLQuery("UPDATE RECEIPT_MASTER SET ASSIGNED_FLG= :FLAG, ASSIGNED_PART_ID= :PID WHERE RECEIPT_NBR  = :RCTNO")
		.setParameter("FLAG", 'Y')
		.setParameter("PID", partID)
		.setParameter("RCTNO", data.getReceiptNbr());
		
		query1.executeUpdate();
		return data;
	}

	
}
