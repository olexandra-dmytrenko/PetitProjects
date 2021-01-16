package flowerstoperson;

import java.awt.*;

import flowers.Bouquet;
import flowers.Flower;
import flowers.GiveFlowersServiceOnLand;
import flowers.GiveFlowersService;
import university.pojo.Professor;

public class GiveFlowersPresentation {
    public static void main(String[] args) {
        GiveFlowersService presentFlowers = new GiveFlowersServiceOnLand();
        final Bouquet roseBouquet = presentFlowers
                .createBouquet(11, new Flower("Rose", Color.RED));
        presentFlowers.giveFlowers(roseBouquet, new Professor("Maria Ivanivna"));


    }
}
