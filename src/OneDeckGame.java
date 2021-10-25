import constant.Rarete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneDeckGame extends Game{

    public OneDeckGame(int numberPlayers, int numberRealPlayers, String[] realPlayersNames) {
        super(numberPlayers, numberRealPlayers, realPlayersNames);
    }

    @Override
    public void playersFight(){

        for (int currentFight = 0; currentFight < numberCardsPerplayer; currentFight++) {
            List<Animal> fightingAnimals = new ArrayList<>();
            StringBuilder annonce = new StringBuilder();
            Player starter = playersList.get(0);

            for (int playerIndex = 0; playerIndex < numberPlayers; playerIndex++) {
                Player currentPlayer = playersList.get(playerIndex);
                Animal currentAnimal = currentPlayer.getPlayersInitialDeck().getListCards().get(currentFight);
                fightingAnimals.add(currentAnimal);
                if (currentPlayer.getOrder() == 1){
                    starter = currentPlayer;
                }
                if (playerIndex == numberPlayers - 1) {
                    annonce.append(currentPlayer).append("'s ").append(currentAnimal.getNom());
                } else {
                    annonce.append(currentPlayer).append("'s ").append(currentAnimal.getNom()).append(" VS ");
                }

            }

//            System.out.println(annonce);
            for (Player player : realPlayersList){
                System.out.println(player.getPlayersInitialDeck().getListCards().get(currentFight));
            }

            int codeEffectiveAttribute = starter.attributeChoice();

            Animal startersAnimal = starter.getPlayersInitialDeck().getListCards().get(currentFight);

            System.out.println(starter + " chose " + startersAnimal.getAttributesName(codeEffectiveAttribute));

            // Partie changement d'attribut

            List <Player> orderedPlayersList = orderPlayersList();
            for (int notStarters = 1; notStarters < numberPlayers; notStarters ++ ){
                Player notStarter = orderedPlayersList.get(notStarters);
                Animal notStartersAnimal = notStarter.getPlayersInitialDeck().getListCards().get(currentFight);
                System.out.println(notStarter);
                if (notStartersAnimal.getRarete() > 0){
                    if (orderPlayersList().get(notStarters).switchAttributeProposal()){
                        int tentativeCodeEffectiveAttribute = notStarter.attributeSwitch();
                        if (notStartersAnimal.getRarete() > startersAnimal.getRarete()){
                            starter = notStarter;
                            startersAnimal = notStartersAnimal;
                            codeEffectiveAttribute = tentativeCodeEffectiveAttribute;
                            System.out.println(notStarter + " changed the effective attribute and chose " + notStartersAnimal.getAttributesName(codeEffectiveAttribute));
                        }
                        else {
                            System.out.println("Sorry  " + notStarter + ", you can't change the effective attribute because your " + notStartersAnimal.getNom() +"'s rareté is " + Rarete.nameRarete(notStartersAnimal.getRarete()) + " while " + starter + "'s " + startersAnimal.getNom() +"'s rareté is " + Rarete.nameRarete(startersAnimal.getRarete()));
                        }
                    }
                }

            }

            // Partie changement d'attribut

            Animal animalWinner = Fight.animalFight(codeEffectiveAttribute, fightingAnimals);
//            System.out.println(animalWinner);
            Player playerWinner = animalWinner.getOwner();
//            System.out.println(playerWinner);

            giveOrder(playerWinner, playersList);

//            System.out.println(orderPlayersList());

            System.out.println("The fight was " + annonce);
            System.out.println(animalWinner.getOwner() + " wins with his " + animalWinner.getNom());

            playerWinner.incrementVictories();

            Scanner block = new Scanner(System.in);
            System.out.println("Please tap any thing to pursue.");
            block.next();
        }
    }




}
