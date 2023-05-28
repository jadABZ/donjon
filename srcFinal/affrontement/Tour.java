package affrontement;
import protagonistes.*;
import java.util.Random;

public class Tour {

	private Joueur joueur;
	private Monstre monstre;
	
	public Tour(Joueur joueur, Monstre monstre) {
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
	
	public String lancerTour()
	{
		String resultatTour = "Un tour a commence entre " + this.joueur.getNom() + " et " + this.monstre.getNom()+"\n";
		
		//generer un int aleatoire entre 0 inclusif et 2 exclusif
		//donc genrer un int aleatoirement entre 0 et 1
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		
		//en fonction du randomInt obtenu on choisi qui subit l'attaque
		if(randomNumber == 0)
			resultatTour += joueur.subirAttaque(monstre) + Monstre.emojiMonstre + "\u27A1\uFE0F" + Joueur.emojiJoueur + "\n";
		else
			resultatTour += monstre.subirAttaque(joueur) + Monstre.emojiMonstre + "\u2190\uFE0F" + Joueur.emojiJoueur + "\n";
		
		resultatTour += "Pts de vie restantes de " + joueur.getNom() + ": " +joueur.getNbVie()+" " ;
		if(joueur.getArmure()!=null && joueur.getArmure().getPointsProtection()>0)//si le joueur possede une armure afficher 
			resultatTour += " Armure: +" + joueur.getArmure().getPointsProtection();
		
		resultatTour += "\nPts de vie restantes de " + monstre.getNom() + ": " +monstre.getNbVie()+"\n";
		
		return resultatTour;
	}

}
