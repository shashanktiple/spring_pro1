package com.example.demo.edu_class;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class School {

    @Id
    @SequenceGenerator(
            name = "school_sequence",
            sequenceName = "school_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "school_sequence"
    )

    private Integer id;
    private String name;
    private String address;
    @Transient
    private Integer age;
    private LocalDate founded;

    public School(Integer id,String  name, String address, Integer age, LocalDate founded) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.founded = founded;
    }
    public School(String  name, String address, LocalDate founded) {
        this.name = name;
        this.address = address;
        this.founded = founded;
    }
    public School() {}

    //-----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return Period.between(this.founded, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String toString() {
        return "School{"+"id=" + id + "name=" + name + ", address=" + address + ", age=" + age + ", founded=" + founded +'}';
    }
}
