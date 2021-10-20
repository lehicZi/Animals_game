import java.util.ArrayList;
import java.util.List;

public class AllAnimals {

    public List<Animal> allAnimals;

    public AllAnimals() {
        this.allAnimals = new ArrayList<>();
        instanciateAnimals();
    }

    public void instanciateAnimals() {
        Animal test = new Animal("test",2d,43d,3d,12d,2);
        allAnimals.add(test);
        Animal test2 = new Animal("test2", 2d,43d, 3d, 12d, 1 );
        allAnimals.add(test2);
        Animal opossum = new Animal("Opossum", 4d, 0.43d, 2d, 12d, 0);
        allAnimals.add(opossum);
        Animal gecko = new Animal("Gecko", 0.01d, 0.13d, 3d, 180d, 0);
        allAnimals.add(gecko);
        Animal moucherolle = new Animal("Moucherolle royal", 0.016d, 0.16d, 4d, 15d, 0);
        allAnimals.add(moucherolle);
        Animal impala = new Animal("Impala", 52d, 1.3d, 17d, 198d, 0);
        allAnimals.add(impala);
    }


}
