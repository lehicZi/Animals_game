import java.util.Random;

public class AIPlayer extends Player{


    public AIPlayer(String playerName, Deck playerDeck) {
        super(playerName, playerDeck);
    }

    @Override
    public int attributeChoice (){
        Random random = new Random();
        return random.nextInt(4)+1;
    }

}
