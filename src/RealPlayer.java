import java.util.InputMismatchException;
import java.util.Scanner;

public class RealPlayer extends Player{

    public RealPlayer(String playerName, Deck playerDeck, Deck winnedCards) {
        super(playerName, playerDeck, winnedCards);
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

    @Override
    public  boolean switchAttributeProposal() {
        try {
            Scanner userChoice = new Scanner(System.in);
            System.out.println("Your animal's rareté is higher than VERT, do you want to try to change the effective attribute ? (1 : yes, 2 : no).");
            switch (userChoice.nextInt()) {
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> {
                    System.out.println("is it too hard to enter 1 or 2 ?");
                    return switchAttributeProposal();
                }
            }
            }
        catch (InputMismatchException e) {
            System.out.println("is it too hard to enter 1 or 2 ?");
            return switchAttributeProposal();
        }
    }


    @Override
    public int attributeSwitch(){
        return attributeChoice();
    }



}
