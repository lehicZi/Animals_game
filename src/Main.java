import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        int numberPlayers = 2;
        int numberRealPlayers = 1;
        int numberAIPlayers = numberPlayers-numberRealPlayers;
        String[] RealPlayersNames = new String[numberRealPlayers];
        String[] AIPlayersNames = new String[numberAIPlayers];

        for (int nameIndex = 0; nameIndex < numberRealPlayers; nameIndex++) {
            Scanner playerName = new Scanner(System.in);
            System.out.println("Please enter Player N°" + (nameIndex + 1) + "'s name.");
            RealPlayersNames[nameIndex] = playerName.next();
        }
        for (int nameIndex = 0; nameIndex < (numberAIPlayers); nameIndex++) {
            AIPlayersNames[nameIndex] = "Bot " + (nameIndex+1);
        }

        Game gameTest = new Game(numberPlayers, numberRealPlayers, RealPlayersNames, AIPlayersNames);

        Scanner starter = new Scanner(System.in);

        System.out.println("Who starts ?");
        String starterName = starter.next();

        for (Player player : gameTest.getPlayersList()) {
            if (player.getPlayerName().equals(starterName)) {
                gameTest.setOrder(player, gameTest.getPlayersList());
            }
        }

        gameTest.playersFight();
        Player finalWinner = gameTest.findFinalWinner(gameTest.getPlayersList());

        System.out.println(finalWinner.getPlayerName() + " wins with " + finalWinner.getVictories() + " victories !");
    }
}
