package no.bouvet.cert.chapter5.patterns.dao;

import java.util.*;

/**
 * Created by thomasa on 06.12.13.
 */
public class CustomerDaoMockImpl implements CustomerDao {
    private final Random rnd = new Random(31);
    private Map<Integer, Customer> customerContainer = new HashMap<>();

    public CustomerDaoMockImpl() {
    }

    @Override
    public Customer getCustomerByName(String name) {
        for(Customer customer : customerContainer.values()) {
            if(customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        throw new RuntimeException("Customer not found by give name [" + name + "]");
    }

    @Override
    public int createCustomer(Customer customer) {
        int customerId = rnd.nextInt(10_000);
        customer.setId(customerId);
        customerContainer.put(customerId, customer);
        System.err.printf("Created Customer with name [%s], id [%s]\n", customer.getName(), customerId);
        return customerId;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerContainer.values();
    }
}
