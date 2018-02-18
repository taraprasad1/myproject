package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.models.UserDetails;

@Repository("dao")
public class DaoImpl implements Dao{
	 private SessionFactory sessionFactory;
 @Autowired
 @Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	 
	public String save(List list) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		int i=0;
		while(list.size()>i)
		{
			UserDetails u=(UserDetails)list.get(i);
			System.out.println(u.getFname()+" "+u.getMname()+" "+u.getLname());
		
		session.save(u);
		
		i++;
		}
		tx.commit();
		session.close();
		
		return "done";
	}

}
