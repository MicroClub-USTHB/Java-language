package com.usthb.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.usthb.EUREKA;

public class Adulte extends Joueur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Adulte(String nom, String prenom, String mdp, Date datenaiss, int num) {
		super(nom, prenom, mdp, datenaiss, num);
	}
	
	public String toString() {
		return "categorie:Adulte ,Nom:"+this.getNom()+" ,Prenom:"+this.getPrenom()+",Score:"+this.getTotalScore()+"\n";
	}
	@Override
	 ArrayList<Question> getQuestions(String thème) {
		System.out.println("\t------getQuestions Adulte-----");
		ArrayList<Question> liste=null;
		//les themes avec les question sont deja stocké dans le hashset dans euroka 
		for(ThemeJeu t : EUREKA.getListeTheme() )
			if(t.libelle.equalsIgnoreCase(thème))
				liste = new ArrayList<>(t.listeQstTheme);//pour la convertion
		System.out.println("le theme (Adulte) est:"+thème+"\n et la liste des question:"+liste);	
		System.out.println("\t------End getQuestions Adulte-----");
		return liste;
		
	}
	
	public int NombreDessaie(){
		return 2;
	}


}