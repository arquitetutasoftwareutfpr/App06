/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cp.sa.business;

import edu.utfpr.cp.sa.dao.CountryDAO;
import  edu.utfpr.cp.sa.entity.Country;
import java.util.Set;

/**
 *
 * @author vande
 */
public class CountryBusiness {
    
     public boolean checkName(String name) throws Exception{
        if(name == null){
            throw new Exception("Name not informed!");
        }
        return true;
    }
     
    public boolean checkAcronym(String acronym) throws Exception{
        if(acronym == null){
            throw new Exception("Acronym not informed!");
        }
        return true;
    }
        
    private CountryDAO countryDAO = new CountryDAO();
    
    public Set<Country> read() throws Exception{
        return countryDAO.read();
    }
    
    public boolean create(Country c)throws Exception{
        return countryDAO.create(c);
    }
    
    
    public boolean update(Country c)throws Exception{
        return countryDAO.update(c);
    }
    
    public boolean delete(Long id)throws Exception{
        return countryDAO.delete(id);
    } 
    
}
