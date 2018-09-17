package com.haulmont.testtask.bd.SqlCreate;
import com.haulmont.testtask.bd.BusinessLogic.Util;
import com.haulmont.testtask.bd.DB.Mechanic;
import com.haulmont.testtask.bd.Dao.DaoMechanic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlMechanic extends Util implements DaoMechanic{



    @Override
    public void add(Mechanic mechanic) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO MECHANIC(NAME,SURNAME,PATRONYMIC,PAYMENT) VALUES(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mechanic.getName());
            ps.setString(2, mechanic.getSurname());
            ps.setString(3, mechanic.getPatronymic());
            ps.setString(4, mechanic.getPayment());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Mechanic> getAll() {
        Connection con = Util.connection();
        List<Mechanic> mechanicList = new ArrayList<>();
        String sql = "SELECT ID, NAME, SURNAME, PATRONYMIC, PAYMENT FROM MECHANIC";
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Mechanic mechanic = new Mechanic();
                mechanic.setId(resultSet.getLong("ID"));
                mechanic.setName(resultSet.getString("NAME"));
                mechanic.setSurname(resultSet.getString("SURNAME"));
                mechanic.setPatronymic(resultSet.getString("PATRONYMIC"));
                mechanic.setPayment(resultSet.getString("PAYMENT"));

                mechanicList.add(mechanic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return mechanicList;

    }

    @Override
    public Mechanic getById(Long id) {
        List<Mechanic>mechanicList = new ArrayList<>();
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "SELECT ID ,NAME,SURNAME,PATRONYMIC,PAYMENT FROM MECHANIC WHERE ID=? ";
        Mechanic mechanic = new Mechanic();
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                mechanic.setId(resultSet.getLong("ID"));
                mechanic.setName(resultSet.getString("NAME"));
                mechanic.setSurname(resultSet.getString("SURNAME"));
                mechanic.setPatronymic(resultSet.getString("PATRONYMIC"));
                mechanic.setPayment(resultSet.getString("PAYMENT"));
                ps.executeUpdate();

            } mechanicList.add(mechanic);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return mechanic;
    }
    @Override
    public void update(Mechanic mechanic) {

        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "UPDATE MECHANIC SET NAME=?,SURNAME=?,PATRONYMIC=?,PAYMENT=?  WHERE ID=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,mechanic.getName());
            preparedStatement.setString(2,mechanic.getSurname());
            preparedStatement.setString(3,mechanic.getPatronymic());
            preparedStatement.setString(4,mechanic.getPayment());
            preparedStatement.setLong(5,mechanic.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(Mechanic mechanic) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM MECHANIC WHERE ID =?";

        try {
            ps=con.prepareStatement(sql);

            ps.setLong(1,mechanic.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    }

