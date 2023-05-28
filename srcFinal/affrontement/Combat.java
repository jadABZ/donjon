package affrontement;
import protagonistes.*;
import java.util.Scanner;

public class Combat {

	private Joueur joueur;
	private Monstre monstre;
	private Scanner scan;
	
	public Combat(Joueur joueur, Monstre monstre) {
		super();
		this.joueur = joueur;
		this.monstre = monstre;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public void lancerCombat()
	{
		System.out.println("Le combat va commencer entre " + this.joueur.getNom() + " et " + this.monstre.getNom());
		System.out.println(Monstre.emojiMonstre + " VS " + Joueur.emojiJoueur);
		
		String choix;
		scan = new Scanner(System.in);
		
		while(joueur.getNbVie() > 0 && monstre.getNbVie() > 0)
		{
			Tour tour = new Tour(this.joueur, this.monstre);
			System.out.println(tour.lancerTour()); 
			
			if(joueur.getNbVie() > 0 && monstre.getNbVie() > 0)
			{
				
				System.out.println("Voulez vous continuer le combat ou fuir?");
				System.out.println(" Fuir: f\n Continuer: n'importe quelle autre touche");
				choix = scan.next();
				
				if(choix.equals("f") || choix.equals("F"))
				{
					System.out.println(joueur.fuir());
					break;
				}
			}
			
		}
		
		if(joueur.getNbVie() <=0)
		{
			System.out.println(joueur.mourir());
			System.out.println(monstre.getNom() + " a gagne le combat!\n"); 
			System.out.println("Malheureusement " + joueur.getNom() + " n'a pas pu survivre le donjon\nJeu termine");
		}
		
		if(monstre.getNbVie() <=0)
		{
			System.out.println(monstre.mourir()) ;
			System.out.println(joueur.getNom() + " a gagne le combat!\n");
			System.out.println(joueur.sEquiper());
		}
		
	}
}
