package com.cesi.presentation.model;

import com.cesi.business.logic.StudentServiceLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.inject.Inject;

/**
 *
 * @author charles
 */
@Named(value = "studentModel")
@SessionScoped
public class StudentBean implements Serializable {
    
    private String firstname,lastname,email,password;
    //injection du service
    @Inject
    private StudentServiceLocal studentService;
    
    /**
     * Creates a new instance of StudentBean
     */
    public StudentBean() {
    }
    
    //méthodes d'action
    public String addIdentity(){
        System.out.println(firstname+" "+lastname);
        studentService.addStudent(firstname, lastname);
        return "authentication";
    }
    
    public String addAuthentication(){
        System.out.println(email+" "+password);
        studentService.addAuthenticationInformations(email, password);
        return "summary";
    }
    
    public String create(){
        System.out.println("création de l'étudiant");
        studentService.save();
        HttpSession session = (HttpSession) 		
            FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index";    
    }
    
    //getters & setters
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
