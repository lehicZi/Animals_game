public abstract class Player {

    private final String playerName;
    private final Deck playerDeck;
    private int victories = 0;
    private int order;

    public Player(String playerName, Deck playerDeck) {
        this.playerName = playerName;
        this.playerDeck = playerDeck;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public int getVictories() {
        return victories;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void incrementVictories() {
        this.victories ++;
    }

    public abstract int attributeChoice ();

    public abstract int attributeSwitch ();

    @Override
    public String toString(){
        return playerName;
    }

}
