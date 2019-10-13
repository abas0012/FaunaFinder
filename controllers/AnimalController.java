/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Adhi Baskoro
 */
@RequestScoped
@Named(value = "animalController")
public class AnimalController {
    
    private int animalId; //animalId as index
    
    private int rangerId; //rangerId as index
    
    private fit5042.assign.repository.entity.Animal animal;
    private fit5042.assign.repository.entity.Ranger ranger;
    
    public AnimalController() {
        //assign animal idenfifier via GET param
        //this animalId is an index
        animalId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("animalID"));
        animal = getAnimal();
        
        //assign ranger idenfifier via GET param
        //this rangerId is an index
        rangerId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("rangerID"));
        ranger = getRanger();
    }
    
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    
    public fit5042.assign.repository.entity.Animal getAnimal(){
        if (animal == null){
            //Get application context bean AnimalApplication
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            AnimalApplication app
                    = (AnimalApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "animalApplication");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getAnimals().get(--animalId); //this animalId is the index
        }
        return animal;
    }

    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }
    
    public fit5042.assign.repository.entity.Ranger getRanger(){
        if (animal == null){
            //Get application context bean AnimalApplication
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            AnimalApplication app
                    = (AnimalApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "animalApplication");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getRangers().get(--rangerId); //this animalId is the index
        }
        return ranger;
    }
    
    
}
