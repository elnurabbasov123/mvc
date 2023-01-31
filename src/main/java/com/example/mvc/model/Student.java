package com.example.mvc.model;

import com.example.mvc.validation.MyRule;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Telebe adi mutleqdir!")
    @NotEmpty(message = "Telebe adi bosh olmamalidir !!!!")
    @Size(min = 2,message = "Telebe adi minimum iki simvoldan ibaret olmalidir !")
    @Size(max = 20,message = "Telebe adi maximum 20 simvol olmalidir !")
    private String name;

    @NotNull(message = "Telebe adi mutleqdir!")
    @NotEmpty(message = "Telebe soyadi bosh olmamalidir !!!!")
    @Size(min = 2,message = "Telebe soyadi minimum iki simvoldan ibaret olmalidir !")
    @Size(max = 20,message = "Telebe soyadi maximum 20 simvol olmalidir !")
    private String surname;

    @Min(value = 1,message = "Telebe sinifi minimum 1 ola biler!")
    @Max(value = 11,message = "Telebe sinifi max 11 ola biler!")
    private Integer studentClass;

    @Past(message = "Tevellud mutleq kecmish zamanda olmalidir !")
    private Date birthday;

    @Pattern(regexp = "[a-z0-9]+@[a-z0-9]+\\.[a-z]{3}",message = "Email duzgun formatda olmalidir !")
    private String email;

    @MyRule
    private String courseCode;

    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}",message = "Telefon duzgun formatda olmalidir ! \nMeselen: {055-555-5555}")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToMany
    private List<Language> languages;

    public Student(Integer id, String name, String surname, Integer studentClass, Date birthday, String email, String courseCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentClass = studentClass;
        this.birthday = birthday;
        this.email = email;
        this.courseCode = courseCode;
    }

    public Student() {
    }

    public Student(Integer id, String name, String surname, Integer studentClass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studentClass = studentClass;
    }

    public Student(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
