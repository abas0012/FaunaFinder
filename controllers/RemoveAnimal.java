/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import fit5042.assign.mbeans.AnimalManagedBean;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Adhi Baskoro
 */
@RequestScoped
@Named("removeProperty")
public class RemoveAnimal {
    @ManagedProperty(value = "#{animalManagedBean}")//managed property of Animal Managed Bean
    AnimalManagedBean animalManagedBean;
    
    private boolean showForm = true;
    
    private Animal animal;
    
    AnimalApplication app;
    
    public void setAnimal(Animal animal){
        this.animal = animal;
    }
    
    public Animal getAnimal(){
        return animal;
    }
    
    public boolean isShowForm() {
        return showForm;
    }
    
    public RemoveAnimal(){
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (AnimalApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "animalApplication");

        app.updateAnimalList();
        
        //instantiate animalManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
    }
    
    public void removeAnimal(int animalId){
        try{
            animalManagedBean.removeAnimal(animalId);
            
            app.searchAllAnimals();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal has been deleted succesfully")); 
        }
        catch (Exception ex)
       {
           
       }
       showForm = true;
    }
}
