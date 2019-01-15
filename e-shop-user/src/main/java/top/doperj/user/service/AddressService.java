package top.doperj.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.doperj.user.dao.AddressMapper;
import top.doperj.user.dao.UserMapper;
import top.doperj.user.domain.Address;
import top.doperj.user.domain.User;
import top.doperj.user.pojo.AddressUser;

import java.util.List;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AddressMapper addressDAO;

    @Autowired
    UserMapper userDAO;

    // Create
    public int addAddressByInfo(String userName, Integer zip, String province, String city, String district, String address, Boolean isDefault) {
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

    public int addAddress(Address address) {
        return addressDAO.insert(address);
    }

    // Read
    public List<Address> findAddressesByUserName(String userName) {
        return addressDAO.selectByUserName(userName);
    }

    public Address findAddressByAddressId(Integer addressId) {
        return addressDAO.selectByPrimaryKey(addressId);
    }

    public String findAddressContentByAddressId(Integer addressId) {
        Address address = addressDAO.selectByPrimaryKey(addressId);
        String addressContent = "";
        addressContent += address.getProvince() + ", " + address.getCity() + ", "
                + address.getDistrict() + ", " + address.getZip() + ", " + address.getPhoneNum();
        return addressContent;
    }

    public AddressUser findUserNameByAddress(Address address) {
        return addressDAO.selectUserNameByOrderId(address.getAddressId());
    }

    public List<Address> findAllAddresses() {
        return addressDAO.selectAllAddresses();
    }

    // Delete
    public void deleteAddressesByUserName(String userName) {
        addressDAO.deleteByUserName(userName);
    }

    public void deleteAddressByAddressId(Integer addressId) {
        addressDAO.deleteByPrimaryKey(addressId);
    }
}
