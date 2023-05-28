package tresorerie;

public class Armure extends Tresor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599588526359787170L;

	public static String[] shieldNames = {"Aegis", "Buckler", "Crest", "Defender", "Eagle", "Falcon", 
			"Guardian", "Hoplite", "Ironclad", "Juggernaut", "Knight's", "Lionheart", "Majestic", "Noble", 
			"Obsidian", "Paladin's", "Quicksilver", "Royal", "Sentinel", "Tower", "Umbra", "Valiant", "Warrior's", 
			"Xenon", "Yellowjacket", "Zealous", "Berserker's", "Crusader's", "Dragon's", "Emperor's", "Frost", 
			"Gladiator's", "Hammerhead", "Ice", "Jade", "Kite", "Lunar", "Mithril", "Nimble", "Oaken", "Platinum", 
			"Radiant", "Savage", "Thunder", "Unyielding", "Venerable", "Winged", "Xiphos", "Yew", "Zephyr"};

	public static final String emojiArmure = "\uD83D\uDEE1️"; // Imprime 🛡️
	private int pointsProtection;

	public Armure(String nom, int pointsProtection) {
		super(TypeTresor.ARMURE, nom);
		this.pointsProtection = pointsProtection;
	}

	public int getPointsProtection() {
		return pointsProtection;
	}

	public void setPointsProtection(int pointsProtection) {
		this.pointsProtection = pointsProtection;
	}

}
