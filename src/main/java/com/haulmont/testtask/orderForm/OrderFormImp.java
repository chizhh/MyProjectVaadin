package com.haulmont.testtask.orderForm;

import com.haulmont.testtask.bd.DB.Order;
import com.haulmont.testtask.bd.SqlCreate.SqlOrder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;

import java.util.List;

public class OrderFormImp extends OrderForm implements View {

  //  OrderFormImp orderFormImp;
    List<Order>orders;
    BeanItemContainer<Order> container;

    public OrderFormImp() {
        upGrid();

    }

    private void upGrid() {
        orders = new SqlOrder().getAll();
        container =   new BeanItemContainer<>(Order.class, orders);
        grid.setContainerDataSource(container);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
