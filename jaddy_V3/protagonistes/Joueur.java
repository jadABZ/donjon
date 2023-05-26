package protagonistes;
import plateau.*;
import tresorerie.*;
import affrontement.*;

public class Joueur extends Combattant {

	public static int nbVieJoueur =10;
	public static final String emojiJoueur = "\uD83E\uDD3A"; // Imprime 🤺
	private Donjon donjon;
	private Piece localisationJoueur;
	private int localisationJoueurListe; //la position de la piece du joueur dans l'ArrayList
	private boolean aGagne; //pour savoir si le joueur a sorti du donjon
	private boolean aPerdu; //pour savoir quand terminer le jeu
	private Arme arme;
	private Armure armure;

	public Joueur(String nom, Donjon donjon) {
		super(nom, nbVieJoueur); //par defaut le joueur a 10 nb de vie
		this.donjon = donjon;
		//par defaut le joueur commence dans la piece (1,1) qui est a l'indexe 0 de la liste des pieces
		this.localisationJoueurListe = 0;
		this.localisationJoueur = this.donjon.piecesDonjon.get(this.localisationJoueurListe); //localiser le joueur dans la bonne piece cette methode get est propre au type ArrayList et retourne la Piece en donnant son indexe dans la liste
		this.aPerdu = false;
		this.aGagne = false;
	}																					

	public Piece getLocalisationJoueur() {
		return this.localisationJoueur;
	}

	public void setLocalisationJoueur(Piece localisationJoueur) {
		this.localisationJoueur = localisationJoueur;
	}
	
	public int getLocalisationJoueurListe() {
		return localisationJoueurListe;
	}

	public void setLocalisationJoueurListe(int localisationJoueurListe) {
		this.localisationJoueurListe = localisationJoueurListe;
	}

	public boolean isaGagne() {
		return aGagne;
	}

	public void setaGagne(boolean aGagne) {
		this.aGagne = aGagne;
	}
	
	public boolean isaPerdu() {
		return aPerdu;
	}

	public void setaPerdu(boolean aPerdu) {
		this.aPerdu = aPerdu;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	//pour afficher le statut du joueur(sa position, nb de vie tresors...)
	public String statut() {
		String fullStatut;
		String statutPosition = "Vous etes dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY()+")\n";
		String statutNbVie = "Vos points de de vie: " + this.getNbVie() + "\n";
		
		fullStatut = statutPosition + statutNbVie;
		
		if(this.armure != null)
		{
			String statutArmure="Votre armure: " + this.getArmure().getNom() + " | Protection: "+ ": +" + this.getArmure().getPointsProtection() + "\n";
			fullStatut +=statutArmure;
		}
		if(this.arme != null)
		{
			String statutArme="Votre arme: " + this.getArme().getNom() + " | Degats: " + ": x" + this.getArme().getDegats() + "\n";
			fullStatut += statutArme;
		}
		
		return fullStatut;
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
				return "Vous avez atteint le nord max, impossible d'aller plus loin\n" + statut() +"\n";
			else
				this.localisationJoueur = this.donjon.piecesDonjon.get(++this.localisationJoueurListe);
		}
		
		if(direction == Direction.SUD)
		{
			if(this.localisationJoueur.getPorteSud() == null)
				return "Vous avez atteint le sud max, impossible d'aller plus loin\n" + statut() + "\n";
			else
				this.localisationJoueur = this.donjon.piecesDonjon.get(--this.localisationJoueurListe);
		}
		
		if(direction == Direction.EST)
		{
			if(this.localisationJoueur.getPorteEst() == null)
				return "Vous avez atteint le est max, impossible d'aller plus loin\n" + statut() + "\n";
			else
				this.localisationJoueur = this.donjon.piecesDonjon.get(this.localisationJoueurListe = this.localisationJoueurListe + Donjon.dimension);			
		}
		
		if(direction == Direction.OUEST)
		{
			if(this.localisationJoueur.getPorteOuest() == null)
				return "Vous avez atteint le Ouest max, impossible d'aller plus loin\n" + statut() + "\n";
			else
				this.localisationJoueur = this.donjon.piecesDonjon.get(this.localisationJoueurListe = this.localisationJoueurListe - Donjon.dimension);
		}
		
		return statut();
	}
	
	public String sEquiper()
	{
		if(this.localisationJoueur.getTresor().getTypeTresor() == TypeTresor.ARME)
		{
			this.setArme((Arme) this.localisationJoueur.getTresor());
			return "Suite a cette victoire, le courageux " + this.getNom() + " a trouve l'arme " + this.getArme().getNom() + Arme.emojiArme + "(+" + this.getArme().getDegats() +")" + " et va s'en equiper\n";
		}

		this.setArmure((Armure) this.localisationJoueur.getTresor());
		return "Suite a cette victoire, le courageux " + this.getNom() + " a trouve l'armure " + this.getArmure().getNom() + Armure.emojiArmure + "(x" + this.getArmure().getPointsProtection() +") " +"et va s'en equiper\n";
	}
	
	@Override
	public String subirAttaque(Combattant monstre)
	{
		String subir = this.getNom() + " subit une violente attaque, ";
		
		if(this.armure != null && this.armure.getPointsProtection() - monstre.getForceAttaque() >= 0) //si il est equipe d'une armure
		{
			this.armure.setPointsProtection(this.armure.getPointsProtection() - monstre.getForceAttaque());
			subir += " mais il est protege par son armure " +this.armure.getNom() + ", il parvient a se relever";
			
			if(this.armure.getPointsProtection() <= 0)
			{
				this.armure = null;
				subir += " mais il perd son armure";
			}
			subir +="\n";
		}
			
		else
		{
			this.setNbVie(this.getNbVie() - monstre.getForceAttaque());
			if(this.getNbVie() > 0)
				subir += " mais il parvient a se relever\n";
			else
			{
				subir+= " trop violente pour survivre\n";
				mourir();
			}
		}
	
		return subir;
	}
	
	public String fuir() //quand le joueur fuit du combat il revient a la piece initial (1,1) et regagne tout ses pts de vie
	{
		//le monstre regagne tout ses points de vie
		this.localisationJoueur.getMonstre().setNbVie(5);
		String fuite = this.getNom() +  " a fuit du combat, il regagne sa vie mais son manque de courage le ramene a la piece de debut (1,1)\nEt le monstre " + this.localisationJoueur.getMonstre().getNom() + " regagne sa vie";
		this.localisationJoueurListe = 0;
		this.localisationJoueur = this.donjon.piecesDonjon.get(this.localisationJoueurListe);
		//this.regagnerVie(nbVieJoueur);
		this.setNbVie(Joueur.nbVieJoueur);
		return fuite;
	}
	
	@Override
	public String mourir() {
		
		this.aPerdu = true;
		return this.getNom() + " est mort\n";
	}

}
