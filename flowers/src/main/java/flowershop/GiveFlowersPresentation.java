package flowershop;

import java.awt.*;

import university.model.Professor;

public class GiveFlowersPresentation {
    public static void main(String[] args) {
        GiveFlowersService presentFlowers = new GiveFlowersServiceOnLand();
        final Bouquet roseBouquet = presentFlowers
                .createBouquet(11, new Flower("Rose", Color.RED));
        presentFlowers.giveFlowers(roseBouquet, new Professor("Maria Ivanivna"));


    }
}
