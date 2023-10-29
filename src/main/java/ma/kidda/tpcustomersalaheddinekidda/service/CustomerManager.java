/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.kidda.tpcustomersalaheddinekidda.service;

import ma.kidda.tpcustomersalaheddinekidda.entity.Customer;


import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * Gère la persistance des Customers
 */

@RequestScoped
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<Customer> getAllCustomers() {  
        Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList(); 
    }
    
    public Customer findById(int idCustomer) {  
  return em.find(Customer.class, idCustomer);  
}

    @Transactional
    public Customer update(Customer customer) {
     return em.merge(customer);
    }   
    
    @Transactional
     public void persist(Customer customer) {
       em.persist(customer);
    }
}
