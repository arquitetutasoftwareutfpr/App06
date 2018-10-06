package edu.utfpr.cp.sa.entity;

import edu.utfpr.cp.sa.business.CustomerBusiness;
import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private String phone;
    private int age;
    private double creditLimit;

    private CustomerBusiness business;

    private Country country;

    public Customer() {
        this.business = new CustomerBusiness();
    }

    public Customer(Long id, String name, String phone, int age, double creditLimit, Country country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.country = country;
        this.business = new CustomerBusiness();
    }

    public void setName(String name) throws Exception {
        if (business.checkName(name)) {
            throw new Exception("Sorry, name must be 5 characters in length!");
        }

        this.name = name;
    }

    public void setPhone(String phone) throws Exception {
        if (business.checkPhone(this.getCountry(), phone)) {
            this.phone = phone;
        }
    }

    public void setAge(int age) {
        this.age = age;
        this.setCreditLimit(this.getCreditLimit() + business.calcCreditLimitByAge(age));
    }

    public void setCountry(Country country) throws Exception {

        if (business.checkCountry(country)) {
            this.setCreditLimit(this.getCreditLimit() + business.calcCreditLimitByCountry(country.getName()));
            this.country = country;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Customer other = (Customer) obj;

        return this.getName().equalsIgnoreCase(other.getName());
    }

}
