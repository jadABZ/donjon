import java.util.Random;

//Classe Joueur
public class Joueur {

    private String nom;
    private int nbvie = 10;
    private int force = 1;
    private int nbArme = 0;
    private Armes Arme = null;
    private int nbArmure = 0;
    private Armures Armure = null;

    public String getNom() {
        return nom;
    }

    public Joueur(String nom, int force) {
        super();
        this.nom = nom;
        this.force = force;
    }

    // PARTIE TRESOR
    public void sEquiperArme(Armes newArme) { // s'équiper d'une nouvelle arme
        String rep = "";
        if (this.nbArme > 0) { // si déjà une arme
            System.out.println("Le joueur " + this.nom + " a déjà une arme ! ");
            System.out.println("Souhaitez-vous lâcher votre arme et vous équiper de la nouvelle ? [oui,non] ");
            rep = Clavier.entrerClavierString();
            if (rep == "oui") { // le joueur lâche son arme pour s'équiper de la nouvelle
                this.nbArme = 0;
                this.force = this.force - this.Arme.nbdegat; // la force du joueur diminue du nombre de dégât de l'arme
                                                             // qu'il lâche
                this.Arme = null;
                this.Arme = newArme; // Arme prend la nouvelle arme
                this.force = this.force + newArme.nbdegat; // la force du joueur augmente du nombre de dégât de l'arme
                System.out.println("Le joueur " + this.nom + " prend l'arme " + this.Arme);
            }
        } else {
            System.out.println("Souhaitez-vous vous équiper de la nouvelle arme? [oui,non] ");
            if (rep == "oui") { // le joueur souhaite s'équiper de la nouvelle arme
                this.Arme = newArme; // Arme prend la nouvelle arme
                this.force = this.force + newArme.nbdegat; // la force du joueur augmente du nombre de dégât de l'arme
                System.out.println("Le joueur " + this.nom + " prend l'arme " + this.Arme);
            }
        }
    }

    public void sEquiperArmure(Armures newArmure) { // s'équiper d'une nouvelle armure
        String rep = "";
        int nbviebase = 0;
        if (this.nbArmure > 0) { // si déjà une armure
            System.out.println("Le joueur " + this.nom + " a déjà une armure ! ");
            System.out.println("Souhaitez-vous lâcher votre armure et vous équiper de la nouvelle ? [oui,non] ");
            rep = Clavier.entrerClavierString();
            if (rep == "oui") { // le joueur lâche son armure pour s'équiper de la nouvelle
                this.nbArmure = 0;
                if (this.nbvie > nbviebase) {
                    this.nbvie = nbviebase;
                }
                this.Armure = null;
                this.Armure = newArmure; // Armure prend la nouvelle armure
                this.nbvie = this.nbvie + newArmure.nbprotection; // le nombre de vie du joueur augmente du nombre de
                                                                  // protection de l'armure
                System.out.println("Le joueur " + this.nom + " prend l'armure " + this.Armure);
            }
        } else {
            nbviebase = this.nbvie;
            System.out.println("Souhaitez-vous vous équiper de la nouvelle armure? [oui,non] ");
            if (rep == "oui") {
                this.Armure = newArmure;
                this.nbvie = this.nbvie + newArmure.nbprotection;
                System.out.println("Le joueur " + this.nom + " prend l'armure " + this.Armure);
            }
        }

    }

    private void obtenirTresor() {
        Random rand = new Random();
        int typeTresor = rand.nextInt(2); // 0:arme et 1:armure
        if (typeTresor == 0) {
            int typeArme = rand.nextInt(3); // 0:lance-pierre 1:arc 2:épée
            if (typeArme == 0) {
                System.out.println(this.nom + "a gagné un lance-pierre ");
                sEquiperArme(Armes.LancePierre);
            } else if (typeArme == 1) {
                System.out.println(this.nom + "a gagné un arc ");
                sEquiperArme(Armes.Arc);
            } else {
                System.out.println(this.nom + "a gagné une épée ");
                sEquiperArme(Armes.Epee);
            }
        } else {
            int typeArmure = rand.nextInt(2); // 0:bouclier 1:casque
            if (typeArmure == 0) {
                System.out.println(this.nom + "a gagné un bouclier ");
                sEquiperArmure(Armures.Bouclier);
            } else {
                System.out.println(this.nom + "a gagné un casque ");
                sEquiperArmure(Armures.Casque);
            }
        }
    }
}