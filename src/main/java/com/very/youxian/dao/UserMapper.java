package com.very.youxian.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user where id = #{id} ")
	User findUserById(@Param("id") String id);

	@Insert("insert into user(id,openid,nickname,sex,province,city,country,headimgurl,privilege,unionid) "
			+ "values(#{id},#{openid},#{nickname},#{sex},#{province},#{city},#{country},#{headimgurl},#{privilege},#{unionid})  ")
	Integer addUser(User user);

}
