import DB.DataBase;
import Model.Brand;
import Model.Contact;
import Model.Phone;
import Service.ContactServiceImpl;
import Service.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Phone>phones=new ArrayList<>();
        List<Contact>contacts=new ArrayList<>();
        DataBase dataBase=new DataBase(phones,contacts);
        ContactServiceImpl contactService=new ContactServiceImpl(dataBase);
        PhoneServiceImpl phoneService=new PhoneServiceImpl(dataBase);

        Contact contact1=new Contact(10L,"Kanzhar","+996777777777");
        Contact contact2=new Contact(11L,"Nurik","+996555555555");
        Contact contact3=new Contact(12L,"Abu","+996222222222");
        System.out.println("*********WELCOME*********");
        getInfo();
        while (true){
            int num= scanner.nextInt();
            switch (num){
                case 1:
                    System.out.println(phoneService.addPhone(new ArrayList<>(List.of(new Phone(1L, "Galaxy S23", Brand.SAMSUNG),
                            new Phone(2L, "Iphone 14 PRO MAX", Brand.APPLE),
                            new Phone(3L, "Note 10", Brand.XIAOMI),
                            new Phone(4L,"Galaxy Note 20",Brand.SAMSUNG),
                            new Phone(5L,"Iphone 12",Brand.APPLE)))));
                getInfo();
                break;
                case 2: System.out.println(phoneService.getPhoneById(3L));
                getInfo();
                break;
                case 3: System.out.println(phoneService.updatePhoneNameById(1L, "S22"));
                getInfo();
                break;
                case 4: System.out.println(phoneService.getAllPhones());
                getInfo();
                break;
                case 5: System.out.println(phoneService.getAllPhonesByBrand(Brand.SAMSUNG));
                getInfo();
                break;
                case 6:phoneService.deletePhoneById(3L);
                getInfo();
                break;
                case 7: System.out.println(contactService.addContactToPhone(2L, contact1));
                getInfo();
                break;
                case 8:System.out.println(contactService.addContactToPhone(2L, contact2));
                getInfo();
                break;
                case 9:System.out.println(contactService.addContactToPhone(2L, contact3));
                getInfo();
                break;
                case 10: System.out.println(contactService.findContactByName(2L, "Abu"));
                getInfo();
                break;
                case 11: System.out.println(contactService.findContactByPhoneNumber(2L, "+996555555555"));
                getInfo();
                break;
                case 12: System.out.println(contactService.sortContactsByName(2L));
                getInfo();
                break;
                case 13: contactService.deleteContactByNameFromPhone(2L,"Kanzhar");
                getInfo();
                break;
            }
        }
        
    }
    public static void getInfo(){
        System.out.println("\nClick 1 to addPhone.......................");
        System.out.println("Click 2 to getPhoneById...................");
        System.out.println("Click 3 to updatePhoneNameById............");
        System.out.println("Click 4 to getAllPhones...................");
        System.out.println("Click 5 to getAllPhonesByBrand............");
        System.out.println("Click 6 to deletePhoneById................");
        System.out.println("Click 7 to addContactToPhone..............");
        System.out.println("Click 8 to addContactToPhone..............");
        System.out.println("Click 9 to addContactToPhone..............");
        System.out.println("Click 10 to findContactByName.............");
        System.out.println("Click 11 to findContactByPhoneNumber......");
        System.out.println("Click 12 to sortContactsByName............");
        System.out.println("Click 13 to deleteContactByNameFromPhone..");
    }
}