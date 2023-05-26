package tests;
import plateau.*;
import protagonistes.*;
import java.util.Scanner;

public class TestPlateau {

	public static void main(String[] args) {
		Donjon donjon = new Donjon();

		Scanner scanP = new Scanner(System.in);
		Scanner scanNom = new Scanner(System.in);
		
		String p;
		
		System.out.println("Veuillez entre le nom de votre combattant: ");
		String nom = scanNom.nextLine();
		Joueur joueur = new Joueur(nom);
		System.out.println("Le courageux combattant " + joueur.getNom() + " penetre le labyritnhe et doit chercher une sortie\n");
		System.out.println("Vous etes dans la piece (" + joueur.getLocalisationJoueur().getPosition().getPosX() + ", " + joueur.getLocalisationJoueur().getPosition().getPosY() + ")\n");
		
		while(!joueur.isaGagne()) // tant que le joueur n'a pas gagne, lui demander un deplacement
		{
			System.out.println("Choisissez la direction de deplacement: N: nord S: sud O: ouest E: est\n");
			p = scanP.next();
			Direction directionDeplacement = null;
			switch(p)
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
			}	
			
			System.out.println(joueur.seDeplacer(directionDeplacement)); 
		}
	}
}
