import java.util.List;

public class Fight {

    private Fight() {

    }

    public static Animal animalFight (int effectiveAttribute, List<Animal> fightingAnimals) {

        Animal winner = fightingAnimals.get(0);
//        System.out.println(effectiveAttribute);
//        System.out.println(fightingAnimals);
        for (Animal animal : fightingAnimals){
            double animalAttribute = animal.getAttribute(effectiveAttribute);
            double winnerAttribute = winner.getAttribute(effectiveAttribute);
//            System.out.println(animalAttribute);
//            System.out.println(winnerAttribute);
            if(animalAttribute > winnerAttribute){
                winner = animal;
            }
            else if (animalAttribute == winnerAttribute){
                if (animal.getRarete() > winner.getRarete()){
                    winner = animal;
                }
                else if (animal.getRarete() == winner.getRarete()){
                    if(animal.getOwner().getOrder() < winner.getOwner().getOrder()){
                        winner = animal;
                    }
                }
            }

        }
        return winner;
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
