package com.tesco.retail.dao.implementation;

import javax.persistence.*;

import com.tesco.retail.domain.entites.ProductStatus;

public class ProductStatusDAO {
	public void insertStatus(ProductStatus status){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(status);
		tx.commit();
	}
}
