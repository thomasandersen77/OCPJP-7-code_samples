package no.bouvet.cert.chapter5.patterns.dao;

/**
 * Created by thomasa on 06.12.13.
 */
public class CustomerDaoFactory {
    /**
     * Hard coded implementation
     *
     * @return a simple mock implementation of CustomerDao
     */
    public static CustomerDao getFactory(){
        // here we can change implementation either via a parameter or property file or hard code it
        return new CustomerDaoMockImpl();
    }
}
