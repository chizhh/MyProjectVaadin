package com.haulmont.testtask.mechanicForm;

import com.haulmont.testtask.bd.DB.Mechanic;
import com.haulmont.testtask.bd.SqlCreate.SqlMechanic;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.List;

public class MechanicFormImp extends MechanicForm implements View {


    MechanicEditFormImp mechanicEditFormImp;
    List<Mechanic> mechanics;
    BeanItemContainer<Mechanic> container;

    public MechanicFormImp() {
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
        Mechanic mechanic = new Mechanic();
        mechanic.setId(((Mechanic)grid.getSelectedRow()).getId());
        new SqlMechanic().remove(mechanic);
        upGrid();
    }

    private void createRow() {
        formEditCreate();
    }

    private void upGrid() {
        mechanics = new SqlMechanic().getAll();
        container =   new BeanItemContainer<>(Mechanic.class, mechanics);
        grid.setContainerDataSource(container);
        grid.setColumnOrder("id","name","surname","patronymic","payment");
    }

    private void formEditCreate(){
        final Window window = createWindows();
        mechanicEditFormImp.buttonClicks().addClickListener(clickEvent -> {
            window.close();
            new SqlMechanic().add(mechanicEditFormImp.getMechanic());
            upGrid();
        });
        window.setContent(mechanicEditFormImp);
    }

    private void formUpdateCreate(){
        final Window window = createWindows();
        Mechanic mechanic = (Mechanic) grid.getSelectedRow();
        mechanicEditFormImp.editForm(mechanic);
        mechanicEditFormImp.buttonClicks().addClickListener(clickEvent -> {
            window.close();
            new SqlMechanic().update(mechanicEditFormImp.getMechanic());
            upGrid();
        });
        window.setContent(mechanicEditFormImp);
    }

    private Window createWindows(){
        final Window window = new Window();
        window.setModal(true);
        window.center();
        UI.getCurrent().addWindow(window);
        mechanicEditFormImp = new MechanicEditFormImp();
        return window;
    }






    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
