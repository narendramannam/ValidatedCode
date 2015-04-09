package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.*;

import com.tesco.retail.domain.entites.Feedback;

public class FeedbackDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public void insertFeedback(Feedback feedback){
		
		tx.begin();
		em.merge(feedback);
		tx.commit();
	}
	public List<Object[]> getfeedbackbyemail(String email){
		tx.begin();
		String hql = "select feedbackinfo from feedback where email='pooja@gmail.com'";
		Query query = em.createNativeQuery(hql);
		List<Object[]>finfo = query.getResultList();

		return finfo;
		
	}
}
