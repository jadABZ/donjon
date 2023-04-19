
public class Armures {

    public static final Armures Bouclier = null;
    public static final Armures Casque = null;
    private String nature;
    public int nbprotection;

    public Armures(String nature, int nbprotection) {
        this.nature = nature;
        this.nbprotection = nbprotection;
    }

    public String getNature() {
        return nature;
    }

}
