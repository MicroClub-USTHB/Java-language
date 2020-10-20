package com.usthb.dessin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.usthb.EUREKA;
import com.usthb.modeles.PartieJeu;
import com.usthb.modeles.Question;

public class Pendu {

	private static JTextField Score; 
	private static JTextField CaractereRep; //
	private JLabel ScoreGame;
	private static JPanel questionPanel;
	private static JLabel Questionlabel ;//
	private static JTextField Reponsetrouver;//
	private JPanel panelPendu;
	private static JLabel levelGame ;
	private Dimension imgdim ;
	private static JPanel gamePanel ;
	public static Potence ImagePendu;
	private static String imagePath;
	public static PartieJeu partieactuel;
	private static JButton retourMenu;
	private static ImageIcon imageQst;
	private static JLabel imagelabel;
	private static boolean save;
	
	public Pendu() {
	
		gamePanel = new JPanel();
		gamePanel.setPreferredSize(Fenetre.dim);
		gamePanel.setLayout(null);
		
		Score = new JTextField();
		Score.setText("0000");
		Score.setFocusable(false);
		Score.setEditable(false);
		gamePanel.add(Score).setBounds(756, 24, 130, 28);
		
		 ScoreGame = new JLabel("Score :");
		 gamePanel.add(ScoreGame).setBounds(689, 23, 64, 28);
		
		//on ajute une image ou une question dans cette JLabel
		 questionPanel= new JPanel(new BorderLayout(1,2));
		 gamePanel.add(questionPanel).setBounds(112, 64, 668, 192);
		 
		 //dans le panel on ajoute une image et une question
		 Questionlabel = new JLabel("QuestionLabel");
		 Questionlabel.setPreferredSize(new Dimension(656, 20));
		 Questionlabel.setHorizontalAlignment(JLabel.CENTER);
		 questionPanel.add(Questionlabel,BorderLayout.SOUTH);
		 //ou ajoute une image de question avec la methode setgame 
		 imagePath="on ajoute un path";
		imageQst = new ImageIcon(imagePath);
		imagelabel =new JLabel(imageQst);
		questionPanel.add(imagelabel,BorderLayout.CENTER);
		 
		 
		JLabel lblReponse = new JLabel("Reponse :");
		lblReponse.setFont(new Font("Dialog", Font.BOLD, 14));
		gamePanel.add(lblReponse).setBounds(188, 283, 88, 47);
		
		CaractereRep = new JTextField();
		gamePanel.add(CaractereRep).setBounds(310, 290, 94, 33);	
		CaractereRep.requestFocus(); 
		CaractereRep.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(!save) {
					//quand il entre le premier caractere la partie commence
					EUREKA.getJoueur().setPartieJeuRealise(partieactuel); 
					retourMenu.setVisible(false);
					save=true;
				}
				String s = CaractereRep.getText();
				char c = s.charAt(0);
				CaractereRep.setText("");
				partieactuel.checkCaractère(c);
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		 Reponsetrouver = new JTextField("**f**f*f*");
		 Reponsetrouver.setEditable(false);
		Reponsetrouver.setFont(new Font("Dialog", Font.BOLD, 18));
		Reponsetrouver.setHorizontalAlignment(JTextField.CENTER);
		gamePanel.add(Reponsetrouver).setBounds(277, 335, 162, 41);
		Reponsetrouver.setFocusable(false);
		
		panelPendu = new JPanel();
		panelPendu.setFocusable(false);
		 gamePanel.add(panelPendu).setBounds(525, 268, 228, 212);
		 imgdim =  new Dimension(panelPendu.getWidth(),panelPendu.getHeight());
		 
		 ImagePendu = new Potence();
		 ImagePendu.setPreferredSize(imgdim);
		 ImagePendu.setFocusable(false);
		 panelPendu.add(ImagePendu,BorderLayout.CENTER);
		 
		levelGame = new JLabel("Level: X ");
		levelGame.setFont(new Font("Dialog", Font.BOLD, 20));
		levelGame.setHorizontalAlignment(JLabel.CENTER);
		levelGame.setFocusable(false);
		gamePanel.add(levelGame).setBounds(196, 19, 450, 28);
		
		retourMenu= new JButton("Retour");//pour revenir a la fenetre de theme 
		retourMenu.setBackground(new Color(47, 79, 79));
		retourMenu.setFont(new Font("Dialog", Font.BOLD, 12));
		retourMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fenetre.refreshPanl(new Theme().getPanel());
			}
		});
		gamePanel.add(retourMenu).setBounds(46, 478, 113, 33);
		
		Fenetre.refreshPanl(gamePanel);
		}

	public JPanel getPanel() {
		return gamePanel;
	}
	//pour creer la question et la nouvelle partie 
	public static void initialiserPartie() {
		System.out.println("\t--------- pendu initialiserPartie----------");
		Question q =EUREKA.getJoueur().Jouer(Theme.getTheme());//elle nous rends la question
		partieactuel= new PartieJeu(q);
		System.out.println("la partie cree est:"+partieactuel);
		setGame(q,partieactuel);
		System.out.println("\t---------End pendu initialiserPartie----------");
	}
	//to set les textfield .. de pendu apres la creation de la partie et la question 
	public static void setGame(Question q,PartieJeu p) {
		Reponsetrouver.setText(p.PenduInitialisationRep(q));//to set ****
		levelGame.setText("THEME:"+p.getThemePartie()+"Niveau:"+q.getniveau()+"/5");
		Questionlabel.setText(q.getQuestion());
		Pendu.imagePath=q.imagepath();
		if(imagePath.length()>0) {//si la question contient une image
			questionPanel.remove(imagelabel);
			imageQst = new ImageIcon(imagePath);
			imagelabel =new JLabel(imageQst);
			questionPanel.add(imagelabel,BorderLayout.CENTER);
			}
		 //pour enlever l'ancien image
		else imagelabel.setVisible(false);
		retourMenu.setVisible(true);//on l'enleve juste quand le player commence la partie en entrant un char
		Score.setText(""+EUREKA.getJoueur().getTotalScore());
		ImagePendu.restart();
		save=false;
		gamePanel.repaint();
	}
	public static void setScore(int i) {
		Score.setText(""+i);
	}
	public static void setReponsetrouver(String s) {//pour changer les * avec le caravtere trouvé
		Reponsetrouver.setText(s);
	}
	
	}

