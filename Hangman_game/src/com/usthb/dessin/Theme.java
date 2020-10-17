package com.usthb.dessin;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.usthb.EUREKA;
import com.usthb.modeles.ThemeJeu;



public class Theme {
	private static String themeSelectione;
	private JTextField scoreA;
	private Choice listtheme;
	private JButton butcommencerq;
	private JPanel f ;
	
	
	public Theme() {
		
		f = new JPanel();
		f.setPreferredSize(Fenetre.dim);
		f.setLayout(null);
		
		JLabel lblScore = new JLabel("SCORE :");
		lblScore.setFont(new Font("Dialog", Font.BOLD, 15));
		f.add(lblScore).setBounds(638, 39, 67, 47);
		
		scoreA = new JTextField();
		scoreA.setText(""+EUREKA.getJoueur().getTotalScore());
		scoreA.setFont(new Font("Dialog", Font.PLAIN, 15));
		scoreA.setEditable(false);
		f.add(scoreA).setBounds(713, 46, 80, 33);
		
		ImageIcon aa = new ImageIcon("Images/Theme.png");//to change
		JLabel labelimage = new JLabel(aa,JLabel.CENTER);
		f.add(labelimage).setBounds(277, 108, 338, 240);
		
		JLabel lblChoisiUnTheme = new JLabel("choisi un theme : ");
		lblChoisiUnTheme.setFont(new Font("Dialog", Font.BOLD, 14));
		f.add(lblChoisiUnTheme).setBounds(258, 352, 158, 47	);
		
		butcommencerq = new JButton("commencer");
		butcommencerq.setBackground(new Color(47, 79, 79));
		f.add(butcommencerq).setBounds(421, 424, 120, 33);
		butcommencerq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				themeSelectione= listtheme.getSelectedItem().toString();
				System.out.println("le theme selectioné est :"+themeSelectione);
				Pendu p = new Pendu();
				p.initialiserPartie();//initialisation de la partie 
				Fenetre.refreshPanl(p.getPanel());
			}
		});
		
		listtheme= new Choice();
		  listtheme.setBackground(Color.white);
			listtheme.setBounds(433, 352, 150, 33);
			//pour ne pas remplir les theme que le joueur a completé
			for(ThemeJeu.theme t :ThemeJeu.theme.values())
				if(EUREKA.getJoueur().getDernierniveau().get(t.toString())<5)
					listtheme.add(t.toString());
			f.add(listtheme);		
			if(listtheme.countItems()==0) {
				 JOptionPane.showMessageDialog(null,"Bravo "+EUREKA.getJoueur().getPrenom()
				 		+ "\nVous avez complété le jeux"
				 		+ "\nVotre score est "+EUREKA.getJoueur().getTotalScore(),
				          "GAME END", JOptionPane.PLAIN_MESSAGE);
				 butcommencerq.setVisible(false);
			}
			
		
		Fenetre.refreshPanl(f);
	}
	
	public JPanel getPanel() {
		return this.f;
	}
	public static String getTheme() {//j'utilise cette valeur dans les classe d'autre package(PartieJeu Pendu)
		return themeSelectione;
	}
	
}