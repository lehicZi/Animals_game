import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        int numberPlayers = 2;
        int numberRealPlayers = 1;
        int numberAIPlayers = numberPlayers-numberRealPlayers;
        String[] RealPlayersNames = new String[numberRealPlayers];

        for (int nameIndex = 0; nameIndex < numberRealPlayers; nameIndex++) {
            Scanner playerName = new Scanner(System.in);
            System.out.println("Please enter Player N°" + (nameIndex + 1) + "'s name.");
            RealPlayersNames[nameIndex] = playerName.next();
        }


        Game gameTest = new Game(numberPlayers, numberRealPlayers, RealPlayersNames);

        gameTest.giveOrder(gameTest.defineStarter(),gameTest.getPlayersList());

//        for(Player player : gameTest.getPlayersList()) {
//            System.out.println(player + " plays "+player.getOrder()+"th place.");
//        }


        gameTest.playersFight();
        Player finalWinner = gameTest.findFinalWinner(gameTest.getPlayersList());

        System.out.println(finalWinner.getPlayerName() + " wins the game with " + finalWinner.getVictories() + " victories !");
    }
}
