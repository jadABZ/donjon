package plateau;

public class Piece {

	private Position position;
	private Porte porteNord;
	private Porte porteSud;
	private Porte porteWest;
	private Porte porteEst;
	
	//private Monstre monstre;
	//private Tresor tresor;
	
	public Piece(Position position) {
		super();
		this.position = position;
		this.porteNord = new Porte();
		this.porteSud = new Porte();
		this.porteWest = new Porte();
		this.porteEst = new Porte();
		
		//supprimation des portes sur les bords du lab
		if(this.position.getPosX() == 1)
			this.porteWest = null;
		if(this.position.getPosX() == Donjon.dimension)
			this.porteEst = null;
		if(this.position.getPosY() == 1)
			this.porteSud = null;
		if(this.position.getPosY() == Donjon.dimension)
			this.porteNord = null;
		
		//on designe la porteNord de la salle ayant les plus grands dimensions comme porte de sortie du lab
		if(this.position.getPosX() == Donjon.dimension && this.position.getPosY() == Donjon.dimension)
		{
			this.porteNord = new Porte();
			this.porteNord.setEstSortie(true);
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
	public Porte getPorteWest() {
		return porteWest;
	}
	public void setPorteWest(Porte porteWest) {
		this.porteWest = porteWest;
	}
	public Porte getPorteEst() {
		return porteEst;
	}
	public void setPorteEst(Porte porteEst) {
		this.porteEst = porteEst;
	}
	
}
