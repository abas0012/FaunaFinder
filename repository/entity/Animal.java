/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.repository.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Adhi Baskoro
 */
@Entity //Declaring the Entity Class
@NamedQueries({
    @NamedQuery(name = Animal.GET_ALL_QUERY_NAME, query = "SELECT a FROM Animal a order by a.animalId desc")
})
public class Animal implements Serializable{

    public static final String GET_ALL_QUERY_NAME = "Animal.getAll";
    
    private int animalId;
    private String name;
    private int population;
    
    private Area area;
    private Ranger ranger;
    
    private Set<String> tags;
    
    //Non-default constructor
    public Animal() {
        this.tags = new HashSet<>();
    }
    
    //Constructor
    public Animal(int animalId, String name, int population, Area area, Ranger ranger, Set<String> tags) {
        this.animalId = animalId;
        this.name = name;
        this.population = population;
        this.area = area;
        this.ranger = ranger;
        this.tags = tags;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//generate Id in a sequenced order
    @Column(name = "animal_Id") 
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Embedded
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @ManyToOne //Many Animals to one Ranger
    public Ranger getRanger() {
        return ranger;
    }

    public void setRanger(Ranger ranger) {
        this.ranger = ranger;
    }

    @ElementCollection
    @CollectionTable(name = "tag")
    @Column(name = "value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
    
    @Override
    public String toString() {
        return "Animal{" + "animalId=" + animalId + ", name=" + name + ", population=" + population + ", area=" + area + '}';
    }
    
}
