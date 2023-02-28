package com.example.listener;

import java.util.ArrayList;

import com.test.operation;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class AttributListener
 *
 */
public class AttributListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public AttributListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Un attribut a été remplacé");
    	//Recupérer le nom de l'attribut  historique de la session
    	String nom=se.getName();
    	// Recupérer la valeur de l'attricbut  historique de la session
    	Object obj= se.getValue();
    	if(nom.equals("historique")&& obj instanceof ArrayList) {
    		ArrayList<operation> ops=(ArrayList<operation>) obj;
    		System.out.println("Taille de la liste : " + ops.size());
    	}

    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("Un attribut a été ajouté");
    	//Recupérer le nom de l'attribut  historique de la session
    	String nom=se.getName();
    	// Recupérer la valeur de l'attricbut  historique de la session
    	Object obj= se.getValue();
    	if(nom.equals("historique")&& obj instanceof ArrayList) {
    		ArrayList<operation> ops=(ArrayList<operation>) obj;
    		System.out.println("Taille de la liste : " + ops.size());
    	}
    }
	
}
