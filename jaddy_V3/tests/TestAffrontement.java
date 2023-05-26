package tests;
import plateau.*;
import affrontement.*;
import protagonistes.*;
import java.util.Scanner;

public class TestAffrontement {

	public static void main(String[] args) {
		
		Donjon donjon = new Donjon();
		
		Scanner scanNom = new Scanner(System.in);
		System.out.println("Veuillez entre le nom de votre combattant: ");
		String nom = scanNom.nextLine();
		Joueur joueur = new Joueur(nom);
		Monstre monstre = new Monstre("Goro");
		System.out.println("Le courageux combattant " + joueur.getNom() + " va affronter le monstre " + monstre.getNom() + "\n");
		
		Combat combat = new Combat(joueur, monstre);
		combat.lancerCombat();
				
	}

}
