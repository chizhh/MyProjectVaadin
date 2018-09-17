package com.haulmont.testtask.bd.Dao;


import com.haulmont.testtask.bd.DB.Client;
import com.haulmont.testtask.bd.DB.Mechanic;
import com.haulmont.testtask.bd.DB.Order;

import java.util.List;

public interface DaoOrder {

    void add(Order order);

    List<Order> getAll();

    Order getById(Client idclient, Mechanic idmechanic);

    void update(Order order);

    void remove(Order order);


}

