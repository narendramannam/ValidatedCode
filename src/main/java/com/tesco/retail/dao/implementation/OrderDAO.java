package com.tesco.retail.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tesco.retail.domain.entites.Cart;
import com.tesco.retail.domain.entites.Order;
import com.tesco.retail.domain.entites.Product;

public class OrderDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public void insertOrder(Order order){
		
		tx.begin();
		em.persist(order);
		tx.commit();
	}
	public List<Order> getOrder()
    {
		tx.begin();
        TypedQuery<Order> query=em.createNamedQuery("Orders.findAll", Order.class);

		
        List<Order> orders=query.getResultList();
        
        return orders;
    }
	
	public List<Order> getListOfOrdersByDate(Date date)
    {
		tx.begin();
        TypedQuery<Order> query=em.createNamedQuery("Orders.findByName", Order.class);
        List<Order> orders=query.setParameter("dateOfPurchase", date).getResultList();
        
        tx.commit();
        return orders;
    }
}
