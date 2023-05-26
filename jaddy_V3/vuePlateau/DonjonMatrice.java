package vuePlateau;
import plateau.*;
import protagonistes.*;

public class DonjonMatrice {
	
	private Joueur joueur;
	
    public DonjonMatrice(Joueur joueur) {
		super();
		this.joueur = joueur;
	}


	public void afficherPlateau() {
		
		System.out.println("          N          ");
        System.out.println("          |          ");
        System.out.println("    O --- + --- E    ");
        System.out.println("          |          ");
        System.out.println("          S          ");
    	
    	 for (int j=4; j>0; j--)
    	 {
    		 for(int i =1; i<=Donjon.dimension; i++)
    		 {
    			 if(this.joueur.getLocalisationJoueur().getPosition().getPosX() == i && this.joueur.getLocalisationJoueur().getPosition().getPosY() == j)
    				 System.out.print("( X ) ");
    			 else
    			 
    				 System.out.print("(" + i + "," + j + ") ");
    		 }
    		 System.out.println();
    	 }
    }
}
