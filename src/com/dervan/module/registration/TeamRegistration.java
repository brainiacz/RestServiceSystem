package com.dervan.module.registration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Participant;
import com.dervan.module.model.dao.PayRepDtl;
import com.dervan.module.model.dao.ReceiptMaster;
import com.dervan.module.model.dao.Team;
import com.dervan.module.model.dao.TeamGame;
import com.dervan.module.model.dao.TeamParti;
import com.dervan.module.model.dao.TeamRecordInner;
import com.dervan.module.util.dao.HibernateUtil;
import com.dervan.module.utils.CommonUtilities;

public class TeamRegistration {

	
	public static String getRegistered(TeamRecordInner record){
		
		// Initialization of Session Factory
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		// Get Captain from JSON 
		Participant captain = record.getPartidetails();
		session.save(captain);
		session.flush();
		int captainID = captain.getPartid();
		
		// Get Participants from json
		List<Participant> participantList = record.getTm();
		
		// Get Amount from json
		int amount = record.getAmt();
		
		// Get Team data from json
		Team teamData = getTeamGameData(record);
		//Set CaptainID to team entity
		teamData.setCaptainPartId(captainID);
		session.save(teamData);
		session.flush();
		int teamId = teamData.getTeamId();
		
		
		// Insert number of participants and collects the Part ID 
		List<Integer> listOfPID = new ArrayList<>();
		
		for(Participant participant : participantList){
			session.save(participant);
			session.flush();
			listOfPID.add(participant.getPartid());
		}
		
		// Insert the partID with respect to team ID
		for(Integer data : listOfPID){
			TeamParti teamParti = new TeamParti();
			teamParti.setPartId(data);
			teamParti.setTeamId(teamId);
			teamParti.setInsertDateTime(CommonUtilities.getDate());
			teamParti.setUpdateDateTime(CommonUtilities.getDate());
			teamParti.setInsertUserName(CommonUtilities.getUsername());
			teamParti.setUpdateUserName(CommonUtilities.getUsername());

			session.save(teamParti);
			teamParti = null;
		}
		
		
		
		// Get game details and insert them 
		List<TeamGame> teamGame = getTeamGameDtls(record, teamId);
		for(TeamGame partiGameData : teamGame){
			session.save(partiGameData);
		}
		
		// Get the receipt number and update its flag to Y
		//ReceiptMaster master = getReceipt(session, teamId);
		PayRepDtl dtls = getPaymentDtls(session, amount, teamId);
		session.save(dtls);
		
		
		tx.commit();
		session.close();	
		
		return String.valueOf(captainID);
	}
	
	public static PayRepDtl getPaymentDtls(Session session, int amount, int partId){
		session.clear();
		PayRepDtl details = null;
		
	
			details = new PayRepDtl();
			details.setPayAmt(amount);
			details.setPartTeamId(partId);
			//details.setReceiptNbr(master.getReceiptNbr());
			details.setPayFlag("N");
			details.setKycCheck("N");
			details.setReportedFlg("N");
		

		return details;
		
	
	}
	
	
	public static List<TeamGame> getTeamGameDtls(TeamRecordInner record, int teamId){
		
		List<TeamGame> teamGame = new ArrayList<>();
		List<TeamGame> games = record.getGames();
		
		for(TeamGame game : games){
			TeamGame teamGameTemp = new TeamGame();
			teamGameTemp.setTeamId(teamId);
			teamGameTemp.setEventid(game.getEventid());
			teamGameTemp.setInsertDateTime(CommonUtilities.getDate());
			teamGameTemp.setUpdateDateTime(CommonUtilities.getDate());
			teamGameTemp.setInsertUserName(CommonUtilities.getUsername());
			teamGameTemp.setUpdateUserName(CommonUtilities.getUsername());
			teamGame.add(teamGameTemp);
			teamGameTemp = null;
		}
		
		return teamGame;

	}
	
	/*
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
*/
	
	public static Team getTeamGameData(TeamRecordInner record){
		Team data = new Team();
		data.setTeamSchool(record.getPartidetails().getNameOfSchoolOrClub());
		data.setTeamName(record.getPartidetails().getNameOfSchoolOrClub());
		data.setTeamSchoolAdd1(record.getPartidetails().getAddressOfSchoolOrClub());
		data.setTeamSchoolAdd2(record.getPartidetails().getAddress2OfSchoolOrClub());
		data.setTeamSchoolCity(record.getPartidetails().getSchoolcity());
		data.setTeamSchoolPincode(record.getPartidetails().getSchoolpincode());
		data.setTeamSchoolState(record.getPartidetails().getSchoolstate());
		data.setInsertDateTime(CommonUtilities.getDate());
		data.setUpdateDateTime(CommonUtilities.getDate());
		data.setInsertUserName(CommonUtilities.getUsername());
		data.setUpdateUserName(CommonUtilities.getUsername());

		return data;
	}

}
