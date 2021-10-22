import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Animal> listCards = new ArrayList<>();

    public int getNumberCards() {
        return listCards.size();
    }

    public List<Animal> getListCards() {
        return listCards;
    }

    public void addCard(Animal animal){
        listCards.add(animal);
    }
}
