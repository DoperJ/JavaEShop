package com.doperj.user.dao;

import com.doperj.user.domain.LoginTicket;
import com.doperj.user.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginTicketMapper {
    String TABLE_NAME = " t_login_ticket ";
    String INSERT_FIELDS = " user_id, expired, ticket ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    int deleteByPrimaryKey(Integer id);

    int insert(LoginTicket record);

    int insertSelective(LoginTicket record);

    @Insert({"insert into", TABLE_NAME,"(",INSERT_FIELDS,") values (#{userId},#{expired},#{ticket})"})
    void insertLoginTicket(LoginTicket loginTicket);

    LoginTicket selectByPrimaryKey(Integer id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}"})
    LoginTicket selectByUserId(Integer id);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    int updateByPrimaryKeySelective(LoginTicket record);

    int updateByPrimaryKey(LoginTicket record);

    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteById(int id);

}