package com.tesco.retail.dao.implementation;

import javax.persistence.*;

import com.tesco.retail.domain.entites.Shipping;

public class ShippingDAO {
	public void insertShipping(Shipping shipping){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(shipping);
		tx.commit();
	}
}
