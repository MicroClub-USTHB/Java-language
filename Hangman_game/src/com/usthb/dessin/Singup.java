package com.usthb.dessin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.usthb.EUREKA;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Singup {

	private JTextField fnom;
	private JTextField fprenom;
	private JTextField jour ;
	private JTextField mois;
	private JTextField annee;
	private JPasswordField mdpi;
	private JButton Binscri;
	private JPanel f ;
	private static JTextField nom_util_inscri;
	
	public Singup() {
		 f = new JPanel();
		 f.setPreferredSize(Fenetre.dim);
		 f.setLayout(null);
		
		JLabel text_inscri = new JLabel("inscription");
		text_inscri.setFont(new Font("Dialog",Font.BOLD,26));
		f.add(text_inscri).setBounds(366, 32, 165, 43);
		
		fnom = new JTextField();
		f.add(fnom).setBounds(419, 131, 147, 30);
		
		fprenom = new JTextField();
		f.add(fprenom).setBounds(419, 173, 147, 32);
		
		JLabel tnom = new JLabel("NOM :");
		f.add(tnom).setBounds(351, 133, 50, 25);
		
		JLabel tprenom = new JLabel("PRENOM :");
		f.add(tprenom).setBounds(316, 175, 70, 25);
		
		JLabel tdate = new JLabel("Date de naissance : ");
		f.add(tdate).setBounds(255, 225, 147, 25);
		
		jour = new JTextField();
		f.add(jour).setBounds(420, 220, 40, 35);
		
		mois = new JTextField();
		f.add(mois).setBounds(482, 220, 40, 35);
		
		annee = new JTextField();
		f.add(annee).setBounds(541, 220, 50, 35);
		
		JLabel motdp = new JLabel("Mot De Passe :");
		f.add(motdp).setBounds(288, 268, 110, 35);
		
		mdpi = new JPasswordField();
		f.add(mdpi).setBounds(419, 273, 147, 30);
		
		JLabel lblNomDutilisateur = new JLabel("votre nom d'utilisateur:");
		lblNomDutilisateur.setVisible(false);
		f.add(lblNomDutilisateur).setBounds(230, 390, 171, 25);
		
		nom_util_inscri = new JTextField();
		f.add(nom_util_inscri).setBounds(419, 385, 147, 30);
		nom_util_inscri.setEditable(false);
		nom_util_inscri.setVisible(false);
		
		JButton validee = new JButton("valide");
		validee.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//on verefie si le joueur a entré tous les information
				if(fnom.getText().isEmpty() || fprenom.getText().isEmpty() || jour.getText().isEmpty() ||
						mois.getText().isEmpty() ||	annee.getText().isEmpty() || mdpi.getText().isEmpty())
					JOptionPane.showMessageDialog(null,
					          "veuillez remplir tous les champs obligatoires","", JOptionPane.PLAIN_MESSAGE);
				else 
					//on verifie si la date est juste
						if(checkDate(Integer.parseInt(jour.getText()),Integer.parseInt(mois.getText()),Integer.parseInt(annee.getText()))) {
						EUREKA.Inscription(fnom.getText(), fprenom.getText(), mdpi.getText()
							, getDatenaiss(Integer.parseInt(jour.getText())
							,Integer.parseInt(mois.getText()),Integer.parseInt(annee.getText())));
							lblNomDutilisateur.setVisible(true);
							nom_util_inscri.setVisible(true);
							validee.setVisible(false);
							Binscri.setVisible(true);
							}
						else {
							//Date incorrect
							JOptionPane.showMessageDialog(null,
							          "veuillez verifier la Date ","", JOptionPane.PLAIN_MESSAGE);
							jour.setText(""); mois.setText(""); annee.setText("");
					}}
		});
		validee.setBackground(new Color(47, 79, 79));
		f.add(validee).setBounds(410, 340, 123, 30);
		
		Binscri = new JButton("INSCRI");
		Binscri.setBackground(new Color(47, 79, 79));
		Binscri.setVisible(false);
		Binscri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Fenetre.refreshPanl(new Theme().getPanel());
			}
		});
		f.add(Binscri).setBounds(388, 439, 147, 35);
		
		Fenetre.refreshPanl(f);
}
	@SuppressWarnings("deprecation")
	Date getDatenaiss(int jour ,int mois, int annee) {
		return new Date(annee,mois,jour);
	}
	boolean checkDate(int dd, int mm, int yy) {
		//pour verifie si la date est correcte
		boolean corect =false;
	    if(yy>=1900 && yy<=2020)
	    	if(mm>=1 && mm<=12)
	    		 if((dd>=1 && dd<=31) && (mm==1 || mm==3 || mm==5 || mm==7 || mm==8 || mm==10 || mm==12))
	                 corect=true;
	             else if((dd>=1 && dd<=30) && (mm==4 || mm==6 || mm==9 || mm==11))
	                 corect=true;
	             else if((dd>=1 && dd<=28) && (mm==2))
	                 corect=true;
	             else if(dd==29 && mm==2 && (yy%400==0 ||(yy%4==0 && yy%100!=0)))
	                 corect=true;
	    return corect;
	    	
	    	 
	}
	public JPanel getPanel() {
		return this.f;
	}
	public static void setNom_util_inscri(String s) {//cette methode est utiliser dans la classe EUREKA pour setter le nom d'utilisateur
		nom_util_inscri.setText(s);
	}
	}