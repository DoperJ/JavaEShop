package top.doperj.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.user.dao.AddressMapper;
import top.doperj.user.dao.UserMapper;
import top.doperj.user.domain.Address;
import top.doperj.user.domain.User;

import java.util.List;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AddressMapper addressDAO;

    @Autowired
    UserMapper userDAO;

    // Create
    public int addAddress(String userName, Integer zip, String province, String city, String district, String address, Boolean isDefault) {
        User user = userDAO.selectByName(userName);
        if (user == null) {
            logger.error("No user named: " + userName);
            return 0;
        }
        Address address1 = new Address();
        address1.setUserId(user.getUserId());
        address1.setZip(zip);
        address1.setProvince(province);
        address1.setCity(city);
        address1.setDistrict(district);
        address1.setAddress(address);
        address1.setIsDefault(isDefault);
        return addressDAO.insert(address1);
    }

    // Read
    public List<Address> findAllAddress() {
        return addressDAO.selectAllAddresses();
    }

    public List<Address> findAddressByUserName(String userName) {
        User user = userDAO.selectByName(userName);
        if (user == null) {
            logger.error("No user named: " + userName);
            return null;
        }
        return addressDAO.selectByUserId(user.getUserId());
    }
}
