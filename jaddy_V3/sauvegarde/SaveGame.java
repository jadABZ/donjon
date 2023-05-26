package sauvegarde;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

public class SaveGame {

	public SaveGame() {
		try {
		      FileWriter myWriter = new FileWriter("savegame.txt");
		      myWriter.write("Filesss in Java might be tricky, but it is fun enough!\nJad s the king\nsgds shd\naaaaa");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
