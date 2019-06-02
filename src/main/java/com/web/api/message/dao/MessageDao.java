package com.web.api.message.dao;

import com.web.api.message.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xingding on 19/6/2.
 */
@Mapper
public interface MessageDao {

    @Insert("insert into message(id, send_user_id, send_name, send_employee_no, object_id,title,content,type,created_name,created_time) " +
            "values (#{id},#{sendUserId},#{sendName}, #{sendEmployeeNo},#{objectId},#{title},#{content}," +
            "#{type},#{createdName},#{createdTime})")
    int insert(Message message);
}
