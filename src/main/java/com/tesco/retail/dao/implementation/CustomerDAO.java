package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tesco.retail.domain.entites.Customer;
import com.tesco.retail.domain.entites.Product;


public class CustomerDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public void insertCustomer(Customer cutsomer){
		
		tx.begin();
		em.merge(cutsomer);
		tx.commit();
	}
	public List<Object[]> getCustomerByEmail(String email)
    {
		tx.begin();
		String sql="select p.price,i.quantity,s.status,i.dateOfPurchase from Customer c join Cart cc on c.customerId=cc.customerId join  Product p on p.productId=cc.  and  where c.email='"+email+"'";
		Query query=em.createNativeQuery(sql);

      return query.getResultList();
        
        
        
    }
}
