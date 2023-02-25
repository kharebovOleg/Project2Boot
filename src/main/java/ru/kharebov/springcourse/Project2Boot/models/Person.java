package ru.kharebov.springcourse.Project2Boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

/**
 * @author Neil Alishev
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    @NotEmpty(message = "email should not be empty")
    @Email
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Book> books;
    public Person() {
    }
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String fullName) {
        this.name = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int yearOfBirth) {
        this.age = yearOfBirth;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(email, person.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + name + '\'' +
                ", yearOfBirth=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
