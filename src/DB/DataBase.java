package DB;

import Model.Contact;
import Model.Phone;

import java.util.List;

public class DataBase {
    private List<Phone>phones;
    private List<Contact>contacts;

    public DataBase(List<Phone> phones, List<Contact> contacts) {
        this.phones = phones;
        this.contacts = contacts;
    }

    public DataBase() {
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "phones=" + phones +
                ", contacts=" + contacts +
                '}';
    }
}
