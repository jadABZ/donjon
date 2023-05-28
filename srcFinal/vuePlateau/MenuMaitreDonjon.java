package vuePlateau;

import java.util.Scanner;

import plateau.Direction;
import plateau.Donjon;
import protagonistes.MaitreDonjon;

public class MenuMaitreDonjon {

	private MaitreDonjon md;
	private Scanner scanPiece;
	private Scanner scanAction;
	private Scanner scanDegats;
	private Scanner scanProtection;
	private Scanner scanDirection;
	private Scanner scanDirection2;
	public MenuMaitreDonjon(MaitreDonjon md) {
		this.md = md;
	}

	public void presentationPieces() //presenter les pieces et deplacer le md dans la piece choisie
	{
		String res = "Veuillez choisir la piece pour effectuer des changements:\n";
		Integer numList = 1;
		for(Integer y = 1; y<=Donjon.dimension; y++)
			for(Integer x = 1; x<=Donjon.dimension; x++, numList++)
			{
				res += numList.toString() + ": (" + x.toString() + ", " + y.toString() + ")\n";
			}
		System.out.println(res);
		
		scanPiece = new Scanner(System.in);
		int choix;
		do
		{
			choix = scanPiece.nextInt();
			if(choix < 0 && choix >numList)
				System.out.println("vous devez entrer un nombre qui correspond a une piece veuillez ressayer\n");
		}
		while(choix < 0 && choix >numList);
		
		md.accederPiece(choix);
	}
	
	public void choixAction() //choisir et effectuer une action du md
	{
		System.out.println("Choisissez une option:\n ajouter monstre: A\n supprimer monstre: B\n ajouter arme: C\n ajouter armure: D\n supprimer tresor: E\n activer porte: F\n supprimer Porte: G\n abandon: autre touche\n");
		
		scanAction = new Scanner(System.in);
		String c = scanAction.next();
		switch(c)
		{
		case "a":
		case "A":
			System.out.println(md.ajouterMonstre());
			break;
		case "b":
		case "B":
			System.out.println(md.supprimerMonstre());
			break;
		case "c":
		case "C":
		{
			System.out.println("Veulliez entrer le nombre de degats de l'arme: ");
			scanDegats = new Scanner(System.in);
			int degats;
			do {
			degats = scanDegats.nextInt();
			if(degats <0 && degats >6)
				System.out.println("Un degat doit etre comprise entre 1 et 5 veulliez reessayer");
			}while(degats <0 && degats >6);
			
			System.out.println(md.ajouterArme(degats));
		}
			break;
		case "d":
		case "D":
		{
			System.out.println("Veulliez entrer le nombre de protection de l'armure: ");
			scanProtection = new Scanner(System.in);
			int protection;
			do {
			protection = scanProtection.nextInt();
			if(protection <0 && protection >6)
				System.out.println("Une protection doit etre comprise entre 1 et 5 veulliez reessayer");
			}while(protection <0 && protection >6);
			
			System.out.println(md.ajouterArmure(protection));
		}
			break;
		case "e":
		case "E":
			System.out.println(md.supprimerTresor());
			break;
		case "f":
		case "F":
		{
			System.out.println("Veulliez entrer la direction de la porte dans la salle\n nord: N\n sud: S\n ouest: O\n est: E\n abandon: autre touche");
			scanDirection = new Scanner(System.in);
			String direction;
			direction = scanDirection.next();
			Direction directionDeplacement = null;
			switch(direction)
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
			
			System.out.println(md.activerPorte(directionDeplacement));
		}
			break;
		case "g":
		case "G":
		{
			System.out.println("Veulliez entrer la direction de la porte dans la salle\n nord: N\n sud: S\n ouest: O\n est: E\n abandon: autre touche");
			scanDirection2 = new Scanner(System.in);
			String direction;
			direction = scanDirection2.next();
			Direction directionDeplacement = null;
			switch(direction)
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
			
			System.out.println(md.desactiverPorte(directionDeplacement));
		}
			break;
		default:
			break;
		}
		
	}
}
