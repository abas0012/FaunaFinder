/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.assign.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * TitleController class controls the displayed title of the web application in the browser.
 * @author Adhi Baskoro
 */
@Named(value = "titleController")
@RequestScoped
public class TitleController {
    
    private String pageTitle;
    
    public TitleController() {
        //Set the page title of the web application
        pageTitle = "Fauna Finder by Local Heritage Organisation";
    }
    
    public String getPageTitle() {
        return pageTitle;
    }
    
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
}
