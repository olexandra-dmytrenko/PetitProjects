package university;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Optional.of;

public class MyDepartment {

    public static final Subject SUBJECT_MATH = new Subject("Math", new Professor("Gavrylo Petrovych"));
    public static final Subject SUBJECT_SCI = new Subject("Science", null);
    private static AtomicLong idCounter = new AtomicLong(0);
    private long id;
    private String name;
    private List<Subject> subjects;

    public MyDepartment(String depName) {
        id = idCounter.incrementAndGet();
        this.name = depName;
        subjects = List.of(SUBJECT_MATH, SUBJECT_SCI);
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

    public Optional<Professor> getProfessorBySubject(String subjectName) {
        return of(subjectName)
                .map(s -> subjects.stream()
                        .filter(sub -> sub.getName().equals(s))
                        .findAny()
                        .map(Optional::of)
                        .orElseThrow(SubjectNotFountException::new)
                        .map(Subject::getProf)
                        .orElseThrow(ProfessorNotFountException::new)
                );
    }
}