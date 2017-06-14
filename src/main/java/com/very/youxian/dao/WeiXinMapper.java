package com.very.youxian.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.WeiXinUrl;

@Mapper
public interface WeiXinMapper {
	@Select(" select  name,type,url from weixin_url where name = #{name} ")
	WeiXinUrl loadByName(@Param("name") String name);
}
