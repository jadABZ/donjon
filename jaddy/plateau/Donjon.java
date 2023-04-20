package plateau;
import java.util.ArrayList;

public class Donjon {
	
	public static int dimension;
	public static ArrayList<Piece> piecesDonjon = new ArrayList<Piece>();
	//private MaitreDonjon maitreDonjon;
	
	public Donjon(int dimension) {
		
		Donjon.dimension = dimension;
		
		for(int i = 1; i<=Donjon.dimension; i++)
			for(int j = 1; j<=Donjon.dimension; j++)
			{
				Donjon.piecesDonjon.add(new Piece(new Position(i, j)));
			}
	}

	public static int getDimension() {
		return dimension;
	}

	public static void setDimension(int dimension) {
		Donjon.dimension = dimension;
	}

	public ArrayList<Piece> getPiecesDonjon() {
		return piecesDonjon;
	}

	public void setPiecesDonjon(ArrayList<Piece> piecesDonjon) {
		Donjon.piecesDonjon = piecesDonjon;
	}
	
	
}
