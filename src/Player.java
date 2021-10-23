import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Player {

    private final String playerName;
    private Deck playerDeck;
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


}
