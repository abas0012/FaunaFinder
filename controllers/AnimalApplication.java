/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import fit5042.assign.mbeans.AnimalManagedBean;
import fit5042.assign.repository.entity.Animal;
import fit5042.assign.repository.entity.Ranger;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * AnimalApplication is the application scope class in the Java Server Page Architecture of Fauna Finder applicatio
 * @author Adhi Baskoro
 */
@Named(value = "animalApplication")
@ApplicationScoped
public class AnimalApplication {
    
    @ManagedProperty(value = "#{animalManagedBean}")//managed property of Animal Managed Bean
    AnimalManagedBean animalManagedBean;
    
    
    private ArrayList<Animal> animals;
    private ArrayList<Ranger> rangers;
    
    private boolean showForm = true;
    
    public boolean isShowForm() {
        return showForm;
    }
    
    //Add some animal data from DB to App
    public AnimalApplication() throws Exception {
        animals = new ArrayList<>();
        rangers = new ArrayList<>();
        
        //instantiate animalManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
        
        //get animal data from db
        updateAnimalList();
        updateRangerList();
    }
    
    
    //Animals
    public ArrayList<Animal> getAnimals(){
        return animals;
    }
    
    public void setAnimal(ArrayList<Animal> newAnimals){
        this.animals = newAnimals;
    }
    
    //when loading, and after adding or deleting, the property list needs to be refreshed
    //this method is for that purpose
    public void updateAnimalList(){
       // if (animals != null && animals.size() > 0)
       // {
       //     
       // }
       // else
       // {
            animals.clear();
            
            for (fit5042.assign.repository.entity.Animal animal : animalManagedBean.getAllAnimals())//for each animal entry in the Entity Class Animal, get all animals
            {
                animals.add(animal); //add Animal data to the ArrayList<Animal> animals
            }
            
            setAnimal(animals); //set the global ArrayList attribute with the local ArrayList attribute
       // }
    }
    
    public void searchAnimalById(int animalId){
        animals.clear();
        
        animals.add(animalManagedBean.searchAnimalById(animalId));
    }
    
    public void searchAnimalByPopulation(int population){
        animals.clear();
        
        for (fit5042.assign.repository.entity.Animal animal : animalManagedBean.searchAnimalByPopulation(population))//for each animal entry in the Entity Class Animal, get all animals
            {
                animals.add(animal); //add Animal data to the ArrayList<Animal> animals
            }
            
            setAnimal(animals); //set the global ArrayList attribute with the local ArrayList attribute
        
    }
    
    public void searchAllAnimals(){
        animals.clear();
        
        for (fit5042.assign.repository.entity.Animal animal : animalManagedBean.getAllAnimals())
            {
                animals.add(animal); //add Animal data to the ArrayList<Animal> animals
            }
            
            setAnimal(animals); //set the global ArrayList attribute with the local ArrayList attribute             
    }
    
    //Rangers
    public ArrayList<Ranger> getRangers(){
        return rangers;
    }
    
    public void setRanger(ArrayList<Ranger> newRangers){
        this.rangers = newRangers;
    }
    
    public void updateRangerList(){

            rangers.clear();
            
            for (fit5042.assign.repository.entity.Ranger ranger : animalManagedBean.getAllRangers())//for each animal entry in the Entity Class Animal, get all animals
            {
                rangers.add(ranger); //add Ranger data to the ArrayList<Ranger> ranger
            }
            
            setRanger(rangers); //set the global ArrayList attribute with the local ArrayList attribute
       // }
    }
    
    public void searchRangerById(int rangerId){
        rangers.clear();
        
        rangers.add(animalManagedBean.searchRangerById(rangerId));
    }
    
    
    public void searchAllRangers(){
        animals.clear();
        
        for (fit5042.assign.repository.entity.Animal animal : animalManagedBean.getAllAnimals())
            {
                animals.add(animal); //add Animal data to the ArrayList<Animal> animals
            }
            
            setAnimal(animals); //set the global ArrayList attribute with the local ArrayList attribute             
    }
}
