package com.haulmont.testtask.bd.Dao;


import com.haulmont.testtask.bd.DB.Client;

import java.sql.SQLException;
import java.util.List;

public interface DaoClient {

    void add(Client client) throws SQLException;

    List<Client> getAll() ;

    Client getById(Long id);

    void update(Client client);

    void remove(Client client) throws SQLException;


}

