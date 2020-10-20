package com.usthb.dessin;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.usthb.EUREKA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Fenetre extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar ;
	private JMenu m;
	private JMenu quitte;
	private JMenuItem help ;
	private JMenuItem apropos;
	private JMenuItem players;
	private JMenuItem quitter;
	static Dimension dim;
	static JPanel panel = new JPanel() ;
	
	public Fenetre(){ 
		super("EUROKA");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null); //POUR CENTRER DANS l'ECRAN
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.setResizable(false);
		dim = new Dimension(this.getWidth(), this.getHeight());
		panel.setPreferredSize(dim);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		menubar = new JMenuBar();
		m = new JMenu("Eureka");
		quitte=new JMenu("Quitter");
		menubar.add(m);
		
		menubar.add(quitte);
		help = new JMenuItem("HELP(?)");
		help.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e){
			  JOptionPane.showMessageDialog(null,
			          "les regles de jeux sont simple : \n quend vous commencez le jeux vous devez choisir un theme "
			          + "\ndans chaque theme il y'a 5 niveau "
			          + "\npour gagne le niveau vous devez trouvé la bonne reponse pour passer au niveau suivant"
			          + "\nvous gagnez un nombre de point apres chaque niveau gagné "
			          + "\na la fin d'un theme vous aurez le score des niveau multiplié par un coif associé au theme"
			          + "\nla partie commence quand vous entrez un caractere dans l'espace rèservé"
			          ,"LES REGLES DE JEUX", JOptionPane.PLAIN_MESSAGE);
		  	}
			  
				}  );
	  
		apropos = new JMenuItem("A PROPOS");
		apropos.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e){
			  JOptionPane.showMessageDialog(null,
			          "Version : 0.0.1\n Maker : Abd & Ouassim \n Date de creation : Avril 2020",
			          "A PROPOS", JOptionPane.INFORMATION_MESSAGE);
		  	}
			}  );
		players = new JMenuItem("PLAYERS");
		players.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e){
			  StringBuffer s = new StringBuffer();
			  s.append("le nombre des joueurs inscri est :"+EUREKA.getEnsembleJ().size()+"\n");
			  for(int i=0; i<EUREKA.getensembleJ().size();i++)
				  s.append((i+1)+" : "+EUREKA.getensembleJ().get(i+1));
			  JOptionPane.showMessageDialog(null,s,
			          "La liste des Joueurs", JOptionPane.PLAIN_MESSAGE);
			  
		  	}
			}  );
			
		quitter = new JMenuItem("QUITTER");
		quitter.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			EUREKA.saveQuitter(); //pour sauvgarder les joueurs
			JOptionPane.showMessageDialog(null,
			          "See you next Time!",
			          "AU revoid", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
			System.out.println("joueur enregistrer");
				}
			});
	
		m.add(help);
		m.add(apropos);	
		m.addSeparator(); 
		m.add(players);
		quitte.add(quitter);
	this.setJMenuBar(menubar);
	}
	
	//cette methode pour changer les panel 
	public static void refreshPanl(JPanel p ) {
		panel.removeAll();
		panel.add(p,BorderLayout.CENTER);
		panel.revalidate();
	}
	
	}