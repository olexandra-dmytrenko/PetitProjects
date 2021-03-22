package flowershop;

import ua.kpi.tef.model.Professor;

public interface GiveFlowersService {
    Bouquet createBouquet(int flowersAmount, Flower flowerType);

    boolean giveFlowers(Bouquet bouquet, Professor person);

    default boolean findPerson(Professor person) {
        System.out.println("I'm search for " + person);
        return true;
    }
}
