import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final int numberPlayers;
    List<Animal> listAllCards;
    private int numberCardsFree;
    private final int numberCardsPerplayer;
    private final List<Player> playersList;


    public Game(int numberPlayers, String [] playersNames) {
        AllAnimals cards = new AllAnimals();
        this.numberPlayers = numberPlayers;
        listAllCards = cards.getAllAnimals();
        numberCardsFree = listAllCards.size();
        numberCardsPerplayer = numberCardsFree/numberPlayers;
        this.playersList = new ArrayList<>();
        createPlayersList(playersNames);
    }

    public int getNumberCardsPerplayer() {
        return numberCardsPerplayer;
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public int getNumberCardsFree() {
        return numberCardsFree;
    }

    public void createPlayersList(String[] names) {
        Player player;
        Deck deck;
        for (String name : names) {
            deck = deal();
            player = new Player(name, deck);
            for (Animal animal : deck.getListCards()){
                animal.setOwner(player);
            }
            playersList.add(player);
        }
    }

    public Deck deal(){
        Random random = new Random();
        Deck deckDealt = new Deck();
        int numberCardstoDeal = numberCardsPerplayer;
        while (numberCardstoDeal > 0){
            int randomCardIndex = random.nextInt(numberCardsFree);
            deckDealt.addCard(listAllCards.remove(randomCardIndex));
            numberCardsFree -= 1;
            numberCardstoDeal -= 1;
        }
        return deckDealt;
    }

    public void setOrder(Player firstPlayer, List<Player> playersList) {
        int firstPlace = playersList.indexOf(firstPlayer);
        int place = 1;

        for (int playerIndexNext = firstPlace; playerIndexNext < playersList.size(); playerIndexNext++){
            playersList.get(playerIndexNext).setOrder(place);
            place ++;
        }

        for (int playerIndexBefore = 0; playerIndexBefore < firstPlace; playerIndexBefore++){
            playersList.get(playerIndexBefore).setOrder(place);
            place ++;
        }
    }
}
