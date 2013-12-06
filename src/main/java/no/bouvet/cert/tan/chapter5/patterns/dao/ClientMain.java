package no.bouvet.cert.tan.chapter5.patterns.dao;

/**
 * Created by thomasa on 06.12.13.
 */
public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        CustomerDao customerDao = CustomerDaoFactory.getFactory();

        Customer customer = new Customer("thomas");
        int customerId = customerDao.createCustomer(customer);
        Customer customer2 = new Customer("anne");
        int customerId2 = customerDao.createCustomer(customer2);
        Customer customer3 = new Customer("gaute");
        int customerId3 = customerDao.createCustomer(customer3);
        Thread.sleep(50);
        System.out.println("Print all Customers:");
        customerDao.getAllCustomers().forEach(System.err::println);

        System.out.println("Find Customer by name:");
        Thread.sleep(50);
        Customer customerByName = customerDao.getCustomerByName("gaute");
        assert customerByName.getName().equals("gaute");
        System.err.println(customerByName.toString());
    }
}
