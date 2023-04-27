package plateau;
import protagonistes.Monstre;
import java.util.Random;
import tresorerie.*;

public class Piece {

	private Position position;
	private Porte porteNord;
	private Porte porteSud;
	private Porte porteOuest;
	private Porte porteEst;
	
	private Monstre monstre;
	private Tresor tresor;
	
	//dans le constructeur on trouve 3 phases: creation des portes, creation du monstre et creation du tresor
	public Piece(Position position) {
		super();
		this.position = position;
		
		//phase 1: creation des portes:
		this.porteNord = new Porte();
		this.porteSud = new Porte();
		this.porteOuest = new Porte();
		this.porteEst = new Porte();
		
		//supprimation des portes sur les bords du donjon
		if(this.position.getPosX() == 1)
			this.porteOuest = null;
		if(this.position.getPosX() == Donjon.dimension)
			this.porteEst = null;
		if(this.position.getPosY() == 1)
			this.porteSud = null;
		if(this.position.getPosY() == Donjon.dimension)
			this.porteNord = null;
		
		//on designe la porteNord de la salle ayant les plus grands dimensions comme porte de sortie du donjon
		if(this.position.getPosX() == Donjon.dimension && this.position.getPosY() == Donjon.dimension)
		{
			this.porteNord = new Porte();
			this.porteNord.setEstSortie(true);
		}
		
		//dans les prochaines phases on aura besoins de l'objet random our generer des noms aleatoires 
		Random random = new Random();
		int randomIndex;
		
		//phase 2 et 3: creation du monstre et du tresor:
		
		//dans la premiere piece il n'ya pas de monstre ni de tresor
		if(this.position.getPosX() == 1 && this.position.getPosY() == 1)
		{
			this.monstre = null;
			this.tresor = null;
		}
		else
		{
			//generer un nom aleatoire pour le monstre

	        // generate a random index between 0 and the length of the monsterNames array
	        randomIndex = random.nextInt(Monstre.monsterNames.length);

	        // get the monster name at the random index
	        this.monstre = new Monstre(Monstre.monsterNames[randomIndex]);
	        
	        //creation du tresor
	        int randomNumber = random.nextInt(2);
			//en fonction du randomInt obtenu on choisi si on va placer une arme ou une armure dans la piece
			if(randomNumber == 0)
			{
				randomIndex = random.nextInt(Arme.weaponNames.length);
				//choix de nom aleatoire, et points de degats aleatoires entre 1 et 5
				this.tresor = new Arme(Arme.weaponNames[randomIndex], random.nextInt(5) + 1);		
			}
			else
			{
				randomIndex = random.nextInt(Armure.shieldNames.length);
				this.tresor = new Armure(Armure.shieldNames[randomIndex], random.nextInt(5) + 1);		
			}
		}
		
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Porte getPorteNord() {
		return porteNord;
	}
	public void setPorteNord(Porte porteNord) {
		this.porteNord = porteNord;
	}
	public Porte getPorteSud() {
		return porteSud;
	}
	public void setPorteSud(Porte porteSud) {
		this.porteSud = porteSud;
	}
	public Porte getPorteOuest() {
		return porteOuest;
	}
	public void setPorteOuest(Porte porteOuest) {
		this.porteOuest = porteOuest;
	}
	public Porte getPorteEst() {
		return porteEst;
	}
	public void setPorteEst(Porte porteEst) {
		this.porteEst = porteEst;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public Tresor getTresor() {
		return tresor;
	}

	public void setTresor(Tresor tresor) {
		this.tresor = tresor;
	}
	
	
}
