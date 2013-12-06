package no.bouvet.cert.chapter5.patterns.dao;

/**
 * Created by thomasa on 06.12.13.
 */
public class CustomerDaoFactory {

    public static CustomerDao getFactory(){
        return new CustomerDaoMockImpl();
    }
}
