package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.*;

import com.tesco.retail.domain.entites.ClearanceSale;
import com.tesco.retail.domain.entites.Product;

public class ClearanceSaleDAO {
	//Creating Entity for Persisting the object into DB
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	//Method to insert sale details
	public void insertClearancesale(ClearanceSale clearancesale){
		
		tx.begin();
		em.persist(clearancesale);
		tx.commit();
	}
	//Method to Remove Sale
	public void removeClearanceSale(int id)
	{		
		ClearanceSale clearancesale = em.find(ClearanceSale.class, id);
		em.getTransaction().begin();
		em.remove(clearancesale);
		em.getTransaction().commit();
	}
	public List<ClearanceSale> getsale(){
		tx.begin();
		TypedQuery<ClearanceSale> query=em.createNamedQuery("ClearanceSale.findAll",ClearanceSale.class);
		List<ClearanceSale> clearancesale=query.getResultList();
		 tx.commit();
		return clearancesale;
	}
	public ClearanceSale getClearanceSaleByName(String name)
    {
		tx.begin();
        TypedQuery<ClearanceSale> query=em.createNamedQuery("ClearanceSale.findByName", ClearanceSale.class);
        ClearanceSale clearancesale=query.setParameter("clearanceSaleName", name).getSingleResult();
        tx.commit();
        return clearancesale;
    }
	public ClearanceSale getClearanceSaleById(int id)
    {
		tx.begin();
        TypedQuery<ClearanceSale> query=em.createNamedQuery("ClearanceSale.findByName", ClearanceSale.class);
        ClearanceSale clearancesale=query.setParameter("clearanceSaleId", id).getSingleResult();
        tx.commit();
        return clearancesale;
    }
}
