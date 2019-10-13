/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import fit5042.assign.repository.entity.Area;
import fit5042.assign.repository.entity.Ranger;

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
@Named(value = "animal")
public class Animal implements Serializable{   
    private int animalId;
    private String animalName;
    private int population;
    
    private Area area;
    private Ranger ranger;
    
    private Set<String> tags;
    
    private String suburb;
    private String state;
    
    private int rangerId;
    private String rangerName;
    private String phone;
    private String password;
    
    private Set<fit5042.assign.repository.entity.Animal> animals;
    
    public Animal(){
        this.tags = new HashSet<>();
    }
    
    public Animal(int animalId, String animalName, int population, Area area, Ranger ranger, Set<String> tags) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.population = population;
        this.area = area;
        this.ranger = ranger;
        this.tags = (HashSet<String>) tags;
    }
    
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Ranger getRanger() {
        return ranger;
    }

    public void setRanger(Ranger ranger) {
        this.ranger = ranger;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
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

    public Set<fit5042.assign.repository.entity.Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<fit5042.assign.repository.entity.Animal> animals) {
        this.animals = animals;
    } 
    
    @Override
    public String toString() {
        return "Animal{" + "animalId=" + animalId + ", animalName=" + animalName + ", population=" + population + ", area=" + area + ", ranger=" + ranger + ", tags=" + tags + '}';
    }
}
