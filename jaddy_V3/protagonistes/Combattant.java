package protagonistes;

import java.io.Serializable;

public abstract class Combattant implements Serializable {

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

	/* cette methode c'est pour quand le joueur fuit le
	 * monstre regagne sa vie initiale et le joueur aussi si le combat se termine
	 * sans fuite le vainqueur gagne un point de vie supllementaire
	 * mais ca rend le jeu trop facile pour le joueur donc on la laisse en commentaire
	 * 
	 * public String regagnerVie(int nbVieCombattant)  {
	 * this.setNbVie(nbVieCombattant); return "Les nouveaux points de vie de " +
	 * this.getNom() + ": " + this.getNbVie(); }
	 */

}
