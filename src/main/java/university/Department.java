package university;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Department {

    private static AtomicLong idCounter = new AtomicLong(0);
    private long id;
    private String name;

    public Department(String depName) {
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
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
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