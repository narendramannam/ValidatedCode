package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.*;

import com.tesco.retail.domain.entites.Inventory;
import com.tesco.retail.domain.entites.Product;

public class InventoryDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public void insertIntventory(Inventory inventory){
		tx.begin();
		em.merge( inventory);
		tx.commit();
	}
	public List<Inventory> getInventory()
    {
		tx.begin();
        TypedQuery<Inventory> query=em.createNamedQuery("inventory.findAll", Inventory.class);
        List<Inventory> inventory=query.getResultList();
        
        return inventory;
    }
}
