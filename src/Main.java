import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        /* Initialisation en entrant le nombre de joueurs et le nombre de joueurs réels
         */

        int numberPlayers = 2;
        int numberRealPlayers = 1;
        int numberAIPlayers = numberPlayers - numberRealPlayers;


        /* Instanciation dune partie (de tpe Battlegame ou OneDeckGame).
         */
        Game gameTest = new BattleGame(numberPlayers, numberRealPlayers);

        /* L'ordre des joueurs initial est demandé puis appliqué
         */
        gameTest.getPlayersList().giveOrder(gameTest.defineStarter());

//        for(Player player : gameTest.getPlayersList()) {
//            System.out.println(player + " plays as the "+player.getOrder()+"th place.");
//        }


        gameTest.playersFight();

        Player finalWinner = gameTest.findFinalWinner();

        System.out.println(finalWinner.getPlayerName() + " wins the game with " + finalWinner.getVictories() + " victories !");
    }
}