package com.haulmont.testtask.userForm;
import com.haulmont.testtask.bd.DB.Client;
import com.vaadin.ui.Button;

public class ClientEditFormIml extends ClientEditForm {

private Client client;

    public ClientEditFormIml() {
    }

    public Button buttonClick() {
       return save;
    }

    public void editForm(Client client) {
        this.client = client;
       this.name.setValue(client.getName());
       this.patronymic.setValue(client.getPatronymic());
       this.surname.setValue(client.getSurname());
       this.phone.setValue(client.getPhone());
    }

    public void clearForm() {
        this.name.setValue("");
        this.patronymic.setValue("");
        this.surname.setValue("");
        this.phone.setValue("");
    }

    public Client getClient(){
        Client client = new Client();
//        client.setId(this.client.getId());
        client.setName(this.name.getValue());
        client.setSurname(this.surname.getValue());
        client.setPatronymic(this.patronymic.getValue());
        client.setPhone(this.phone.getValue());

        return client;
    }
}
