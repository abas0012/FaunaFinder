/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.mbeans;

import fit5042.assign.repository.AnimalRepository;
import fit5042.assign.repository.entity.Animal;
import fit5042.assign.repository.entity.Area;
import fit5042.assign.repository.entity.Ranger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adhi Baskoro
 */
@ManagedBean(name = "animalManagedBean")
@SessionScoped
public class AnimalManagedBean implements Serializable{

    @EJB //Dependency Injection for EJB
    AnimalRepository animalRepository;
    
    public AnimalManagedBean() {
    }
    
    public void addAnimal(Animal animal){
        try{
            animalRepository.addAnimal(animal);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Animal searchAnimalById(int id){
        try {
            return animalRepository.searchAnimalById(id);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Animal> getAllAnimals(){
        try{
            List<Animal> animals = animalRepository.getAllAnimals();
            return animals;
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public List<Ranger> getAllRangers(){
        try{
            return animalRepository.getAllRangers();
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void removeAnimal(int animalId){
        try{
            animalRepository.removeAnimal(animalId);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editAnimal(Animal animal){
        try{
            animalRepository.editAnimal(animal);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Set<Animal> searchAnimalByRanger(Ranger ranger){
        try{
            return animalRepository.searchAnimalByRanger(ranger);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Animal> searchAnimalByPopulation(int population){
        try{
            return animalRepository.searchAnimalByPopulation(population);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addAnimal(fit5042.assign.controllers.Animal localAnimal) {
        //convert this newAnimal which is the local property to entity property
        Animal animal = converAnimalToEntity(localAnimal);
        
        try{
            animalRepository.addAnimal(animal);
        }
        catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Animal converAnimalToEntity(fit5042.assign.controllers.Animal localAnimal){
            Animal animal = new Animal(); //entity
            String suburb = localAnimal.getSuburb();
            String state = localAnimal.getState();
            Area area = new Area(suburb, state);
            animal.setAnimalId(localAnimal.getAnimalId());
            animal.setArea(area);
            animal.setName(localAnimal.getAnimalName());
            animal.setPopulation(localAnimal.getPopulation());
            animal.setTags(localAnimal.getTags());
            int rangerId = localAnimal.getRangerId();
            String rangerName = localAnimal.getRangerName();
            String phone = localAnimal.getPhone();
            String password = localAnimal.getPassword();
            Ranger ranger = new fit5042.assign.repository.entity.Ranger(rangerId, rangerName, phone, password);
            if (ranger.getRangerId() == 0)
                ranger = null;
            animal.setRanger(ranger);
            return animal;
    }
    
}
