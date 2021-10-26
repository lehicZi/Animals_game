import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer extends Player{
    /** Classe fille de Player, représentant un joueur humain.
     *  Se construit avec les mêmes paramètres que la classe Player :
     * @param playerName le nom du joueur.
     * @param playerDeck son deck initial (actuel).
     */

    public RealPlayer(String playerName, Deck playerDeck) {
        super(playerName, playerDeck);
    }

    /** Implémente le choix d'attribut pour un joueur humain.
     *  Se fait en interagissant avec l'utilisateur.
     * @return un entier représentant l'attribut choisi.
     */


    @Override
    public int attributeChoice () {

            // Demande à l'utilisateur
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the chose the attribute (1 : poids, 2 : longueur, 3 : longévité, 4 : Gestation/incubation)");
            String userChoice = scanner.next();

            while (!(Utils.isAnInt(userChoice))
                    || !Utils.isBetweenXAndY(Integer.parseInt(userChoice), 1, 4)){
                // si l'utilisateur entre une valeur erronée (pas un int ou pas entre 1 et 4), relance le choix.
                System.out.println("is it too hard to enter an integer between 1 and 4 ?");
                userChoice = scanner.next();
            }

            return Integer.parseInt(userChoice);
    }

    /** Implémente la proposition de choix d'attribut pour un joueur humain.
     *  Se fait en interagissant avec l'utilisateur.
     * @return un booléen : Oui/Non.
     */

    @Override
    public  boolean switchAttributeProposal() {
        Scanner scanner = new Scanner(System.in);
        // On propose au joueur de changer l'attribut.
        System.out.println("Your animal's rareté is higher than VERT, do you want to try to change the effective attribute ? (1 : yes, 2 : no).");
        String userChoice = scanner.next();

        while (!(Utils.isAnInt(userChoice))
                || !Utils.isBetweenXAndY(Integer.parseInt(userChoice), 1, 2)){
            // si l'utilisateur entre une valeur erronée (pas un int ou pas entre 1 et 4), relance le choix.
            System.out.println("is it too hard to enter 1 or 2 ?");
            userChoice = scanner.next();
        }

        return Integer.parseInt(userChoice) == 1;
    }

    /** Implémente le choix d'attribut pour un joueur humain.
     *  Se fait en interagissant avec l'utilisateur.
     * @return un entier représentant l'attribut choisi.
     */

    @Override
    public int attributeSwitch(){
        return attributeChoice();
    }



}
