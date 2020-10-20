package com.usthb.modeles;
import java.io.Serializable;
import java.util.*;



 public abstract class Joueur implements Serializable {
 
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private final int numseq;
	 private final String nom,prenom,mdp;
	 private final Date datenaiss ;
	 private List<PartieJeu> partieJeuRealise;
	 private HashMap<String,Integer> dernierniveau;
 
	 public Joueur(String nom,String prenom,String mdp,Date datenaiss,int num) {
		 this.nom = nom;
		 this.prenom = prenom;
		 this.mdp = mdp;
		 this.datenaiss = new Date(datenaiss.getYear(),datenaiss.getMonth(),datenaiss.getDate());
		 this.numseq=num;
		 this.dernierniveau=new HashMap<String, Integer>();
		 for(ThemeJeu.theme t : ThemeJeu.theme.values()) //on cree la liste des dernier niveau pour chaque theme
				this.dernierniveau.put(t.toString(), 0); //on mets chaque dernier niveau a 0
		 this.partieJeuRealise= new ArrayList<>();
		
	 }
	 abstract ArrayList<Question> getQuestions(String thème) ;
	 abstract public int NombreDessaie();//nombre d'essaie pour chaque niveau 3 pour enfant et 2 pour Adulte
		
	 //j'utilise la methode jouer pour recuperer la prochaine question a joueur
	 //donc il va charcher la liste des question de niveau 
	 //et trouver la prochaine question a joueur
	 public Question Jouer(String theme) {
		 System.out.println("\t ----- Joueur -----"); 
		 	Question q = null;
			boolean trouve ;
			ArrayList<Question> liste =getQuestions(theme); //elle nous retourne la liste des question de theme pour
															//un adulte ou bien enfant ca dep de joueur en cours
			for(Question a : liste) {
					trouve=false;
					//on doit verifie si la question et deja joué (elle existe dans la liste des partie de jeu
					//et si elle est de niveau inferiure ou nan
					for(PartieJeu p :partieJeuRealise)
						if(a.getNumQst().equalsIgnoreCase(p.getNumQstPartie()) || a.getniveau()<=this.dernierniveau.get(theme))	
							{trouve=true;
							System.out.println("boucle for");
							break;
						}
					if(!trouve) {
						q=a;
						break;
					}
				}
			System.out.println("la question retourner apres la methode jouer est:\n"+q);
			System.out.println("\t---- fin Jouer----");
			return q;
	 }
	  
	 public int getTotalScore() {
		  int sc=0; 
		  for(ThemeJeu.theme t :ThemeJeu.theme.values() )
			  switch(dernierniveau.get(t.toString())) {
			  case 1: 
				  sc=sc+5; break;
			  
			  case 2: 
				  sc=sc+15; break;
			  
			  case 3: 
				  sc=sc+ 33; break;
			  case 4: 
				  sc=sc+ 61; break;
			  case 5: 
				  sc=sc+101*t.coifTheme(); break;
				  // a la fin de chaque theme il aura le score des 5 niveau*coif de theme
				  //ex pour sante 101*4
			  }
			  return sc;
	  }
	  
	public int getNumSeq() {
		return this.numseq;
	}
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public String getMdp() {
		return this.mdp;
	}
	//cette methode pour incrementer la valeur de dernier niveau 
	public  void dernierNivIncr(String theme) {
		dernierniveau.replace(theme, dernierniveau.get(theme)+1);
	}
	public HashMap<String, Integer> getDernierniveau() {
		return dernierniveau;  
	}
	public void setPartieJeuRealise(PartieJeu p) {
		partieJeuRealise.add(p);
	}
	public List<PartieJeu> getPartieJeuRealise() {
		return partieJeuRealise;
	}
	//dans le cas ou il a perdu (il a depassé le nombre d'essaie dans le niveau )
	public void restartJoueur() {
		partieJeuRealise.clear();
		//pour enlever tt les parties realiser et les dernier niveau dans le cas d'echec
		for(ThemeJeu.theme t :ThemeJeu.theme.values() )
			dernierniveau.replace(t.toString(),0);
		//to set les dernier niveau a 0 
	}
	
}