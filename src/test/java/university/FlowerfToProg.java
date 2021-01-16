package university;

import java.util.List;

import flowers.Flower;
import university.pojo.Professor;

public class FlowerfToProg {

    List<Flower> bouquet;
    Professor p;

    public FlowerfToProg(List<Flower> bouquet, Professor p) {
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
