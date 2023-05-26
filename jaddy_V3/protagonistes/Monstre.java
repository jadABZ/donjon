package protagonistes;

public class Monstre extends Combattant {

	public static int nbVieMonstre = 5;
	public static final String emojiMonstre = "\uD83D\uDC79"; // Imprime 👹
	public static String[] monsterNames = {"Gorgon", "Banshee", "Specter", "Minotaur", "Kraken", "Hydra", "Ogre",
			"Chimera", "Wendigo", "Harpy", "Leviathan", "Manticore", "Ghoul", "Mummy", "Zombie", "Vampire",
			"Werewolf", "Siren", "Cerberus", "Cyclops", "Dragon", "Phoenix", "Basilisk", "Goblin", "Gremlin",
			"Hobgoblin", "Imp", "Lich", "Naga", "Orc", "Troll", "Yeti", "Abomination", "Behemoth", "Colossus",
			"Daemon", "Ettin", "Fomorian", "Gargoyle", "Hag", "Incubus", "Jotunn", "Kobold", "Lamia", "Merfolk",
			"Necromancer", "Oni", "Pegasus", "Roc", "Satyr", "Titan"};
	
	public Monstre(String nom) {
		super(nom, nbVieMonstre);
	}

	@Override
	public String mourir() {
		return this.getNom() + " est mort\n";
	}
	
	@Override
	public String subirAttaque(Combattant joueur)
	{
		String subir = this.getNom() + " subit une violente attaque, ";
		if(((Joueur)joueur).getArme() != null)
		{
			subir += " par l'arme " + ((Joueur)joueur).getArme().getNom() + " ";
			this.setNbVie(this.getNbVie() - joueur.getForceAttaque() * ((Joueur)joueur).getArme().getDegats());
		}
		else
			this.setNbVie(this.getNbVie() - joueur.getForceAttaque());
			
		if(this.getNbVie() > 0)
			subir += " mais il parvient a se relever\n";
		else
		{
			subir+= " trop violente pour survivre\n";
			mourir();
		}
		
		return subir;
	}
}
