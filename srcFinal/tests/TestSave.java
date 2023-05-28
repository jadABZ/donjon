package tests;
import plateau.*;
import protagonistes.*;
import java.util.Scanner;
import affrontement.Combat;
import vuePlateau.DonjonMatrice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSave{

	private static Scanner scanPath;
	private static Scanner scanNom;

	public static void main(String[] args) {
		
		//pour sauvegarder le jeu et reprendre, il faut principalement conserver Joueur et Donjon
		
		//initialize donjon
		Donjon donjon = new Donjon();

		scanPath = new Scanner(System.in);
		scanNom = new Scanner(System.in);
		
		String path;
		
		//initializer Joueur
		Joueur joueur = new Joueur("");
		
		//voir si il ya une partie sauvgardee
		 String filePath = "./savegame.txt";
	     File file = new File(filePath); //cette variable sera aussi utilisee pour supprimer le dossier de sauvegarde lorsque le jeu est terminé

	        if (file.exists()) { //si le fichier de sauvegarde existe, on demarre cette partie
	        	try (FileInputStream fileIn = new FileInputStream("savegame.txt");
	   			    ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
	        		
	        		donjon = (Donjon) objectIn.readObject();
	   			    System.out.println("Game loaded successfully.");
	        		
	   			    joueur = (Joueur) objectIn.readObject();
	   			    System.out.println("Player loaded successfully.");		    
	   			
	   			} catch (Exception e) {
	   			    e.printStackTrace();
	   			}
	        	
	        	System.out.println("Content de vous revoir " + joueur.getNom() + "! Rappelle toi qu'il faut sortir de la porte nord de la piece (4,4) pour gagner\n");
	        }
		
	        else { //si le fichier de sauvegarde n'existe pas, on demarre une nouvelle partie partie
	        	System.out.println("Veuillez entre le nom de votre combattant: ");
	    		String nom = scanNom.nextLine();
	    		donjon = new Donjon();
	    		joueur = new Joueur(nom);
	    		System.out.println("Le courageux combattant " + joueur.getNom() + " penetre le donjon et doit atteindre la porte nord de la piece (4,4) pour sortir\n");
	        }
		
		
		
		DonjonMatrice vuePlateau = new DonjonMatrice(joueur);
		vuePlateau.afficherPlateau();
		
		System.out.println(joueur.statut());
		
		while(!joueur.isaGagne() && !joueur.isaPerdu()) // tant que le joueur n'a pas gagne ou perdu, lui demander un deplacement
		{
			System.out.println("Choisissez la direction de deplacement:\n nord: N\n sud: S\n ouest: O\n est: E\n afficher votre statut: autre touche\n");
			path = scanPath.next();
			Direction directionDeplacement = null;
			switch(path)
			{
			case "n":
			case "N":
				directionDeplacement = Direction.NORD;
				break;
			case "s":
			case "S":
				directionDeplacement = Direction.SUD;
				break;
			case "o":
			case "O":
				directionDeplacement = Direction.OUEST;
				break;
			case "e":
			case "E":
				directionDeplacement = Direction.EST;
				break;
			default:
				break;
			}	
			
			System.out.println(joueur.seDeplacer(directionDeplacement));
			vuePlateau.afficherPlateau();
			
			if(joueur.getLocalisationJoueur().getMonstre() != null) //dans la salle de debut il n'ya pas de monstre, et dans les salles ou le md les a supprime
			{
				if(joueur.getLocalisationJoueur().getMonstre().getNbVie() > 0)
				{
					System.out.println("Le courageux combattant " + joueur.getNom() + " va affronter le monstre " + joueur.getLocalisationJoueur().getMonstre().getNom() + "\n");
					
					Combat combat = new Combat(joueur, joueur.getLocalisationJoueur().getMonstre());
					combat.lancerCombat();
				}
				else
					System.out.println(joueur.getLocalisationJoueur().getMonstre().getNom() + " est vaincu, il n'y aura plus de combat dans cette piece\n");
				
			}
			
			//sauvegarder joueur
			try (FileOutputStream fileOut = new FileOutputStream("savegame.txt");
				    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
					objectOut.writeObject(donjon);
					System.out.println("Game saved successfully.");
				    objectOut.writeObject(joueur);  
				    System.out.println("Player saved successfully.");
				} catch (Exception e) {
				    e.printStackTrace();
				}	
		}
		//le jeu est termine, on supprime le dossier de sauvegarde pour demarrer un nouveau jeu après
		file.delete();
	}
}



