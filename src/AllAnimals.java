import java.util.ArrayList;
import java.util.List;

import static constant.Rarete.*;

public class AllAnimals {

    private final ArrayList<Animal> allAnimals;

    public AllAnimals() {
        this.allAnimals = new ArrayList<>();
        instanciateAnimals();
    }

    public void instanciateAnimals() {
        Animal test = new Animal("test",2d,43d,3d,12d, ORANGE);
        Animal test2 = new Animal("test2", 2d,43d, 3d, 12d,JAUNE );
        Animal opossum = new Animal("Opossum", 4d, 0.43d, 2d, 12d,VERT);
        Animal gecko = new Animal("Gecko", 0.01d, 0.13d, 3d, 180d,VERT);
        Animal moucherolle = new Animal("Moucherolle royal", 0.016d, 0.16d, 4d, 15d, VERT);
        Animal impala = new Animal("Impala", 52d, 1.3d, 17d, 198d,VERT);

        allAnimals.add(test);
        allAnimals.add(test2);
        allAnimals.add(opossum);
        allAnimals.add(gecko);
        allAnimals.add(moucherolle);
        allAnimals.add(impala);
    }

    public List<Animal> getAllAnimals() {
        return allAnimals;
    }
}
