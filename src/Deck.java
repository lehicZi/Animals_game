import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Animal> listCards = new ArrayList<>();

    public int getNumberCards() {
        return listCards.size();
    }

    public List<Animal> getListCards() {
        return listCards;
    }

    public void addCard(Animal animal){
        listCards.add(animal);
    }

    public void shuffleDeck(){
        List<Animal> shuffledDeck = new ArrayList<>(this.listCards);
        Collections.shuffle(shuffledDeck);
        this.listCards = shuffledDeck;
    }
}
