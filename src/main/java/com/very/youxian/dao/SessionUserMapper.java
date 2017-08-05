package com.very.youxian.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.very.youxian.entity.SessionUser;

@Mapper
public interface SessionUserMapper {

	@Select("SELECT * FROM session_user where session_id = #{sessionId} ")
	SessionUser findSessionUserById(@Param("sessionId") String sessionId);

	@Insert("insert into session_user(session_id,id,openid,nickname,sex,province,city,country,headimgurl,privilege,unionid,lasturl) "
			+ "values(#{sessionId},#{id},#{openid},#{nickname},#{sex},#{province},#{city},#{country},#{headimgurl},#{privilege},#{unionid},#{lastUrl})  ")
	Integer addSessionUser(SessionUser user);
	
	@Update("update session_user set id= #{id},openid = #{openid},,nickname = #{nickname},sex = #{sex},province =#{province} ,city = #{city},"
			+ "country = #{country},headimgurl = #{headimgurl},privilege = #{privilege},unionid = #{unionid},lasturl = #{lastUrl} "
			+ " where session_id = #{sessionId}")
	Integer updateSessionUser(SessionUser user);

}
