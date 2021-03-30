package ua.kpi.tef.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PROFESSOR")
@ToString(exclude = {"subjects"})
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToMany(mappedBy = "professor", orphanRemoval = false)
    private List<Subject> subjects;

    public Professor(String name) {
        this.name = name;
    }
}