package no.bouvet.cert.chapter5.patterns.dao;

import java.util.Collection;
import java.util.List;

/**
 * Created by thomasa on 06.12.13.
 */
public interface CustomerDao {

    public Customer getCustomerByName(String name);
    public int createCustomer(Customer customer);
    public Collection<Customer> getAllCustomers();

}
