package com.usthb.modeles;

public class Question {
	private String numQuestion; // le num de qst est composé de theme+niveau+numero de la question ex HIS13
	private String question; 
	private String reponse;
	private String image;//le path de l'image 
	private int niveau;
 
	public Question(String num , String qst, String rep, String image , int niveau) {
		this.numQuestion=num;
		this.question=qst;
		this.reponse=rep;
		this.image=image;
		this.niveau=niveau;
	}
	
  int getNbPoints(int index) {
	  switch(index) {
	  case 0: 
		  return 5;
	  
	  case 1: 
		  return 10;
	  
	  case 2: 
		  return 18;
	  
	  case 3: 
		  return 28;
	  case 4: 
		  return 40;
	  default :
		  
			  return 0;
	  }
 
                              }
  String getReponse() {
		 return reponse;
	 }	  
  String getNumQst() {
	  return numQuestion;
  }
  public String getQuestion() {
	  return question;
  }
  public int getniveau() {
	  return niveau;
  }
  public String imagepath() {
	  return image;
  }
    
}