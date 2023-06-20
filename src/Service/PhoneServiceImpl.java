package Service;

import DB.DataBase;
import Interface.PhoneService;
import Model.Brand;
import Model.Phone;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addPhone(List<Phone>phones) {
      dataBase.getPhones().addAll(phones);
        return "Phones added";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        Stream<Phone> stream = dataBase.getPhones().stream();
        List<Phone> collect = stream.filter(phone -> phone.getId().equals(phoneId)).collect(Collectors.toList());
        return collect.get(0);
    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        Stream<Phone> stream = dataBase.getPhones().stream();
        stream.filter(phone -> phone.getId().equals(phoneId)).forEach(phone -> phone.setName(newName));
        return getPhoneById(phoneId);
    }

    @Override
    public List<Phone> getAllPhones() {
        Stream<Phone> stream = dataBase.getPhones().stream();
        List<Phone> list = stream.toList();
        return list;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(Brand brand) {
        Stream<Phone> stream = dataBase.getPhones().stream();
        List<Phone> list = stream.filter(phone -> phone.getBrand().equals(brand)).toList();
        return list;
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        for (int i = 0; i < dataBase.getPhones().size(); i++) {
            if (dataBase.getPhones().get(i).getId().equals(phoneId)){
                dataBase.getPhones().remove(i);
            }}
        System.out.println(dataBase.getPhones());
    }
}
