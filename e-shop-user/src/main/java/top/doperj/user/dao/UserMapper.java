package top.doperj.user.dao;

import top.doperj.user.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    String TABLE_NAME = " t_user ";
    String INSERT_FIELDS = " user_name, e_mail, password, phone, salt, head_url, role ";
    String SELECT_FIELDS = " user_id, " + INSERT_FIELDS;

    int deleteByPrimaryKey(Integer userId);

    @Delete({"delete from", TABLE_NAME, "where userName=#{name}"})
    void deleteByUserName(String name);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME})
    List<User> selectAllUser();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_name=#{userName}"})
    User selectByName(String userName);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where e_mail=#{eMail}"})
    User selectByEMail(String eMail);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}