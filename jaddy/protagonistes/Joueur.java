package protagonistes;
import plateau.*;

public class Joueur extends Combattant{

	private Piece localisationJoueur;
	private int localisationJoueurListe; //la position de la piece du joueur dans l'ArrayList
	private boolean aGagne; //pour savoir si le joueur a sorti du donjon
	//private Arme arme;
	//private Armure armure;

	public Joueur(String nom) {
		super(nom, 10); //par defaut le joueur a 10 nb de vie
		//par defaut le joueur commence dans la piece (1,1) qui est a l'indexe 0 de la liste des pieces
		this.localisationJoueurListe = 0;
		this.localisationJoueur = Donjon.piecesDonjon.get(this.localisationJoueurListe); //localiser le joueur dans la bonne piece cette methode get est propre au type ArrayList et retourne la Piece en donnant son indexe dans la liste
		this.aGagne = false;
	}																					
	
	@Override
	public String mourir() {
		// TODO Auto-generated method stub
		return null;
	}

	public Piece getLocalisationJoueur() {
		return this.localisationJoueur;
	}

	public void setLocalisationJoueur(Piece localisationJoueur) {
		this.localisationJoueur = localisationJoueur;
	}
	
	public boolean isaGagne() {
		return aGagne;
	}

	public void setaGagne(boolean aGagne) {
		this.aGagne = aGagne;
	}
	
	/*
	 * pour deplacer le joueur vers le nord ou le sud on incremente ou decremente de
	 * 1 dans la liste des pieces pour deplacer le joueur vers l'est ou le west on
	 * incremente ou decremente de Dimension dans la liste des pieces par exemple
	 * une piece de dimension 4 c'est a dire une matrice 4x4 les pieces sont placees
	 * dans la liste en commencant par la piece (1,1) a la position 0, puis la piece
	 * au nord cad (1,2) dans la prochaine position dans la liste cad 1 et ainsi de
	 * suite, la piece a l'est de la piece (1,1) cad (1,2) aura la position
	 * 0+dimension cad la position 4 dans la liste on ne craindra pas de depasser la liste
	 * car a chaque fois qu'on va se deplacer on verifie si il ya une porte dans la direction
	 * de notre deplacement, par exemple dans la salle (1,4)qui est une salle au plus nord du plateau
	 * le joueur ne pourra plus se deplacer de plus au nord car il n'ya pas de porte au nord de cette salle
	 */
	public String seDeplacer(Direction direction)
	{
		if(direction == Direction.NORD)
		{
			if(this.localisationJoueur.getPorteNord() != null && this.localisationJoueur.getPorteNord().isEstSortie()) // si le joueur attaeint la porte de sortie du Donjon
			{
				this.setaGagne(true);
				return "Felicitations, vous etes sortis du Donjon. Vous avez gagne le jeu!\n";
			}
			
			if(this.localisationJoueur.getPorteNord() == null)
				return "Vous avez atteint le nord max, impossible d'aller plus loin\n" + "Vous etes dans la piece (" + this.localisationJoueur.getPosition().getPosX() + ", " + this.localisationJoueur.getPosition().getPosY() + ")\n";
			else
				this.localisationJoueur = Donjon.piecesDonjon.get(++this.localisationJoueurListe);
		}
		
		if(direction == Direction.SUD)
		{
			if(this.localisationJoueur.getPorteSud() == null)
				return "Vous avez atteint le sud max, impossible d'aller plus loin\n" + "Vous etes dans la piece (" + this.localisationJoueur.getPosition().getPosX() + ", " + this.localisationJoueur.getPosition().getPosY() + ")\n";
			else
				this.localisationJoueur = Donjon.piecesDonjon.get(--this.localisationJoueurListe);
		}
		
		if(direction == Direction.EST)
		{
			if(this.localisationJoueur.getPorteEst() == null)
				return "Vous avez atteint le est max, impossible d'aller plus loin\n" + "Vous etes dans la piece (" + this.localisationJoueur.getPosition().getPosX() + ", " + this.localisationJoueur.getPosition().getPosY() + ")\n";
			else
				this.localisationJoueur = Donjon.piecesDonjon.get(this.localisationJoueurListe = this.localisationJoueurListe + Donjon.dimension);			
		}
		
		if(direction == Direction.WEST)
		{
			if(this.localisationJoueur.getPorteWest() == null)
				return "Vous avez atteint le west max, impossible d'aller plus loin\n" + "Vous etes dans la piece (" + this.localisationJoueur.getPosition().getPosX() + ", " + this.localisationJoueur.getPosition().getPosY() + ")\n";
			else
				this.localisationJoueur = Donjon.piecesDonjon.get(this.localisationJoueurListe = this.localisationJoueurListe - Donjon.dimension);
		}
		
		return "Vous etes dans la piece (" + this.localisationJoueur.getPosition().getPosX() + ", " + this.localisationJoueur.getPosition().getPosY() + ")\n";
	}

}
