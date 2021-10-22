import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg){

    int numberPlayers = 5;
    String [] playersNames = new String[numberPlayers];
    for (int nameIndex = 0; nameIndex < numberPlayers; nameIndex++){
        Scanner playerName  = new Scanner(System.in);
        System.out.println("Please enter j" + (nameIndex +1) + "'s name.");
        playersNames[nameIndex] = playerName.next();
    }

    Game gameTest = new Game(numberPlayers, playersNames);

    Scanner starter  = new Scanner(System.in);
    System.out.println("Who starts ?");
    String starterName = starter.next();

    for (Player player : gameTest.getPlayersList()){
        if (player.getPlayerName().equals(starterName)){
            gameTest.setOrder(player, gameTest.getPlayersList());
        }
    }

    for (Player player : gameTest.getPlayersList()){
        System.out.println(player.getOrder() + " order is " + player.getPlayerName());
    }


//    for (int currentFight = 0; currentFight < gameTest.getNumberCardsPerplayer(); currentFight++){
//        List<Animal> fightingAnimals = new ArrayList<>();
//        StringBuilder annonce = new StringBuilder();
//
//        for (int playerIndex = 0; playerIndex < numberPlayers; playerIndex++){
//            Player currentPlayer = gameTest.getPlayersList().get(playerIndex);
//            fightingAnimals.add(currentPlayer.getPlayerDeck().getListCards().get(currentFight));
//            annonce.append(gameTest.getPlayersList().get(playerIndex).getPlayerDeck().getListCards().get(currentFight).getNom()).append(" VS ");
//        }
//
//        System.out.println(annonce);
//        System.out.println(gameTest.getPlayersList().get(0).getPlayerDeck().getListCards().get(currentFight));
//
//        List<Animal> potentialWinners = Fight.animalFight(fightingAnimals);
//
//        while (potentialWinners.size() != 1){
//            for (Animal animal : potentialWinners){
//                for (Player player : gameTest.getPlayersList()){
//                    if(animal == player.getPlayerDeck().getListCards().get(currentFight)){
//                        if (!player.getStarts()){
//                            potentialWinners.remove(animal);
//                        }
//                    }
//                }
//            }
//        }
//        Animal animalWinner = fightingAnimals.get(0);
//        System.out.println(animalWinner.getNom());
//        for (Player player : gameTest.getPlayersList()){
//            if (animalWinner == player.getPlayerDeck().getListCards().get(currentFight)){
//                player.incrementVictories();
//            }
//
//        }
//    }
//    Player playerWinner = gameTest.getPlayersList().get(0);
//    for (Player player : gameTest.getPlayersList()){
//        if (player.getVictories() > playerWinner.getVictories()){
//            playerWinner = player;
//        }
//    }
//    System.out.println(playerWinner.getPlayerName() + " wins with " + playerWinner.getVictories() + " victories !");

    }
}
