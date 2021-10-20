public class Animal extends Card{

    private final String nom;
    private final double poids;
    private final double longueur;
    private final double longévité;
    private final double gestation_incubation;
    private final int rareté;

    public Animal(String nom, double poids, double longueur, double longévité, double gestation_incubation, int rareté) {
        this.nom = nom;
        this.poids = poids;
        this.longueur = longueur;
        this.longévité = longévité;
        this.gestation_incubation = gestation_incubation;
        this.rareté = rareté;
    }

    public String getNom() {
        return nom;
    }

    public double getPoids() {
        return poids;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getLongévité() {
        return longévité;
    }

    public double getGestation_incubation() {
        return gestation_incubation;
    }

    public int getRareté() {
        return rareté;
    }

    public double GetAttribute(String attribute){
        double choice =0;
        if (attribute.equals("1") ) {
            choice = poids;
        }
        else if (attribute.equals("4")) {
            choice = gestation_incubation;
        }
        else if (attribute.equals("2")) {
            choice = longueur;
        }
        else if (attribute.equals("3")){
            choice = longévité;
        }
        else{
            System.out.println("Erreur de frappe");
        }
        return choice;
    }
}
