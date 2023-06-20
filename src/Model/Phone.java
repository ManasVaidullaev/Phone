package Model;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Long id;
    private String name;
    private Brand brand;
    private List<Contact>contacts;

    public Phone(Long id, String name, Brand brand, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.contacts = contacts;
    }

    public Phone(Long id, String name, Brand brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public  void setContacts(Contact contact){
        if (this.contacts==null){
            this.contacts=new ArrayList<>();
        }
        this.contacts.add(contact);
    }

    @Override
    public String toString() {
        return "\nPhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", contacts=" + contacts +
                '}';
    }
}
