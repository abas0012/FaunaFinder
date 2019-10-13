/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Adhi Baskoro
 */
@Entity
@Table(name = "RANGER")
@NamedQueries({
    @NamedQuery(name = Ranger.GET_ALL_QUERY_NAME, query = "SELECT r FROM Ranger r")
})
public class Ranger implements Serializable{
    
    private int rangerId;
    private String name;
    private String phone;
    private String password;
    
    private Set<Animal> animal;
    
    public static final String GET_ALL_QUERY_NAME = "Ranger.getAll";

    public Ranger() {
    }

    public Ranger(int rangerId, String name, String phone, String password) {
        this.rangerId = rangerId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.animal = new HashSet<>();
    }
    
    @Id
    @GeneratedValue
    @Column(name = "ranger_Id")
    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "ranger")//One Ranger to Many Animals
    public Set<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(Set<Animal> animal) {
        this.animal = animal;
    }
    
    @Override
    public String toString() {
        return this.rangerId + " - " + name + " - " + phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.rangerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ranger other = (Ranger) obj;
        if (this.rangerId != other.rangerId) {
            return false;
        }
        return true;
    }
    
}
