public class Main {

    public static void main(String[] arg){
    Game gameTest = new Game(2);
    Player j1 = new Player("j1", gameTest.deal());
    Player j2 = new Player("j2", gameTest.deal());
        for (int currentFight =0; currentFight < gameTest.getNumberCardsPerplayer(); currentFight++){
            System.out.println(j1.playerDeck.listCards.get(currentFight).getNom() + " VS " + j2.playerDeck.listCards.get(currentFight).getNom());
            System.out.println(j1.playerDeck.listCards.get(currentFight));
            Animal winnerAnimal = Fight.animalFight(j1.playerDeck.listCards.get(currentFight),j2.playerDeck.listCards.get(currentFight));
            if (winnerAnimal == j1.playerDeck.listCards.get(currentFight)) {
                j1.victories += 1;
            }
            else {
                j2.victories +=1;
            }
            System.out.println(winnerAnimal.getNom() + " wins.");
        }
        if (j1.victories > j2.victories){
            System.out.println(j1.getPlayerName() + " wins with " + j1.victories + " victories !");
        }
        else{
            System.out.println(j2.getPlayerName() + " wins with " + j2.victories + " victories !");
        }
//        System.out.println("Deck j1 :");
//        for (Animal i : j1.playerDeck.listCards){
//            System.out.println(i.getNom());}
//        System.out.println("Deck j2 :");
//        for (Animal i : j2.playerDeck.listCards){
//            System.out.println(i.getNom());}

    }
}
