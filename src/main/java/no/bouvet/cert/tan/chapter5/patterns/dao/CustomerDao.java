package no.bouvet.cert.tan.chapter5.patterns.dao;

import java.util.Collection;

/**
 * Created by thomasa on 06.12.13.
 */
public interface CustomerDao {

    public Customer getCustomerByName(String name);
    public int createCustomer(Customer customer);
    public Collection<Customer> getAllCustomers();

}
