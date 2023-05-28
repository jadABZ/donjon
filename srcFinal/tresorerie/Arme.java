package tresorerie;

public class Arme extends Tresor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5703714345247895073L;

	public static String[] weaponNames = {"Anvil", "Blade", "Cleaver", "Dagger", "Edge", "Falchion", "Glaive", 
			"Halberd", "Impaler", "Javelin", "Katana", "Longsword", "Mace", "Nunchucks", "Orb", "Pike", 
			"Quarterstaff", "Rapier", "Scimitar", "Trident", "Umbrella", "Voulge", "Warhammer", "Xiphos",
			"Yari", "Zweihander", "Assassin's", "Bastard", "Cobra", "Death", "Eagle", "Flame", "Great", "Hunter's",
			"Iron", "Jade", "Kraken", "Lightning", "Mighty", "Nightmare", "Obsidian", "Phoenix", "Radiant", "Savage",
			"Thunderbolt", "Undead", "Viper's", "Wicked", "Xenon", "Yellow", "Zealous"};
	
	public static final String emojiArme = "\uD83D\uDDE1️"; // Imprime 🗡️
	private int degats;

	public Arme(String nom, int degats) {
		super(TypeTresor.ARME, nom);
		this.degats = degats;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

}
