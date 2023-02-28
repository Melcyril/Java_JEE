package com.cp;

public class Article {
	private long Codebarre;
	private String Reference;
	private String Libelle;
	private int PrixHT;
	private int TVA;
	private int[] IndiceTVA= {550,2000};
	public Article() {

	}
	
	public Article(long codebarre, String reference,String libelle,int prixht,int indice) {
		Codebarre=codebarre;
		Reference=reference;
		Libelle=libelle;
		PrixHT=prixht;
		TVA=IndiceTVA[indice];
	}
	public long getCodebarre() {
		return Codebarre;
	}

	public void setCodebarre(long codebarre) {
		Codebarre = codebarre;
	}
	public String getReference() {
		return Reference;
	}
	public int getTVA() {
		return TVA;
	}
	public void setTVA(int tVA) {
		TVA = tVA;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public int getPrixHT() {
		return PrixHT;
	}
	public void setPrixHT(int prixHT) {
		PrixHT = prixHT;
	}
	public int[] getIndiceTVA() {
		return IndiceTVA;
	}
	public void setIndiceTVA(int[] indiceTVA) {
		IndiceTVA = indiceTVA;
	}
}
