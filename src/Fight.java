import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Fight {
    public static Animal animalFight (Animal animal1, Animal animal2) {
        String effectiveAttribute = askAttribute();
        if (animal1.getAttribute(effectiveAttribute) > animal2.getAttribute(effectiveAttribute)) {
            return animal1;
        } else if (animal1.getAttribute(effectiveAttribute) < animal2.getAttribute(effectiveAttribute)) {
            return animal2;
        } else {
            if (animal1.getRarete() > animal2.getRarete()){
                return animal1;
            }
            else if (animal1.getRarete() < animal2.getRarete()) {
                return animal2;
            }
            else {
                return animal1; }
            }
            }
    private static String askAttribute () {
        Scanner userChoice = new Scanner(System.in);
        System.out.println("Please enter the chose the attribute (1 : poids, 2 : longueur, 3 : longévité, 4 : Gestation/incubation)");
        return userChoice.next();
    }


//    private static String askAttributeGUI (){
//        final String[] userChoice = new String[1];
//        JFrame frameAsk = new JFrame("Choix attriut");
//
//        JButton buttonPoids = new JButton("Poids");
//        //Définir la position du bouton
//        buttonPoids.setBounds(10,10,100,40);
//
//        buttonPoids.addActionListener(e -> userChoice[0] = "1");
//
//        JButton buttonLongueur = new JButton("Longueur");
//        //Définir la position du bouton
//        buttonLongueur.setBounds(10,60,100,40);
//
//        buttonLongueur.addActionListener(e -> userChoice[0] = "2");
//
//        JButton buttonLongevite = new JButton("Longévité");
//        //Définir la position du bouton
//        buttonLongevite.setBounds(10,110,100,40);
//
//        buttonLongevite.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e) {
//                userChoice[0] = "3";}
//            });
//
//        JButton buttonGestationIncubation = new JButton("Gestation/incubation");
//        //Définir la position du bouton
//        buttonGestationIncubation.setBounds(10,160,100,40);
//
//        buttonGestationIncubation.addActionListener(e -> userChoice[0] = "4");
//        frameAsk.add(buttonGestationIncubation);
//        frameAsk.add(buttonLongevite);
//        frameAsk.add(buttonPoids);
//        frameAsk.add(buttonLongueur);
//        frameAsk.setSize(300,300);
//        frameAsk.setLayout(null);
//        frameAsk.setVisible(true);
//        return userChoice[0];
//    }

}
