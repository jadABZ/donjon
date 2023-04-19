
public class Armes {

    public static final Armes LancePierre = null;
    public static final Armes Arc = null;
    public static final Armes Epee = null;
    private String nature;
    private int nbdegat;

    public Armes(String nature, int nbdegat) {
        this.nature = nature;
        this.nbdegat = nbdegat;
    }

    public String getNature() {
        return nature;
    }

}
