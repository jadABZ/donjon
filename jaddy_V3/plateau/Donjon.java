package plateau;
import java.util.ArrayList;
import java.io.Serializable;

public class Donjon implements Serializable{
	
	public static final int dimension = 4;
	public ArrayList<Piece> piecesDonjon = new ArrayList<Piece>();
	//private MaitreDonjon maitreDonjon;
	
	public Donjon() {
		
		for(int i = 1; i<=Donjon.dimension; i++)
			for(int j = 1; j<=Donjon.dimension; j++)
			{
				this.piecesDonjon.add(new Piece(new Position(i, j)));
			}
	}
		
}
