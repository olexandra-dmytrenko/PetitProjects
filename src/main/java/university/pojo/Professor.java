package university.pojo;

public class Professor {
    String name;

    public Professor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                '}';
    }
}