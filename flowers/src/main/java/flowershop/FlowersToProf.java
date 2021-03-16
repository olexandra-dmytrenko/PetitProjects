package flowershop;

import java.util.List;

import model.Professor;

public class FlowersToProf {

    List<Flower> bouquet;
    Professor p;

    public FlowersToProf(List<Flower> bouquet, Professor p) {
        this.bouquet = bouquet;
        this.p = p;
    }

    public List<Flower> getBouquet() {
        return bouquet;
    }

    public Professor getP() {
        return p;
    }
}
