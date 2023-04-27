package tresorerie;

public abstract class Tresor {

	private TypeTresor typeTresor;
	private String nom;

	public Tresor(TypeTresor typeTresor, String nom) {
		super();
		this.typeTresor = typeTresor;
		this.nom = nom;
	}

	public TypeTresor getTypeTresor() {
		return typeTresor;
	}

	public void setTypeTresor(TypeTresor typeTresor) {
		this.typeTresor = typeTresor;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
