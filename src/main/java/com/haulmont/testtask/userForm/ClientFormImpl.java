package com.haulmont.testtask.userForm;

import com.haulmont.testtask.bd.DB.Client;
import com.haulmont.testtask.bd.SqlCreate.SqlClient;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.List;

public class ClientFormImpl extends ClientForm  implements View {

    ClientEditFormIml clientEditFormIml;

    List<Client> clients;
    BeanItemContainer<Client> container;

    public ClientFormImpl() {
        upGrid();
        create.addClickListener(clickEvent -> {
            createRow();
        });
        update.addClickListener(clickEvent -> {
            updateRow();
        });
        delete.addClickListener(clickEvent -> {
            deleteRow();
        });
    }

    private void updateRow() {
        formUpdateCreate();
    }

    private void deleteRow() {
        Client client = new Client();
        client.setId(((Client)grid.getSelectedRow()).getId());
        new SqlClient().remove(client);
        upGrid();
    }

    private void createRow() {
        formEditCreate();
    }

    private void upGrid() {
        clients = new SqlClient().getAll();
        container =   new BeanItemContainer<>(Client.class, clients);
        grid.setContainerDataSource(container);

        grid.setColumnOrder("id","name","surname","patronymic","phone");
        /*grid.getColumn("ID").setHeaderCaption("ID");
        grid.getColumn("NAME").setHeaderCaption("Имя");
        grid.getColumn("SURNAME").setHeaderCaption("Фамилия");
        grid.getColumn("PATRONYMIC").setHeaderCaption("Отчество");
        grid.getColumn("PHONE").setHeaderCaption("Телефон");*/
    }


    private void formEditCreate(){
        final Window window = createWindows();
        clientEditFormIml.buttonClick().addClickListener(clickEvent -> {
            window.close();
            new SqlClient().add(clientEditFormIml.getClient());
            upGrid();
        });
        window.setContent(clientEditFormIml);
    }

    private void formUpdateCreate(){
        final Window window = createWindows();
        Client client = (Client) grid.getSelectedRow();
        clientEditFormIml.editForm(client);
        clientEditFormIml.buttonClick().addClickListener(clickEvent -> {
            window.close();
            new SqlClient().update(clientEditFormIml.getClient());
            upGrid();
        });
        window.setContent(clientEditFormIml);
    }

    private Window createWindows(){
        final Window window = new Window();
        window.setModal(true);
        window.center();
        UI.getCurrent().addWindow(window);
        clientEditFormIml = new ClientEditFormIml();
        return window;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
