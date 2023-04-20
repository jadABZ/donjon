package protagonistes;

public abstract class Combattant {

	private String nom;
	private int nbVie;
	
	public Combattant(String nom, int nbVie) {
		super();
		this.nom = nom;
		this.nbVie = nbVie;
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
	
	public abstract String mourir();
	
	public String attaquer(Combattant adversaire)
	{
		return "";
	}
	
	public String regagnerVie()
	{
		return "";
	}
	
	public String recevoirCoup()
	{
		return "";
	}

}
