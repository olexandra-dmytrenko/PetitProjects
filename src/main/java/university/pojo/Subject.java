package university.pojo;

public class Subject {
    private String name;
    private Professor prof;

    public Subject(String math, Professor gavrylo_petrovych) {
        name = math;
        prof = gavrylo_petrovych;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", prof=" + prof +
                '}';
    }

    public String getName() {
        return name;
    }

    public Professor getProf() {
        return prof;
    }
}