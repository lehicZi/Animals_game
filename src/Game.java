import java.util.*;

public class Game {

    private final int numberPlayers;
    private final int numberRealPlayers;
    List<Animal> listAllCards;
    private int numberCardsFree;
    private final int numberCardsPerplayer;
    private final List<Player> realPlayersList;
    private final List<Player> AIPlayersList;
    private final List<Player> playersList;


    public Game(int numberPlayers, int numberRealPlayers, String [] realPlayersNames) {
        AllAnimals cards = new AllAnimals();
        this.numberPlayers = numberPlayers;
        this.numberRealPlayers = numberRealPlayers;
        listAllCards = cards.getAllAnimals();
        numberCardsFree = listAllCards.size();
        numberCardsPerplayer = numberCardsFree/numberPlayers;
        this.playersList = new ArrayList<>();
        this.realPlayersList = new ArrayList<>();
        this.AIPlayersList = new ArrayList<>();
        createRealPlayersList(realPlayersNames);
        createAIPlayersList();
        playersList.addAll(realPlayersList);
        playersList.addAll(AIPlayersList);
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

    public void createRealPlayersList(String[] namesRealPlayers) {
        Player player;
        Deck deck;
        for (String name : namesRealPlayers) {
            deck = deal();
            player = new RealPlayer(name, deck);
            for (Animal animal : deck.getListCards()) {
                animal.setOwner(player);
            }
            realPlayersList.add(player);
        }
    }

    public void createAIPlayersList() {
        Player player;
        Deck deck;
        String AIsname;
        for (int nameIndex = 0; nameIndex < (numberPlayers-numberRealPlayers); nameIndex++) {
            AIsname = "Bot " + (nameIndex+1);
            deck = deal();
            player = new AIPlayer(AIsname, deck);
            for (Animal animal : deck.getListCards()) {
                animal.setOwner(player);
            }
            AIPlayersList.add(player);
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

    public Player defineStarter (){
        Scanner getStarterType = new Scanner(System.in);

        System.out.println("Who starts ? (1 : a real player, 2 : a bot)");
        try {
            int starterType = getStarterType.nextInt();

            switch (starterType) {
                case 1 -> {
                    if (numberRealPlayers == 1) {
                        return realPlayersList.get(0);
                    } else {
                        Scanner getStarterName = new Scanner(System.in);
                        System.out.println("So who starts ? (Player's EXACT name)");
                        String starterName = getStarterName.next();
                        for (Player player : realPlayersList) {
                            if (player.getPlayerName().equals(starterName)) {
                                return player;
                            }
                        }
                        System.out.println("Not a valid name.");
                        return defineStarter();
                    }
                }
                case 2 -> {
                    Random random = new Random();
                    return AIPlayersList.get(random.nextInt(numberPlayers - numberRealPlayers));
                }
                default -> {
                    System.out.println("is it too hard to enter 1 or 2 ?");
                    return defineStarter();
                }
            }

        }
        catch (InputMismatchException e) {
            System.out.println("is it too hard to enter 1 or 2 ?");
            return defineStarter();
        }
    }

    public void giveOrder(Player firstPlayer, List<Player> playersList) {
        int firstPlace = playersList.indexOf(firstPlayer);
        int place = 1;

        for (int playerIndexNext = 0; playerIndexNext < playersList.size(); playerIndexNext++){
            playersList.get((firstPlace+playerIndexNext)%playersList.size()).setOrder(place);
            place ++;
        }
    }

    public List<Player> orderPlayersList(){
        List<Player> orderedPlayersList = new ArrayList<>(playersList);
        for (Player player : playersList){
            orderedPlayersList.set((player.getOrder()-1), player);
        }
        return orderedPlayersList;
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
                    annonce.append(currentPlayer).append("'s ").append(currentAnimal.getNom());
                } else {
                    annonce.append(currentPlayer).append("'s ").append(currentAnimal.getNom()).append(" VS ");
                }

            }

//            System.out.println(annonce);
            for (Player player : realPlayersList){
                    System.out.println(player.getPlayerDeck().getListCards().get(currentFight));
            }

            int codeEffectiveAttribute = starter.attributeChoice();

            Animal startersAnimal = starter.getPlayerDeck().getListCards().get(currentFight);

            System.out.println(starter + " chose " + startersAnimal.getAttributesName(codeEffectiveAttribute));

            Animal animalWinner = Fight.animalFight(codeEffectiveAttribute, fightingAnimals);
            Player playerWinner = animalWinner.getOwner();

            giveOrder(playerWinner, playersList);

//            System.out.println(orderPlayersList());

            System.out.println("The fight was " + annonce);
            System.out.println(animalWinner.getOwner().getPlayerName() + " wins with his " + animalWinner.getNom());

            playerWinner.incrementVictories();

            Scanner block = new Scanner(System.in);
            System.out.println("Please tap any thing to pursue.");
            block.next();
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
