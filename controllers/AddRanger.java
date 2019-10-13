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
@Named("addRanger")
public class AddRanger {
    @ManagedProperty(value = "#{animalManagedBean}")//managed property of Animal Managed Bean
    AnimalManagedBean animalManagedBean;
    
    private boolean showForm = true;
    
    private Ranger ranger;
    
    AnimalApplication app;
    
    public AddRanger(){
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (AnimalApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "animalApplication");

        //instantiate animalManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "animalManagedBean");
    }
    
    public void addRanger(Ranger localRanger){
        //this is the local animal, not the entity animal
        try{
            //add this animal to db via EJB
            animalManagedBean.addRanger(localRanger);
            
            //refresh the list in AnimalApplication bean
            app.searchAllAnimals();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ranger has been added succesfully"));
        }
        catch (Exception ex){
            
        }
        showForm = true;
    }
    
    
    public Ranger getRanger(){
        return ranger;
    }
    
    public void setRanger(Ranger ranger){
        this.ranger = ranger;
    }
    
    public boolean isShowForm() {
        return showForm;
    }
}
