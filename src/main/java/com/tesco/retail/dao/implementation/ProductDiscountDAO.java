package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.tesco.retail.domain.entites.ClearanceSale;
import com.tesco.retail.domain.entites.Product;
import com.tesco.retail.domain.entites.ProductDiscount;

public class ProductDiscountDAO {
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	public void insertProductDiscount(ProductDiscount productdiscount){
		
		tx.begin();
		em.merge(productdiscount);
		tx.commit();
	}
	public void removeProduct(int pid){
		ProductDiscount productDiscount = em.find(ProductDiscount.class, pid);
		tx.begin();
		em.remove(productDiscount);
		tx.commit();
	}
	public List<ProductDiscount> getProduct()
    {
		tx.begin();
        TypedQuery<ProductDiscount> query=em.createNamedQuery("ProductDiscount.findAll", ProductDiscount.class);
       return query.getResultList();
        
        
    }
	public ProductDiscount getProductById(int productId)
    {
		tx.begin();
		
        TypedQuery<ProductDiscount> query=em.createNamedQuery("ProductDiscount.findByName", ProductDiscount.class);
        return query.setParameter("productId", productId).getSingleResult();
        
    }
	
}
