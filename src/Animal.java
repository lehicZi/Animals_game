public class Animal{

    private final String nom;
    private final double poids;
    private final double longueur;
    private final double longevite;
    private final double gestationIncubation;
    private final int rarete;
    private Player owner;

    public Animal(String nom, double poids, double longueur, double longevite, double gestation_incubation, int rarete) {
        this.nom = nom;
        this.poids = poids;
        this.longueur = longueur;
        this.longevite = longevite;
        this.gestationIncubation = gestation_incubation;
        this.rarete = rarete;
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

    public double getLongevite() {
        return longevite;
    }

    public double getGestationIncubation() {
        return gestationIncubation;
    }

    public int getRarete() {
        return rarete;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public double getAttribute(int attribute){
        switch (attribute) {
            case 1 -> {
                return poids;
            }
            case 2 -> {
                return longevite;
            }
            case 3 -> {
                return longueur;
            }
            case 4 -> {
                return gestationIncubation;
            }
            default -> throw new IllegalStateException();
        }
    }

    public String getAttributesName(int attribute){
        switch (attribute) {
            case 1 -> {
                return "poids";
            }
            case 2 -> {
                return "longueur";
            }
            case 3 -> {
                return "longévité";
            }
            case 4 -> {
                return "gestion/incubation";
            }
            default -> throw new IllegalStateException();
        }
    }

    @Override
    public String toString(){
        return nom + " : poids = " + poids + " kg, longueur = " + longueur + " m, longévité = " + longevite + " ans, gestation/incubation = " + gestationIncubation + " jours." ;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Animal a)){
            return false;
        }

        return this.nom.equals(a.nom);
    }
}
