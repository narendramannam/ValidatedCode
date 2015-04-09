package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClearanceSaleProductDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public List<Object[]> getproductCustnamebyname(String email){
		tx.begin();
		String hql2 = "select productname , customername from customer c, cart ca,cartitem ci,product p where c.customerid=ca.customerid and ca.cartid=ci.cartid and ci.productid=p.productid and c.email='"+email+"'";
		Query q2=em.createNativeQuery(hql2);
		return q2.getResultList();
		
		
	}

}
