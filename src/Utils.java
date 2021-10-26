import java.util.Comparator;

public class Utils {
    /**Classe utilitaire permettant de définir des méthodes génériques.
        Constructeur privé, car la classe n'a pas à être instanciée.
     */

    private Utils() {
    }

    /** Vérifie si un String est bien un entier.
     * @param s Le string à vérifier
     * @return true si le String est un entier, false sinon
     */

    public static boolean isAnInt(String s){
        try{
            Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**Vérifie si un entier est bien compris entre 2 bornes
     * @param choice l'entier à vérifier
     * @param X la borne inférieure (inclue)
     * @param Y la borne supérieure (inclue)
     * @return true si l'entier est bien entre les bornes, false sinon.
     */

    public static boolean isBetweenXAndY(int choice, int X, int Y){
        return (choice >= X) && (choice <= Y);
    }

    /**Comparateur utilisé pour ordonner la playersList
     */

    public static Comparator<Player> playerComparator(){
        return Comparator.comparingInt(Player::getOrder);
    }
}
