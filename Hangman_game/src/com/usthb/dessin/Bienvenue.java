package com.usthb.dessin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.usthb.EUREKA;

public class Bienvenue {

	 private JTextField nom_util;
	 private JPasswordField mdp_util;
	 private JButton connecteB;
	 private JButton inscrivez_vous;
	 JPanel f;
	 public Bienvenue() {
		 	f = new JPanel();
			f.setPreferredSize(Fenetre.dim);
			f.setLayout(null);
			
			JLabel text_1 = new JLabel("Bienvenue dans EUROKA");
			text_1.setFont(new Font("Dialog", Font.BOLD, 24));
			f.add(text_1).setBounds(280, 32, 337, 34);
			
			JLabel lblVousAvezDeja = new JLabel("Vous avez deja un compte ");
			lblVousAvezDeja.setFont(new Font("Dialog", Font.BOLD, 15));
			f.add(lblVousAvezDeja).setBounds(476, 134, 304, 53);
			
			JLabel lblNom = new JLabel("Nom d'utilisateur :");
			f.add(lblNom).setBounds(445, 193, 161, 34);
			
			JLabel lblMotDe = new JLabel("Mot de passe :");
			f.add(lblMotDe).setBounds(476, 239, 117, 27);
			

			nom_util = new JTextField();
			f.add(nom_util).setBounds(588, 197, 148, 27);
			
			
			mdp_util = new JPasswordField();
			f.add(mdp_util).setBounds(588, 239, 148, 27);
			
			connecteB = new JButton("Connexion");
			connecteB.setBackground(new Color(47, 79, 79));
			connecteB.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					//si il a pas rempi les 2 casse on affiche un message
					if(nom_util.getText().isEmpty() || mdp_util.getText().isEmpty())
						JOptionPane.showMessageDialog(null,
						          "Veulliez verifier les données entrer","", JOptionPane.PLAIN_MESSAGE);
					else	//on verifie le mdp et nom 
						if(EUREKA.SeConnecter(nom_util.getText(), mdp_util.getText())) {
								Fenetre.refreshPanl(new Theme().getPanel());
						JOptionPane.showMessageDialog(null,
						          "Hey Again , Enjoy Playing!",
						          "Bienvenue", JOptionPane.PLAIN_MESSAGE);}
								
						else {//dans le cas ou le nom ou mdp est incorrect 
							 JOptionPane.showMessageDialog(null,
							          "Votre Nom d'Utilisateur ou Mot De Passe est incorect\n"
							          + "si vous n'avez pas de compte inscrivez-vous ",
							          "Mot de passe ou nom d'utilisateur incorrect", JOptionPane.PLAIN_MESSAGE);	
							nom_util.setText("");
							mdp_util.setText("");
						}
				}
			});
			f.add(connecteB).setBounds(628, 278, 108, 27);
			
			JLabel lblVousNavezPas = new JLabel("Vous n'avez pas de compte ?");
			lblVousNavezPas.setFont(new Font("Dialog", Font.BOLD, 14));
			f.add(lblVousNavezPas).setBounds(482, 334, 265, 53);
			
			JLabel lblCestRapideEt = new JLabel("C’est rapide et facile.");
			f.add(lblCestRapideEt).setBounds(530, 370, 167, 29);
			
			inscrivez_vous = new JButton("inscrivez vous");
			inscrivez_vous.setFont(new Font("Dialog", Font.BOLD, 9));
			inscrivez_vous.setBackground(new Color(47, 79, 79));
			inscrivez_vous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//pour creer la fenetre d'inscription 
					Fenetre.refreshPanl(new Singup().getPanel());
				}
			});
			f.add(inscrivez_vous).setBounds(550, 399, 108, 34);
			ImageIcon aa = new ImageIcon("Images/bienvenue.jpg");
			JLabel labelimage = new JLabel(aa,JLabel.CENTER);
			f.add(labelimage).setBounds(62, 157, 288, 273);
			Fenetre.refreshPanl(f);
		}
	 
	 public JPanel getPanel() {
		 return this.f;
	 }
}