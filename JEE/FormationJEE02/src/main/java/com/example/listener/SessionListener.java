package com.example.listener;

import java.util.ArrayList;

import com.example.model.Operation;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
public class SessionListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        System.out.println("Attribut remplacé dans la session");
        
        String nom = se.getName();
        Object obj = se.getValue();
        
        if(nom.equals("historique") && obj instanceof ArrayList) {
        	
        	ArrayList<Operation> ops = (ArrayList<Operation>) obj;
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
         System.out.println("Attribut ajouté dans la session");
    }
	
}
