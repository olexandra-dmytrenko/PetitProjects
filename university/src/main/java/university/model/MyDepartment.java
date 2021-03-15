package university.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class MyDepartment {

    public static final Subject SUBJECT_MATH = new Subject("Math", new Professor("Gavrylo Petrovych"));
    public static final Subject SUBJECT_SCI = new Subject("Science", null);
    private static AtomicLong idCounter = new AtomicLong(0);
    private long id;
    private String name;

    public MyDepartment(String depName) {
        id = idCounter.incrementAndGet();
        this.name = depName;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDepartment)) return false;
        MyDepartment that = (MyDepartment) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}