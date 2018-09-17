package com.haulmont.testtask;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI{

    @Override
    protected void init(VaadinRequest request) {
        Menu menu = new Menu();
       // ClientImp ci = new  ClientImp ();
       // VerticalLayout layout = new VerticalLayout();
        //layout.setSizeFull();
        //layout.setMargin(true);
    //layout.addComponent(ci);
       // layout.addComponent(new Label("Main UI"));
        //setContent(layout);
       // setContent(ci);
        // Content for the PopupView
        setContent(menu);


    }
}