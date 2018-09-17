package com.haulmont.testtask.bd.Dao;


import com.haulmont.testtask.bd.DB.Mechanic;

import java.util.List;

public interface DaoMechanic {

    void add(Mechanic mechanic);

    List<Mechanic> getAll();

    Mechanic getById(Long id);

    void update(Mechanic mechanic);

    void remove(Mechanic mechanic);

}
