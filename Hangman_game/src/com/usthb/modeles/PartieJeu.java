package com.usthb.modeles;

import java.io.Serializable;
import javax.swing.JOptionPane;

import com.usthb.EUREKA;
import com.usthb.dessin.Fenetre;
import com.usthb.dessin.Pendu;
import com.usthb.dessin.Theme;

public class PartieJeu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int scorePartie;
	private final int numPartie;
	private String libelle;//elle contier le id de la question car on a besoin le dernier char 
	private String themePartie;
	private StringBuffer repCourantePartie;
	private String reponsePartie;
	
	public PartieJeu(Question q ) {
		this.libelle=q.getNumQst();
		this.reponsePartie=q.getReponse();
		numPartie=EUREKA.getJoueur().getPartieJeuRealise().size()+1;
		this.scorePartie=EUREKA.getJoueur().getTotalScore();
		for(ThemeJeu.theme t:ThemeJeu.theme.values() ) 
			if(q.getNumQst().charAt(0)==t.toString().charAt(0))
				this.themePartie=t.toString();
	}
	@Override
	public String toString() {
		return "Partie numero:"+this.numPartie+" ,theme:"+this.themePartie+" ,question Id:"+this.libelle;
	}
	
	//pour inistialiser les ** dans la case de reponse + question dans le pendu
	public String PenduInitialisationRep(Question q) {
		repCourantePartie=new  StringBuffer();
		for(char c :reponsePartie.toCharArray()) {
			if(c=='\'' || c=='/'||  c=='%' ||c ==' '||c =='-'||c =='_') repCourantePartie.append(c);
			else repCourantePartie.append("*");
		}
		return new String(repCourantePartie);//la reponse en ***
		
			}
		
		public void checkCaractère(char c) {
			boolean trouve = false;
			for(int i =0 ; i< reponsePartie.length(); i++) {
				if (reponsePartie.toLowerCase().charAt(i) == c) {
					repCourantePartie.setCharAt(i, reponsePartie.charAt(i));
	                trouve = true;
	                Pendu.setReponsetrouver(new String(repCourantePartie));//pour modifier la rep en ***
	               }
		}
			if(!trouve) {
				Pendu.ImagePendu.incermantEtat(); //pour modifier le pendu
				Pendu.ImagePendu.repaint();
				if(Pendu.ImagePendu.getetat()==8) {
					System.out.println("vous avez perdu");
					JOptionPane.showMessageDialog(null,
					          "Vous avez perdu la partie"+libelle.charAt(4)
					           + "\nla reponse etait : "+Pendu.partieactuel.reponsePartie,
					          "Partie Perdu", JOptionPane.PLAIN_MESSAGE);
						int x=Integer.parseInt(String.valueOf(libelle.charAt(4)));//numero de la question dans le niveau
						if(x==EUREKA.getJoueur().NombreDessaie()) {//PERDU DE JEU si x==nombre d'essaie ex 3 pour enfant
							JOptionPane.showMessageDialog(null,"Vous Avez Perdu le Jeux"
									+ "\n votre score totale est"+this.scorePartie,
							          "Game Perdu", JOptionPane.PLAIN_MESSAGE);
							EUREKA.getJoueur().restartJoueur();
							Fenetre.refreshPanl(new Theme().getPanel());
							
						}
						else { 
							Pendu.initialiserPartie();
							JOptionPane.showMessageDialog(null,"Il vous reste "
							+(EUREKA.getJoueur().NombreDessaie()-x)+" chance",
							          "Nombre de chance restant", JOptionPane.PLAIN_MESSAGE);
						}
				}
				
			}
			else {//la char est juste
				if(reponsePartie.equals (new String(repCourantePartie))) {
					Pendu.ImagePendu.setTrouve(true);
					 JOptionPane.showMessageDialog(null,
					          "Vous avez gagné le niveau"+libelle.charAt(3),
					          "Bravo ", JOptionPane.PLAIN_MESSAGE);
					EUREKA.getJoueur().dernierNivIncr(Theme.getTheme().toUpperCase());
					//on doit verifie si il a completé les niveau de theme donc il est dans li niveau 5
					if(EUREKA.getJoueur().getDernierniveau().get(Theme.getTheme())==5) {
						JOptionPane.showMessageDialog(null,
						          "Vous avez Completé le Theme:"+Theme.getTheme()+""
						          + "\n vous avez gagne 101*"+ThemeJeu.theme.valueOf(Theme.getTheme()).coifTheme()+" points",
						          "Theme "+Theme.getTheme()+" Gagné ", JOptionPane.PLAIN_MESSAGE);
						Fenetre.refreshPanl(new Theme().getPanel());
					}
					else {//else il etait dans un niveau <5
					Pendu.initialiserPartie();
					Pendu.ImagePendu.repaint();
					Pendu.setScore(EUREKA.getJoueur().getTotalScore()); 
					}
				}
			}
		}
	public String getThemePartie() {
		return this.themePartie;
	}
	public String getNumQstPartie() {
		return libelle;
	}
	}