/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Adhi Baskoro
 */
@RequestScoped
@Named("searchAnimal")
public class SearchAnimal {

    private Animal animal;
    
    AnimalApplication app;
    
    private int searchByInt;
    
    public AnimalApplication getApp(){
        return app;
    }
    
    public void setApp(AnimalApplication app){
        this.app = app;
    }
    
    private int seachByPopulation;
    
    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }
    
        public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getSeachByPopulation() {
        return seachByPopulation;
    }

    public void setSeachByPopulation(int seachByPopulation) {
        this.seachByPopulation = seachByPopulation;
    }
    
    public SearchAnimal(){
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (AnimalApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "animalApplication");
        
        app.updateAnimalList();
    }
    
    public void searchAnimalById(int animalId){
        try{
            app.searchAnimalById(animalId);
        }
        catch (Exception ex)
        {
            
        }
    }
    
    public void searchAnimalByPopulation(int population)
    {
        try{
            app.searchAnimalByPopulation(population);
        }
        catch (Exception ex)
        {
            
        }
    }
    
    public void searchAllAnimals() 
    {
       try
       {
            //return all properties from db via EJB
             app.searchAllAnimals();
       }
       catch (Exception ex)
       {
           
       }
    }
    
}
