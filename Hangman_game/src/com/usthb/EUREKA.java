package com.usthb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import com.usthb.dessin.*;
import com.usthb.modeles.*;

public class EUREKA {
	private static  HashMap<Integer,Joueur> ensembleJ ;
	private static ArrayList<Question> listeQ;
	private static HashSet<ThemeJeu> listeTheme;//pour mettre la liste des theme 
	private static Joueur joueurActuel;
	
	public static void chargerHashMapArrayList() { 
		System.out.println("\t------chargerHashMapArrayList----\n");
		ensembleJ= ReadWrite.readHashMap();//pour lire le fichier 
		if (ensembleJ.size()==0) System.out.println("on a aucun Joueur");
		else System.out.println("on a "+ensembleJ.size()+" joueur\n les joueur dans le fichier sont:\n"+ensembleJ);//
		listeQ=ReadWrite.readQuestion();//pour lire les question 
		System.out.println("la liste des question est :");
		System.out.println(listeQ);//pour afficher la liste des question 
		//j'ai pas utilisé le \n sinn on aura 125 ligne 
		System.out.println("\t------End chargerHashMapArrayList----\n");
	}
	
	//cette classe pour cree la liste de theme et remplir le Linkdelist par des question de Type QuestionAdulte ou QuestionEnfant
	public static void chargerThemeHashset(String etat,ArrayList<Question> liste ){
		System.out.println("\t ----chargerThemeHashset----");
		listeTheme=new HashSet<ThemeJeu>(); // la liste des theme on aura 5
		ArrayList<Question> qsttheme=new ArrayList<Question>();//pour filtrer la liste des question en un seul type de question
		if(etat.equals("Adulte"))
			qsttheme=QuestionAdulte.getQstAdulte(liste);//on aura ques les question de type QuestionAdulte
		else
			qsttheme=QuestionEnfant.getQstEnfant(liste);//on aura ques les question de type QuestionEnfant
		for(ThemeJeu.theme t:ThemeJeu.theme.values())
			listeTheme.add(new ThemeJeu(t.toString(),qsttheme));//le linkedlist aura des question de meme type (comme tu as demandé)
		System.out.println("creation de hashset de theme pour "+etat+" est bien fait :");
		System.out.println(listeTheme);
		//j'ai pas utilisé le \n sinn on aura 125 ligne 
		System.out.println("\t ----FIN chargerThemeHashset----");
	}
	
	public static boolean SeConnecter(String user , String mdp) {
		boolean trouve = false;
		// pour separer le prenom et numero xxx.0000
		StringTokenizer st = new StringTokenizer(user,".");
		String [] donne = new String[st.countTokens()];
		int j =0;
		while(st.hasMoreTokens()) {
		 donne[j]=st.nextToken();
		 j++; //on aura donne[0] qui contient le prenom et donne[1] qui contient le numero
		}
		int numseq =Integer.parseInt(donne[1]);
		if (ensembleJ.containsKey(numseq)) {
			 if(donne[0].equals(ensembleJ.get(numseq).getPrenom()) && 
					 mdp.equals(ensembleJ.get(numseq).getMdp())) {
				 trouve = true;
				 joueurActuel=ensembleJ.get(numseq);
				 System.out.println("le joueur connecté est"+joueurActuel);
				// System.out.println("la liste des dernier niveau est:"+ensembleJ.get(numseq).dernierniveau);
				 System.out.println("la liste des dernier niveau est:"+joueurActuel.getDernierniveau());
				 System.out.println("la liste des partie est"+joueurActuel.getPartieJeuRealise());
				 chargerThemeHashset(joueurActuel.getClass().getSimpleName().toString(),listeQ);//pour creer la liste des theme+qst de theme
	}}		return trouve;
		 }
	
	
	public static void Inscription(String nom,String prenom,String mdp,Date d) {
		Singup.setNom_util_inscri(""+prenom+String.format(".%04d", ensembleJ.size()+1));
		if((2020-d.getYear())>=16)
			joueurActuel = new Adulte(nom,prenom,mdp,d,ensembleJ.size()+1);
		else 
			joueurActuel = new Enfant(nom,prenom,mdp,d,ensembleJ.size()+1);
		ensembleJ.put(joueurActuel.getNumSeq(), joueurActuel); //pour ajouter le nouveau joueur inscri 
		System.out.println("le nouveau joueur inscri est: "+joueurActuel);
		//pour la creation de hashset de theme
		 chargerThemeHashset(joueurActuel.getClass().getSimpleName().toString(),listeQ);
	}
	
	public static void saveQuitter() {//cette methode pour sauvgarder les donnés des joueur 
		ReadWrite.writeHashMap(ensembleJ);
		System.out.println("bien enregistrer");
	}
	public static Joueur getJoueur() {
		return joueurActuel;
	}
	public static void setJoueur(Joueur j) {
		joueurActuel=j;
	}
	public static HashMap<Integer,Joueur>  getEnsembleJ() {
		return ensembleJ;
	}
	public static HashMap<Integer, Joueur> getensembleJ() {
		return ensembleJ;
	}
	public static HashSet<ThemeJeu> getListeTheme() {
		return listeTheme;
	}
	
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre();//la fenetre qui contient les panel 
		f.refreshPanl(new Bienvenue().getPanel());//le premier panel a affichiers
		chargerHashMapArrayList();//pour charger le hashmap et le Arraylist		
	}
}