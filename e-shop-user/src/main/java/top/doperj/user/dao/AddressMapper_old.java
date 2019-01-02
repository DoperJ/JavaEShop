package top.doperj.user.dao;

import org.apache.ibatis.annotations.Select;
import top.doperj.user.domain.Address;

import java.util.List;

public interface AddressMapper_old {
    String TABLE_NAME = " t_address ";
    String SELECT_FIELDS = " address_id, user_id, zip, province, city, district, address, is_default, modified_time ";

    // Create
    int insert(Address record);

    int insertSelective(Address record);

    // Read
    Address selectByPrimaryKey(Integer addressId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<Address> selectAllAddresses();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId}"})
    List<Address> selectByUserId(int userId);

    // Update
    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    // Delete
    int deleteByPrimaryKey(Integer addressId);
}