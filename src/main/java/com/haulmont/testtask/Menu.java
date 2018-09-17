package com.haulmont.testtask;

import com.haulmont.testtask.mechanicForm.MechanicFormImp;
import com.haulmont.testtask.orderForm.OrderFormImp;
import com.haulmont.testtask.userForm.ClientEditFormIml;
import com.haulmont.testtask.userForm.ClientForm;
import com.haulmont.testtask.userForm.ClientFormImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class Menu extends VerticalLayout implements View {
    public Menu() {
        TabSheet tabsheet = new TabSheet();
        addComponent(tabsheet);

        VerticalLayout tab1 = new VerticalLayout();
        tab1.addComponent(new ClientFormImpl());
        tab1.setCaption("Клиент");
        tabsheet.addTab(tab1);


//This tab gets its caption from the component caption
        VerticalLayout tab2 = new VerticalLayout();
       tab2.addComponent(new MechanicFormImp());
        tab2.setCaption("Механик");
      tabsheet.addTab(tab2);

      VerticalLayout tab3 = new VerticalLayout();
       tab3.addComponent(new OrderFormImp());
        tab3.setCaption("Заказ");
       tabsheet.addTab(tab3);
    }

        @Override
        public void enter (ViewChangeListener.ViewChangeEvent viewChangeEvent){

        }
    }
