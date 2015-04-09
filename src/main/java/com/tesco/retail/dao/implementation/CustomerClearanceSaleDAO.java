package com.tesco.retail.dao.implementation;

import java.util.List;

import javax.persistence.*;

public class CustomerClearanceSaleDAO {

	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tx=em.getTransaction();
	
	public List<Object[]> getCustomerByEmail(String email)
    {
		tx.begin();
		String sql="select p.productName,p.price as ((i.quantity*p.price)-((i.quantity*p.price)*((0.01)*d.discount))), i.quantity, s.productstatusInfo from " +
				"  productdisconunt d Customer c join  cart r on c.customerId=r.customerId join  CartItem i on i.cartId=r.cartId join product p on i.productId=p.productId join on shipping s(s.customerId=c.customerId) join on productstatus q(q.productstatusId=s.statusId)  where c.email='"+email+"'";
		Query query=em.createNativeQuery(sql);

     
	return query.getResultList();
        
        
        
    }
	public List<Object[]> getCustomerdetailbyemail(String email){
		tx.begin();
		String sql="select * from Customer";
		
		Query query=em.createNativeQuery(sql);
		return query.getResultList();
		
		
	}
}
