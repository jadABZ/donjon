
public class Arc extends Armes {

    public int nbfleche;

    public Arc(int nbfleche) {
        super("arc", 3);
        this.nbfleche = nbfleche;
    }

    public int getNbfleche() {
        return nbfleche;
    }
}
