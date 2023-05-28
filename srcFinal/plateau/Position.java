package plateau;

import java.io.Serializable;

public class Position implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7114270370698559089L;
	private int posX;
	private int posY;
	
	public Position(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
