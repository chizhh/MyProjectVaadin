package com.haulmont.testtask.bd.DB;

import java.util.Objects;

public class Mechanic {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String payment;

    public Mechanic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(id, mechanic.id) &&
                Objects.equals(name, mechanic.name) &&
                Objects.equals(surname, mechanic.surname) &&
                Objects.equals(patronymic, mechanic.patronymic) &&
                Objects.equals(payment, mechanic.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, payment);
    }

    @Override
    public String toString() {
        return "DB.Mechanic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}



