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
@Named("searchRanger")
public class SearchRanger {

    
    AnimalApplication app;
    
    private Ranger ranger;
    
    private int searchByInt;
    
    public AnimalApplication getApp(){
        return app;
    }
    
    public SearchRanger(){
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (AnimalApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "animalApplication");
        
        app.updateRangerList();
    }
    
    public void searchRangerById(int rangerId){
        try{
            app.searchRangerById(rangerId);
        }
        catch (Exception ex)
        {
            
        }
    }
    
    public void setApp(AnimalApplication app){
        this.app = app;
    }
    
    public Ranger getRanger() {
        return ranger;
    }

    public void setRanger(Ranger ranger) {
        this.ranger = ranger;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }
    
    public void searchAllRangers() 
    {
       try
       {
            //return all properties from db via EJB
             app.searchAllRangers();
       }
       catch (Exception ex)
       {
           
       }
    }
    
    
    
}
