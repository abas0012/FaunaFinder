/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import fit5042.assign.repository.entity.Animal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Adhi Baskoro
 */
@RequestScoped
@Named(value = "ranger")
public class Ranger implements Serializable{
    
    private int rangerId;
    private String rangerName;
    private String phone;
    private String password;
    
    private Set<String> tags;
    private Set<fit5042.assign.repository.entity.Ranger> rangers;
    
    public Ranger(int rangerId, String rangerName, String phone, String password, Set<String> tags) {
        this.rangerId = rangerId;
        this.rangerName = rangerName;
        this.phone = phone;
        this.password = password;
        this.tags = (HashSet<String>) tags;
    }

    public Ranger(){
        this.tags = new HashSet<>();
    }
    
    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

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

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<fit5042.assign.repository.entity.Ranger> getRangers() {
        return rangers;
    }

    public void setRangers(Set<fit5042.assign.repository.entity.Ranger> rangers) {
        this.rangers = rangers;
    }
    
    @Override
    public String toString() {
        return "Ranger{" + "rangerId=" + rangerId + ", rangerName=" + rangerName + ", phone=" + phone + ", password=" + password + ", tags=" + tags + '}';
    }
}
