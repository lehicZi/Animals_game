import java.util.Scanner;

public class Fight {
    public static Animal animalFight (Animal animal1, Animal animal2){
        String effectiveAttribute = AskAttribute();
        if (animal1.GetAttribute(effectiveAttribute) > animal2.GetAttribute(effectiveAttribute)){
            return animal1;
        }
        else {
            return animal2;
        }
    }
    public static String AskAttribute (){
        Scanner userChoice = new Scanner(System.in);
        System.out.println("Please enter the chose the attribute (1 : poids, 2 : longueur, 3 : longévité, 4 : Gestation/incubation)");
        String choice = userChoice.next();
        return choice;
    }

}
