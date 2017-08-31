package com.very.youxian.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.very.youxian.entity.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user where id = #{id} ")
	User findUserById(@Param("id") String id);
	
	@Select("SELECT * FROM user where openId = #{openid} ")
	User findUserByOpenId(@Param("openid") String openid);

	@Insert("insert into user(id,openid,nickname,sex,province,city,country,headimgurl,privilege,unionid) "
			+ "values(#{id},#{openid},#{nickname},#{sex},#{province},#{city},#{country},#{headimgurl},#{privilege},#{unionid})  ")
	Integer addUser(User user);
	
	@Update("update user set openid = #{openid},nickname = #{nickname},sex = #{sex},province =#{province} ,city = #{city},"
			+ "country = #{country},headimgurl = #{headimgurl},privilege = #{privilege},unionid = #{unionid}"
			+ " where openid = #{openid}")
	Integer updateUser(User user);

}
