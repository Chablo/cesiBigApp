package com.cesi.business.logic;

import javax.ejb.Local;

/**
 *
 * @author charles
 */
@Local
public interface StudentServiceLocal {
    
    public void addStudent(String firstname, String lastname);
    
    public void addAuthenticationInformations(String email, String pwd);
    
    public void save();   
}
