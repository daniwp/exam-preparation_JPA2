/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nikolaj
 */
@Entity
public class PHDStudent extends Employee{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dissSubject;

    public PHDStudent() {
    }

    public PHDStudent(String dissSubject, int soSecNr, float wage, String taxClass, String firstName, String lastName, int age) {
        super(soSecNr, wage, taxClass, firstName, lastName, age);
        this.dissSubject = dissSubject;
    }

    public String getDissSubject() {
        return dissSubject;
    }
    
    public void setDissSubject(String dissSubject) {
        this.dissSubject = dissSubject;
    }
    
    
}
