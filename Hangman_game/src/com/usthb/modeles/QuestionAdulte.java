package com.usthb.modeles;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionAdulte extends Question implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QuestionAdulte(String num, String qst, String rep, String image, int niveau) {
		super(num, qst, rep, image, niveau);
		// TODO Auto-generated constructor stub
	}
	//cette methode est pour filtrer la liste des question pour obtenir les question de type Adulte
	public static ArrayList<Question> getQstAdulte(ArrayList<Question> liste){
		ArrayList<Question> l= new ArrayList<Question>();
		for(Question q :liste)
			if(q.getClass().getSimpleName().toString().equals("QuestionAdulte"))
				l.add(q);
		return l;
	}
	@Override 
	public String toString() {
		return "Adulte:"+this.getNumQst()+" ,question:"+this.getQuestion()+" ,Reponse:"+this.getReponse()+".";
	}

	

}