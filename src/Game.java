import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int numberPlayers;
    private final int numberRealPlayers;
    List<Animal> listAllCards;
    private int numberCardsFree;
    private final int numberCardsPerplayer;
    private final List<Player> playersList;


    public Game(int numberPlayers, int numberRealPlayers, String [] realPlayersNames, String[] AIPlayersNames) {
        AllAnimals cards = new AllAnimals();
        this.numberPlayers = numberPlayers;
        this.numberRealPlayers = numberRealPlayers;
        listAllCards = cards.getAllAnimals();
        numberCardsFree = listAllCards.size();
        numberCardsPerplayer = numberCardsFree/numberPlayers;
        this.playersList = new ArrayList<>();
        createPlayersList(realPlayersNames, AIPlayersNames);
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

    public void createPlayersList(String[] namesRealPlayers, String[] AINames) {
        Player player;
        Deck deck;
        for (String name : namesRealPlayers) {
            deck = deal();
            player = new RealPlayer(name, deck);
            for (Animal animal : deck.getListCards()){
                animal.setOwner(player);
            }
            playersList.add(player);
        }
        for (String name : AINames) {
            deck = deal();
            player = new AIPlayer(name, deck);
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

    public void playersFight (){
        for (int currentFight = 0; currentFight < numberCardsPerplayer; currentFight++) {
            List<Animal> fightingAnimals = new ArrayList<>();
            StringBuilder annonce = new StringBuilder();
            Player starter = playersList.get(0);

            for (int playerIndex = 0; playerIndex < numberPlayers; playerIndex++) {
                Player currentPlayer = playersList.get(playerIndex);
                Animal currentAnimal = currentPlayer.getPlayerDeck().getListCards().get(currentFight);
                fightingAnimals.add(currentAnimal);
                if (currentPlayer.getOrder() == 1){
                    starter = currentPlayer;
                }
                if (playerIndex == numberPlayers - 1) {
                    annonce.append(currentAnimal.getNom());
                } else {
                    annonce.append(currentAnimal.getNom()).append(" VS ");
                }

            }

            System.out.println(annonce);
            System.out.println(playersList.get(0).getPlayerDeck().getListCards().get(currentFight));



            Animal animalWinner = Fight.animalFight(starter.attributeChoice(), fightingAnimals);
            Player playerWinner = animalWinner.getOwner();
            setOrder(playerWinner, playersList);

            System.out.println(animalWinner.getOwner().getPlayerName() + " wins with his " + animalWinner.getNom());
            playerWinner.incrementVictories();

        }
    }

    public Player findFinalWinner(List <Player> playersList){
        Player finalWinner = playersList.get(0);
        for (Player player : playersList) {
            if (player.getVictories() > finalWinner.getVictories()) {
                finalWinner = player;
            }
        }
        return finalWinner;
    }

}
