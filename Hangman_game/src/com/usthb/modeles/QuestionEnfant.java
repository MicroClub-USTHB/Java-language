package com.usthb.modeles;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionEnfant extends Question implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QuestionEnfant(String num, String qst, String rep, String image, int niveau) {
		super(num, qst, rep, image, niveau);
		}
	//cette methode est pour filtrer la liste des question pour obtenir les question de type Enfant
	public static ArrayList<Question> getQstEnfant(ArrayList<Question> liste){
		ArrayList<Question> l= new ArrayList<Question>();
		for(Question q :liste)
			if(q.getClass().getSimpleName().toString().equals("QuestionEnfant"))
				l.add(q);
		return l;
	}
	@Override 
	public String toString() {
		return "Enfant:"+this.getNumQst()+" ,question:"+this.getQuestion()+" ,Reponse:"+this.getReponse()+".";
	}

	

}