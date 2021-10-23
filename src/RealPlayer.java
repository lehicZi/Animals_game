import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer extends Player{

    public RealPlayer(String playerName, Deck playerDeck) {
        super(playerName, playerDeck);
    }

    @Override
    public int attributeChoice () {
        try {
            Scanner userChoice = new Scanner(System.in);
            System.out.println("Please enter the chose the attribute (1 : poids, 2 : longueur, 3 : longévité, 4 : Gestation/incubation)");
            return userChoice.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("is it too hard to enter an integer ?");
            return attributeChoice();
        }
    }


}
