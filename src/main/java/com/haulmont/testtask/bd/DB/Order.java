package com.haulmont.testtask.bd.DB;

import java.util.Date;
import java.util.Objects;

public class Order {

    private Long id;
    private String description;
    private Client idclient;
    private Mechanic idmechanic;
    private Date dateCreature;
    private Date dateOfWork;
    private int value;
    private String Status;

    public Order() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return idclient;
    }

    public void setClient(Client idclient) {
        this.idclient = idclient;
    }

    public Mechanic getMechanic() {
        return idmechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.idmechanic = idmechanic;
    }

    public Date getDateCreature() {
        return dateCreature;
    }

    public void setDateCreature(Date dateCreature) {
        this.dateCreature = dateCreature;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return value == order.value &&
                Objects.equals(id, order.id) &&
                Objects.equals(description, order.description) &&
                Objects.equals(idclient, order.idclient) &&
                Objects.equals(idmechanic, order.idmechanic) &&
                Objects.equals(dateCreature, order.dateCreature) &&
                Objects.equals(dateOfWork, order.dateOfWork) &&
                Objects.equals(Status, order.Status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, idclient, idmechanic, dateCreature, dateOfWork, value, Status);
    }

    @Override
    public String toString() {
        return "com.haulmont.testtask.bd.DB.Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + idclient +
                ", mechanic=" + idmechanic +
                ", dateCreature=" + dateCreature +
                ", dateOfWork=" + dateOfWork +
                ", value=" + value +
                ", Status='" + Status + '\'' +
                '}';
    }
}


