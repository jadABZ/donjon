package protagonistes;

public class Joueur extends EtreVivant{
    protected String nom;
    private Arme maPossession;
	
	public Joueur (String nom) 
	{
    this.nom = nom;
	this.nbrvie = 5;
    this.DegatAttaque = 1; 
	}
	
	public String getNom() 
	{
		return this.nom;
	}

    public String combattre(Monstre monstre) 
	{
		String texte;
		texte = "";
		if (this.maPossession == null) 
		{
			texte += this.attaque(monstre); 
		    return texte;	
		}
        texte += this.maPossession.attaque(monstre); 
		return texte;	
	}

    @Override 
	public String subirAttaque(int degatAttaque)
	{
		String texte = super.subirAttaque(degatAttaque); 
		if (this.nbrvie <= 0) {
			texte += this.mourir(); 
		}
		return texte; 	
	}

    @Override
	public String mourir()
	{
		return "La partie est terminée pour" + this.getNom() + "qui est malheureusement mort durant son combat.\n" + this.evCombat.eliminer(this);
	}

    @Override
    public String attaque(Monstre monstre)
	{
		return this.getNom() + "attaque le monstre" "\n" + monstre.subirAttaque(this.nbrdegat);
		
	}

}