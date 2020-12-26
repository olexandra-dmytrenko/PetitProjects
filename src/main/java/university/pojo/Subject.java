package university.pojo;

public class Subject {
    private String name;
    private Professor prof;

    public Subject(String math, Professor profName) {
        name = math;
        prof = profName;
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