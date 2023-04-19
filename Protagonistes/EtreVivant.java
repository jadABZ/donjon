package protagonistes;

public abstract class EtreVivant {
	protected int nbrvie; 
    protected int DegatAttaque; 
    protected Combat evCombat;  
	
	public EtreVivant (String nom, int nbrvie) 
	{
		this.nbrvie = nbrvie;
        this.DegatAttaque = DegatAttaque;
	}
	
	public String rejointCombat (Combat combat)
	{
		this.evCombat = combat;
		return "";  
	}
	
	public String subirAttaque(int forceAttaque)
	{	
		while (combat != null)
		this.nbrvie -= forceAttaque;
		String texte = this.getNom() + " subit une violente attaque de la part du monstre, "; 
		if (this.nbrvie > 0) {
			texte += "mais il parvient à survivre. \n";
		}
		else {
			this.nbrvie = 0;
			texte += "trop violente pour survivre. \n";
		}
		return texte;
	}

	public abstract String attaque();

	public abstract String mourir();
	
}