public abstract class Player {

    private final String playerName;
    private Deck playersInitialDeck;
    private Deck playersWinnedCards;
    private int victories = 0;
    private int order;

    public Player(String playerName, Deck playerDeck, Deck playersWinnedCards) {
        this.playerName = playerName;
        this.playersInitialDeck = playerDeck;
        this.playersWinnedCards = playersWinnedCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Deck getPlayersInitialDeck() {return playersInitialDeck;}

    public Deck getPlayersWinnedCards() {
        return playersWinnedCards;
    }

    public int getVictories() {
        return victories;
    }

    public int getOrder() {
        return order;
    }

    public void replaceInitialDeck(Deck currentDeck){
        this.playersInitialDeck = currentDeck;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void incrementVictories() {
        this.victories ++;
    }

    public abstract int attributeChoice ();

    public abstract boolean switchAttributeProposal();

    public abstract int attributeSwitch ();


    @Override
    public String toString(){
        return playerName;
    }

}
