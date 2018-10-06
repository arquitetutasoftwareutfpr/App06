package edu.utfpr.cp.sa.entity;

import edu.utfpr.cp.sa.business.CountryBusiness;
import lombok.Data;

@Data
public class Country {
	
        private Long id;
	private String name;
	private String acronym;
	private int phoneDigits;
        
        private CountryBusiness business;
        
        public Country(){
            this.business = new CountryBusiness();
        }
        
        public Country(Long id ,String name , String acronym ,int phoneDigits){
            this.id = id;
            this.name = name;
            this.acronym = acronym;
            this.phoneDigits = phoneDigits;
            this.business = new CountryBusiness();
        }
        
        public void setName(String name) throws Exception{
            if(business.checkName(name)){
                this.name = name;
            }
        }
        
        public void setAcronym(String acronym) throws Exception{
            if(business.checkAcronym(acronym)){
                this.acronym = acronym;
            }
        }
	
        @Override
	public int hashCode() {
		return this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Country other = (Country) obj;
		
		return this.getName().equalsIgnoreCase(other.getName());
	}
	
	

}
