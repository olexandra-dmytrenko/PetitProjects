package ua.kpi.tef.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "DEPARTMENT")
public class MyDepartment {

    public static final Subject SUBJECT_MATH = new Subject("Math", new Professor("Gavrylo Petrovych"));
    public static final Subject SUBJECT_SCI = new Subject("Science", null);
    private static AtomicLong idCounter = new AtomicLong(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    public MyDepartment(String depName) {
        id = idCounter.incrementAndGet();
        this.name = depName;
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