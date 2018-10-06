/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CustomerDAO;
import edu.utfpr.cp.sa.entity.Country;
import edu.utfpr.cp.sa.entity.Customer;
import java.util.Set;

/**
 *
 * @author vande
 */
public class CustomerBusiness {

    private CustomerDAO customerDAO = new CustomerDAO();

    public boolean checkCountry(Country c) throws Exception {
        if (c == null || c.getName().length() < 1) {
            throw new Exception("Country must be informed!");
        }
        return true;
    }
    
    public boolean checkName(String name) {
        return name.length() < 5;
    }

    public boolean checkPhone(Country c, String phone) throws Exception {
        if (c == null) {
            throw new Exception("Country must be defined!");
        }

        if (phone.length() != c.getPhoneDigits()) {
            throw new Exception("Phone does not conform to country!");
        }
        return true;
    }

    public double calcCreditLimitByAge(int age){
        if (age <= 18) {
            return 100.0;
        } else if (age <= 35) {
            return 300.0;
        } else {
            return 500.0;
        }
    }
    
    public double calcCreditLimitByCountry(String countryName){
        return countryName.equalsIgnoreCase("Brazil") ? 100.0 : 0.0;
    }
    
    public Set<Customer> read() {
        return customerDAO.read();
    }

    public boolean create(Customer c) throws Exception {
        return customerDAO.create(c);
    }

    public boolean update(Customer c) throws Exception {
        return customerDAO.update(c);
    }

    public boolean delete(Long id) throws Exception {
        return customerDAO.delete(id);
    }

}
