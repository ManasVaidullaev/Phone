package Interface;

import Model.Brand;
import Model.Phone;

import java.util.List;

public interface PhoneService {
     String addPhone(List<Phone>phones);
//        // with stream
     Phone getPhoneById(Long phoneId);
//        // with stream
     Phone updatePhoneNameById(Long phoneId, String newName);
//        // with stream
     List<Phone> getAllPhones();
//        // with stream
     List<Phone> getAllPhonesByBrand(Brand brand);
     void deletePhoneById(Long phoneId);
}
