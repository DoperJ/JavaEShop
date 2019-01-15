package top.doperj.user.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.user.domain.Address;
import top.doperj.user.pojo.AddressUser;

import java.util.List;

public interface AddressMapper {
    String TABLE_NAME = " t_address ";
    String SELECT_FIELDS = " address_id, user_id, zip, province, city, district, address, phone_num, is_default, modified_time ";

    // Create
    int insert(Address record);

    int insertSelective(Address record);

    // Read
    Address selectByPrimaryKey(Integer addressId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Address> selectAllAddresses();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId}"})
    List<Address> selectByUserId(int userId);

    List<Address> selectByUserName(String userName);

    AddressUser selectUserNameByOrderId(Integer addressId);

    // Update
    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    // Delete
    int deleteByPrimaryKey(Integer addressId);

    int deleteByUserName(String userName);
}