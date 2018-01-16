package com.dervan.module.Login;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dervan.module.model.dao.Member;
import com.dervan.module.util.dao.HibernateUtil;

public class LoginController {
	
	public static Member getAutheticated(Member member){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String uname = member.getUname();
		String password = member.getPass();
		String sqlQuery = "FROM Member members where members.uname ='" +uname +"' AND members.pass = '"+ password+"'";
		Query query = (Query) session.createQuery(sqlQuery);
		Iterator itr = query.iterate();
		
		while(itr.hasNext()){
			Member mem = (Member)itr.next();
			member.setEmail(mem.getEmail());
			member.setFirstName(mem.getFirstName());
			member.setLastName(mem.getLastName());
			member.setRole(mem.getRole());
		}
		
		tx.commit();
		session.close();
		return member;
	}

}
