package com.haulmont.testtask.bd.SqlCreate;

import com.haulmont.testtask.bd.BusinessLogic.Util;
import com.haulmont.testtask.bd.DB.Client;
import com.haulmont.testtask.bd.DB.Mechanic;
import com.haulmont.testtask.bd.DB.Order;
import com.haulmont.testtask.bd.Dao.DaoOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlOrder implements DaoOrder {


    @Override
    public void add(Order order) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO ORDER(DESCRIPTION,ID_CLIENT,ID_MECHANIC,DATECREATURE,DATEOFWORK,VALUE,STATUS) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, order.getDescription());
           // ps.setLong(2, order.getIdclient());
           // ps.setLong(3, order.getIdmechanic());
            ps.setDate(4, (Date) order.getDateCreature());
            ps.setDate(5, (Date) order.getDateOfWork());
            ps.setInt(6, order.getValue());
            ps.setString(7, order.getStatus());
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
    public List<Order> getAll() {

        Connection con = Util.connection();
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT ID, DESCRIPTION,ID_CLIENT,ID_MECHANIC,DATECREATURE,DATEOFWORK,VALUE,STATUS FROM ORDER";
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                SqlClient client = new SqlClient();
                SqlMechanic mechanic = new SqlMechanic();
                order.setId(resultSet.getLong("ID"));
                order.setDescription(resultSet.getString("DESCRIPTION"));
                order.setClient(client.getById( resultSet.getLong("ID_CLIENT")));
                order.setMechanic(mechanic.getById(resultSet.getLong("ID_MECHANIC")));
                order.setDateCreature(resultSet.getDate("DATECREATURE"));
                order.setDateCreature(resultSet.getDate("DATEOFWORK"));
                order.setValue(resultSet.getInt("VALUE"));
                order.setStatus(resultSet.getString("STATUS"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orderList;
    }


    @Override
    public Order getById(Client idclient, Mechanic idmechanic) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "SELECT  ID, DESCRIPTION,ID_CLIENT,ID_MECHANIC,DATECREATURE,DATEOFWORK,VALUE,STATUS  FROM ORDER WHERE ID_CLIENT=?,ID_MECHANIC=? ";
        Order order = new Order();
        Client client = new Client();
        Mechanic mechanic = new Mechanic();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, idclient);
           ps.setObject(2,idmechanic);
            ResultSet resultSet = ps.executeQuery();
           order.setId(resultSet.getLong("ID"));
            order.setDescription(resultSet.getString(" DESCRIPTION"));
            //order.setClient(client.getId());
            //order.setIdmechanic(resultSet.getLong("ID_MECHANIC"));
            order.setDateCreature(resultSet.getDate("DATECREATURE"));
            order.setDateCreature(resultSet.getDate("DATEOFWORK"));
            order.setValue(resultSet.getInt("VALUE"));
            order.setStatus(resultSet.getString("STATUS"));
            ps.executeUpdate();
        }
        catch (SQLException e) {
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

    return order;

    }

    @Override
    public void update(Order order) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "UPDATE ORDER SET DESCRIPTION=?,ID_CLIENT=?,ID_MECHANIC=?,DATECREATURE=?,DATEOFWORK=?,VALUE=?,STATUS=?  WHERE ID=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, order.getDescription());
           // preparedStatement.setLong(2, order.getIdclient());
          //  preparedStatement.setLong(3, order.getIdmechanic());
            preparedStatement.setDate(4, (Date) order.getDateCreature());
            preparedStatement.setDate(5, (Date) order.getDateOfWork());
            preparedStatement.setInt(6, order.getValue());
            preparedStatement.setString(7, order.getStatus());
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
    public void remove(Order order) {
        Connection con = Util.connection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM ORDER WHERE ID =?";

        try {
            ps=con.prepareStatement(sql);
            ps.setLong(1,order.getId());
            ps.executeUpdate();
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
}
