import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    AllAnimals cards = new AllAnimals();

    private final int numberPlayers;
    List<Animal> listAllCards;
    private int numberCardsFree;
    private final int numberCardsPerplayer;

    public Game(int numberPlayers) {
        this.numberPlayers = numberPlayers;
        listAllCards = cards.allAnimals;
        numberCardsFree = listAllCards.size();
        numberCardsPerplayer = numberCardsFree/numberPlayers;
    }

    public int getNumberCardsPerplayer() {
        return numberCardsPerplayer;
    }

    public int getNumberCardsFree() {
        return numberCardsFree;
    }

    public Deck deal(){
        Random random = new Random();
        Deck deckDealt = new Deck();
        int numberCardstoDeal = numberCardsPerplayer;
        while (numberCardstoDeal > 0){
            int randomCardIndex = random.nextInt(numberCardsFree);
            deckDealt.listCards.add(listAllCards.get(randomCardIndex));
            listAllCards.remove(randomCardIndex);
            numberCardsFree -= 1;
            numberCardstoDeal -= 1;
        }
        return deckDealt;
    }
}
