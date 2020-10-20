package com.usthb.modeles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//j'ai ajoutté cette classe pour decomposer la classe euroka et la rendre petite

public class ReadWrite {

	public static void writeHashMap(HashMap<Integer,Joueur> listJ) {
		try {
			//change le path de fichier Joueur
			File f = new File("Joueurs.txt");///home/abd/eclipse-workspace/GestionEUREKA_RAMDANI_KESSIR/Joueurs.txt"
			f.delete();
			FileOutputStream fi = new FileOutputStream(f);
			ObjectOutputStream oi = new ObjectOutputStream(fi);
			oi.writeObject(listJ);
			oi.close();	
		}
		catch (FileNotFoundException e1) { System.out.println("File not found (writeHashMap)"); }
		//si l fichier est vide elle va nous afficher cette erreur
		catch (IOException e1) { System.out.println("Error initializing stream (writeHashMap)"); }
	}
	
	
	public static HashMap<Integer,Joueur> readHashMap() {
		System.out.println("\t---readhashmap");
		HashMap<Integer,Joueur> listeJ=new HashMap<Integer, Joueur>(); // pour qu'il return un hashmap vide 
		try {
			//change le path de fichier Joueur
			FileInputStream fi = new FileInputStream(new File("Joueurs.txt"));///home/abd/eclipse-workspace/GestionEUREKA_RAMDANI_KESSIR/Joueurs.txt
			ObjectInputStream oi = new ObjectInputStream(fi);
			listeJ=(HashMap<Integer, Joueur>) oi.readObject();
			oi.close();
			System.out.println("done!");
			
		}
		catch (FileNotFoundException e) { System.out.println("File not found (readHashMap)"); }
		catch (IOException e) { System.out.println("Error initializing stream (readHashMap)/le fichier est vide"); }
		catch (ClassNotFoundException e) { e.printStackTrace();}
		System.out.println("\t---END readhashmap");
		return(listeJ);
		
	}
	
	public static ArrayList<Question> readQuestion(){
		System.out.println("\t-----readQuestion-----");
		ArrayList<Question> liste= new ArrayList<Question>();
		File f = new File("Question.txt");//sinon le path /home/abd/eclipse-workspace/GestionEUREKA_RAMDANI_KESSIR/Question.txt
	     try {
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
			String strFile = scan.nextLine();
			StringTokenizer st= new StringTokenizer(strFile,";"); 
			while(st.hasMoreTokens()) {
				 String[] listQ = st.nextToken().split(":");
				 if(listQ[0].equals("Adulte")) 
					 liste.add(new QuestionAdulte(listQ[1],listQ[2],listQ[3],listQ[4],Integer.parseInt(listQ[5])));
				else
					 liste.add(new QuestionEnfant(listQ[1],listQ[2],listQ[3],listQ[4],Integer.parseInt(listQ[5])));
					 
				
				 
			} 
			}
			System.out.println("fichier QST bien lu");
			System.out.println("\t---------End ReadWrite");
			
		} catch (FileNotFoundException ee) {
			System.out.println("erreur au niveau de la lecture des question");
			ee.printStackTrace();//chemin de ee
			}
	   return liste;
		
	}
	

}