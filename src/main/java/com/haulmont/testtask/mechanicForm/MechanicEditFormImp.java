package com.haulmont.testtask.mechanicForm;
import com.haulmont.testtask.bd.DB.Mechanic;
import com.vaadin.ui.Button;

public class MechanicEditFormImp extends MechanicEditForm {

    private Mechanic mechanic;

    public MechanicEditFormImp() {

    }

    public Button buttonClicks(){
        return save;
    }



        public void editForm(Mechanic mechanic){
        this.mechanic = mechanic;
        this.name.setValue(mechanic.getName());
        this.surname.setValue(mechanic.getSurname());
        this.patronymic.setValue(mechanic.getSurname());
        this.payment.setValue(mechanic.getPayment());
        }

    public void clearForm() {
        this.name.setValue("");
        this.patronymic.setValue("");
        this.surname.setValue("");
        this.payment.setValue("");
    }
    public Mechanic  getMechanic(){
        Mechanic mechanic = new Mechanic();
        mechanic.setId(this.mechanic.getId());
        mechanic.setName(this.name.getValue());
        mechanic.setSurname(this.surname.getValue());
        mechanic.setPatronymic(this.patronymic.getValue());
        mechanic.setPayment(this.payment.getValue());
        return mechanic;
    }
}
