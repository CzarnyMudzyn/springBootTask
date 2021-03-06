package pl.smandzich.javatask.dao.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String sureName;
    private LocalDate birthDate;
    private Boolean dyslexia;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    private Clas clas;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "STUDENT_MARKS",
            joinColumns = @JoinColumn(
                    name = "STUDENT_ID",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "MARK_ID",
                    referencedColumnName = "id"
            )
    )

    private List<Marks> marks = new ArrayList<>();


    public Student() {
    }


    public Student(Long id, String firstName, String sureName, LocalDate birthDate, Boolean dyslexia, Address address, Clas clas, List<Marks> marks) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.birthDate = birthDate;
        this.dyslexia = dyslexia;
        this.address = address;
        this.clas = clas;
        this.marks = marks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getDyslexia() {
        return dyslexia;
    }

    public void setDyslexia(Boolean dyslexia) {
        this.dyslexia = dyslexia;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
