package plateau;

import java.io.Serializable;

public class Porte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7317096306221770576L;
	protected boolean estSortie;
	protected boolean estActive;

	public Porte() {
		this.estSortie = false;
		this.estActive = true;
	}

	public boolean isEstSortie() {
		return estSortie;
	}

	public void setEstSortie(boolean estSortie) {
		this.estSortie = estSortie;
	}

	public boolean isEstActive() {
		return estActive;
	}

	public void setEstActive(boolean estActive) {
		this.estActive = estActive;
	}

}
