import java.util.ArrayList;
import java.util.List;

public class Deck {

    private int numberCards;
    List<Animal> listCards = new ArrayList<>();

    public Deck() {
        numberCards = listCards.size();
    }

    public int getNumberCards() {
        return numberCards;
    }
}
