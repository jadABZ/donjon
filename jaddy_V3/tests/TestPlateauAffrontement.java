package tests;
import plateau.*;
import protagonistes.*;
import java.util.Scanner;
import affrontement.Combat;
import vuePlateau.DonjonMatrice;

public class TestPlateauAffrontement {

	public static void main(String[] args) {
		Donjon donjon = new Donjon();

		Scanner scanP = new Scanner(System.in);
		Scanner scanNom = new Scanner(System.in);
		
		String p;
		
		System.out.println("Veuillez entre le nom de votre combattant: ");
		String nom = scanNom.nextLine();
		Joueur joueur = new Joueur(nom);
		System.out.println("Le courageux combattant " + joueur.getNom() + " penetre le donjon et doit atteindre la porte nord de la piece (4,4) pour sortir\n");
		
		DonjonMatrice vuePlateau = new DonjonMatrice(joueur);
		vuePlateau.afficherPlateau();
		
		System.out.println(joueur.statut());
		
		while(!joueur.isaGagne() && !joueur.isaPerdu()) // tant que le joueur n'a pas gagne ou perdu, lui demander un deplacement
		{
			System.out.println("Choisissez la direction de deplacement:\n nord: N\n sud: S\n ouest: O\n est: E\n afficher votre statut: autre touche\n");
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
			default:
				break;
			}	
			
			System.out.println(joueur.seDeplacer(directionDeplacement));
			vuePlateau.afficherPlateau();
			
			if(joueur.getLocalisationJoueurListe() != 0)
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
			
		}
	}
}
