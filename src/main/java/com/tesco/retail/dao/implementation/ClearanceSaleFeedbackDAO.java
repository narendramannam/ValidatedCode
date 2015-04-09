package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClearanceSaleFeedbackDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	
	public List<Object[]> getCustomerByEmail(String email)
    {
		tx.begin();
		String sql="select p.productName,c.customerName,f.feedbackInfo from " +
				"   Customer c join on cart ct(c.customerId=ct.customerId)join on CartItem ci(ci.cartId=ct.cartId) join on product(ci.productId=p.productId) join on shipping s(s.customerId=c.customerId) join on productstatus ps(ps.productstatusId=s.statusId)  where c.email='"+email+"'";
		Query query=em.createNativeQuery(sql);
		return query.getResultList();
       
        
        
    }

}
