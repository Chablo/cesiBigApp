package com.cesi.business.logic;

import javax.ejb.Stateful;
import javax.ejb.Remove;

/**
 *
 * @author charles
 */
@Stateful
public class StudentService implements StudentServiceLocal {

    @Override
    public void addStudent(String firstname, String lastname) {
        System.out.println("identité de l'etudiant "+firstname+" "+lastname);
    }

    @Override
    public void addAuthenticationInformations(String email, String pwd) {
        System.out.println("ajout des informations d'authentification : "+email+" - "+pwd);
    }

    @Override
    @Remove
    public void save() {
        System.out.println("sauvegarde de l'étudiant créé");
    }
}
