package tests;
import plateau.*;
import protagonistes.*;
import java.util.Scanner;

public class TestPlateau {

	public static void main(String[] args) {
		Donjon donjon = new Donjon(4);

		Scanner scanP = new Scanner(System.in);
		Scanner scanNom = new Scanner(System.in);
		
		int p;
		
		System.out.println("Veuillez entre le nom de votre combattant: ");
		String nom = scanNom.nextLine();
		Joueur joueur = new Joueur(nom);
		System.out.println("Le courageux combattant " + joueur.getNom() + " penetre le labyritnhe et doit chercher une sortie\n");
		System.out.println("Vous etes dans la piece (" + joueur.getLocalisationJoueur().getPosition().getPosX() + ", " + joueur.getLocalisationJoueur().getPosition().getPosY() + ")\n");
		
		while(!joueur.isaGagne()) // tant que le joueur n'a pas gagne, lui demander un deplacement
		{
			System.out.println("Choisissez la direction de deplacement: N:1 S:2 W:3 E:4\n");
			p = scanP.nextInt();
			Direction directionDeplacement = null;
			switch(p)
			{
			case 1:
				directionDeplacement = Direction.NORD;
				break;
			case 2:
				directionDeplacement = Direction.SUD;
				break;
			case 3:
				directionDeplacement = Direction.WEST;
				break;
			case 4:
				directionDeplacement = Direction.EST;
				break;
			}	
			
			System.out.println(joueur.seDeplacer(directionDeplacement)); 
		}
	}

}
