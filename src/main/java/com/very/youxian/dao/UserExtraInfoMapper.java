package com.very.youxian.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.very.youxian.entity.UserExtraInfo;

@Mapper
public interface UserExtraInfoMapper {

	@Select("SELECT * FROM userextrainfo where userid = #{userid} ")
	UserExtraInfo findUserExtraInfoByUserId(@Param("userid") String userId);

	@Insert("insert into userextrainfo(id,userid,birthday,phone,postcode,address) "
			+ "values(#{id},#{userid},#{birthday},#{phone},#{postcode},#{address} ")
	Integer addUserExtraInfo(UserExtraInfo userExtraInfo);

	@Update("update userextrainfo set birthday =#{birthday},phone=#{phone},postcode=#{postcode},address=#{address} where userid = #{userid}")
	Integer updateUserExtraInfo(UserExtraInfo userExtraInfo);
}
