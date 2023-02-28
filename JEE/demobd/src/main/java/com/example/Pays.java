package com.example;

public class Pays {
	private String nom;
	private int population;
	private String continent;
	private double superficie;
	
public Pays(String nom, String continent,double superficie,int population) {
	super();
	this.nom=nom;
	this.continent=continent;
	this.superficie=superficie;
	this.population=population;
}
public Pays(String nom,int population) {
	super();
	this.nom=nom;
	this.population=population;
}
public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int getPopulation() {
	return population;
}

public void setPopulation(int population) {
	this.population = population;
}

public String getContinent() {
	return continent;
}

public void setContinent(String continent) {
	this.continent = continent;
}

public double getSuperficie() {
	return superficie;
}

public void setSuperficie(int superficie) {
	this.superficie = superficie;
}

}
