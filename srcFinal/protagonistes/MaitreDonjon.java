package protagonistes;

import java.util.Random;

import plateau.*;
import tresorerie.*;

public class MaitreDonjon extends Joueur {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8817933663149076288L;

	public MaitreDonjon() {
		super("Maitre du donjon");
	}
	
	public void accederPiece(int posPieceArrayList)
	{
		super.setLocalisationJoueur(Donjon.piecesDonjon.get(posPieceArrayList - 1));
	}
	
	public String ajouterMonstre()
	{
		Random random = new Random();
		int randomIndex = random.nextInt(Monstre.monsterNames.length);
		this.getLocalisationJoueur().setMonstre(new Monstre(Monstre.monsterNames[randomIndex]));
		return "Un monstre a ete ajoute dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ")";
	}
	
	public String supprimerMonstre()
	{
		this.getLocalisationJoueur().setMonstre(null);
		return "Un monstre a ete supprime dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ")";
	}
	
	public String ajouterArme(int degats)
	{
		Random random = new Random();
		int randomIndex = random.nextInt(Arme.weaponNames.length);
		this.getLocalisationJoueur().setTresor(new Arme(Arme.weaponNames[randomIndex], degats));
		return "Une arme a ete ajoute dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ")";
	}
	
	public String ajouterArmure(int protection)
	{
		Random random = new Random();
		int randomIndex = random.nextInt(Armure.shieldNames.length);
		this.getLocalisationJoueur().setTresor(new Armure(Armure.shieldNames[randomIndex], protection));
		return "Une armure a ete ajoute dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ")";
	}
	
	public String supprimerTresor()
	{
		this.getLocalisationJoueur().setTresor(null);
		return "Le tresor a ete supprime dans la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ")";
	}
	
	public String activerPorte(Direction direction)
	{
		if(direction == Direction.EST)
			this.getLocalisationJoueur().getPorteEst().setEstActive(true);
		if(direction == Direction.OUEST)
			this.getLocalisationJoueur().getPorteOuest().setEstActive(true);
		if(direction == Direction.NORD)
			this.getLocalisationJoueur().getPorteNord().setEstActive(true);
		System.out.println(this.getLocalisationJoueur().getPorteNord().isEstActive());
		if(direction == Direction.SUD)
			this.getLocalisationJoueur().getPorteSud().setEstActive(true);
		
		return "La porte " + direction + " de la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ") a ete activee";
	}
	
	public String desactiverPorte(Direction direction)
	{
		if(direction == Direction.EST)
			this.getLocalisationJoueur().getPorteEst().setEstActive(false);
		if(direction == Direction.OUEST)
			this.getLocalisationJoueur().getPorteOuest().setEstActive(false);
		if(direction == Direction.NORD)
			this.getLocalisationJoueur().getPorteNord().setEstActive(false);
		if(direction == Direction.SUD)
			this.getLocalisationJoueur().getPorteSud().setEstActive(false);
		
		return "La porte " + direction + " de la piece (" + this.getLocalisationJoueur().getPosition().getPosX() + ", " + this.getLocalisationJoueur().getPosition().getPosY() + ") a ete desactivee";
	}

}
