package com.usthb.modeles;
import java.io.Serializable;
import java.util.*;



public class ThemeJeu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int coef;
	String libelle;
	LinkedList<Question> listeQstTheme;
	public static enum theme {HISTOIRE(1),GEOGRAPHIE(2),SANTE(3),CULTUREGENERALE(4),ISLAM(5);
								//chaque theme avec son coif 
				 private int a ; 
				 theme(int a ){
					 this.a=a;
				 }
				 int coifTheme() {
					 return this.a;
				 }
			}
	
	public ThemeJeu(String the, ArrayList<Question> liste) {
		theme t = theme.valueOf(the.toUpperCase());
		this.libelle=t.toString();
		this.coef=t.coifTheme();
		this.listeQstTheme= new LinkedList<Question>();
		for(Question q:liste) 
			if(q.getNumQst().charAt(0)==libelle.charAt(0))
				listeQstTheme.add(q);
	}
	@Override
	public String toString() {
		return "\nTheme:"+this.libelle+" ,Coif:"+this.coef+" ,liste des question:"+this.listeQstTheme;
	}
	
}