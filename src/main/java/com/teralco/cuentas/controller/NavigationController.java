package com.teralco.cuentas.controller;

import jakarta.annotation.ManagedBean;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@ViewScoped
public class NavigationController implements Serializable{

    private static final Logger logger = LoggerFactory.getLogger(NavigationController.class);
    private String currentPage = "";
    private String contentPath = "home.xhtml";

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void updateContentPath(String currentPage) {
        this.contentPath = currentPage + ".xhtml";
    }
}
