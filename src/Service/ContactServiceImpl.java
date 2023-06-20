package Service;

import DB.DataBase;
import Interface.ContactService;
import Model.Contact;
import Model.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        for (int i = 0; i < dataBase.getPhones().size(); i++) {
            if (dataBase.getPhones().get(i).getId().equals(phoneId)) {
                dataBase.getPhones().get(i).setContacts(contact);
            }
        }
        return "Контакт успешно сохранен";
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getName().equals(contactName)).toList();
        return list1.get(0);
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).toList();
        return list1.get(0);
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = new ArrayList<>(list.get(0).getContacts().stream().toList());
        list1.sort(sortByName);
        return list1;
    }

    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        list.get(0).getContacts().removeIf(contact -> contact.getName().equals(contactName));

        System.out.println("Contact is deleted");
    }

       Comparator<Contact> sortByName=new Comparator<Contact>() {
           @Override
           public int compare(Contact o1, Contact o2) {
               return o1.getName().compareTo(o2.getName());
           }
       };
}

