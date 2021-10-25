import java.util.Random;

public class AIPlayer extends Player{


    public AIPlayer(String playerName, Deck playerDeck, Deck winnedCards) {
        super(playerName, playerDeck, winnedCards);
    }

    @Override
    public int attributeChoice (){
        Random random = new Random();
        return random.nextInt(4)+1;
    }

    @Override
    public  boolean switchAttributeProposal(){
        return true;
    }

    @Override
    public int attributeSwitch(){
        return attributeChoice();
    }

}
