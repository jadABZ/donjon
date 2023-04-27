package protagonistes;

public abstract class Combattant {

	private String nom;
	private int nbVie;
	private int forceAttaque;

	public Combattant(String nom, int nbVie) {
		super();
		this.nom = nom;
		this.nbVie = nbVie;
		this.forceAttaque = 1;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbVie() {
		return nbVie;
	}

	public void setNbVie(int nbVie) {
		this.nbVie = nbVie;
	}
	
	public int getForceAttaque() {
		return forceAttaque;
	}

	public void setForceAttaque(int forceAttaque) {
		this.forceAttaque = forceAttaque;
	}
	
	public abstract String mourir(); //monstre: est supprime de la piece, joueur: teminer le jeu
	
	public abstract String subirAttaque(Combattant adversaire);

	public String regagnerVie() //quand le joueur fuit le monstre regagne sa vie initiale et le joueur aussi; si le combat se termine sans fuite le vainqueur gagne un point de vie supllementaire
	{
		return "";
	}

}
