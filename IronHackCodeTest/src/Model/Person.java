/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author imanol
 */
public class Person {
    
    String name;
    Date yearOfBirth;
    Date yearOfDeath;
    String bio;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    
    
    public String getName() {
        return name;
    }

    public Date getYearOfBirth() {
        return yearOfBirth;
    }

    public Date getYearOfDeath() {
        return yearOfDeath;
    }

    public String getBio() {
        return bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(Date yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setYearOfDeath(Date yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    public String toString(){
        return this.name;
    }
    
    
}
