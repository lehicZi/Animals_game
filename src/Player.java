public class Player {

    private final String playerName;
    Deck playerDeck;
    public int victories = 0;

    public Player(String playerName, Deck playerDeck) {
        this.playerName = playerName;
        this.playerDeck = playerDeck;
    }

    public String getPlayerName() {
        return playerName;
    }
}
