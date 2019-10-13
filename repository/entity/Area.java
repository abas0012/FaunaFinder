/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Adhi Baskoro
 */
@Embeddable //Embeddable to Animal Class
@Access(AccessType.PROPERTY)//Access through one of Animal Class' property
public class Area implements Serializable{

 
    private String suburb;
    private String state;
    
    //Non-default constructor
    public Area() {
        
    }
    
    //Constructor
    public Area(String suburb, String state) {
        this.suburb = suburb;
        this.state = state;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
   
    @Override
    public String toString() {
        return suburb + ", " + state;
    }
    
}
