package plateau;
import java.util.ArrayList;
import java.io.Serializable;

public class Donjon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8526527941636882420L;
	public static final int dimension = 4;
	public static ArrayList<Piece> piecesDonjon = new ArrayList<Piece>();
	
	public Donjon() {
		
		for(int y = 1; y<=Donjon.dimension; y++)
			for(int x = 1; x<=Donjon.dimension; x++)
			{
				piecesDonjon.add(new Piece(new Position(x, y)));
			}
	}
		
}
