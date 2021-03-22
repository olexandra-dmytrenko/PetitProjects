package flowershop;


import ua.kpi.tef.model.Professor;

public class GiveFlowersServiceOnLand implements GiveFlowersService {
    @Override
    public Bouquet createBouquet(int flowersAmount, Flower flowerType) {
        if (flowersAmount < 1) {
            throw new FlowersAmountException();
        }
        Flower[] flowers = new Flower[flowersAmount];
        for (int i = 0; i < flowersAmount; i++) {
            flowers[i] = flowerType;
        }
        return Bouquet.builder()
                .flowers(flowers)
                .addons("Grass")
                .wrapping("Paper")
                .build();
    }

    @Override
    public boolean giveFlowers(Bouquet bouquet, Professor person) {
        return findPerson(person) && present(person);
    }

    private boolean present(Professor person) {
        System.out.println("I'm presenting to " + person);
        return true;
    }


}
