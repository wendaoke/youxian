package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.DiaoDian;

@Mapper
public interface DiaoDianMapper {
	@Select("select * from diaodian where province = #{province}")
	List<DiaoDian> findDiaoDianByProvince(@Param("province") String province);
	
	@Select("SELECT * FROM diaodian WHERE district like CONCAT('%','${query}','%' ) or name like CONCAT('%','${query}','%' )  LIMIT #{start} , #{length} ")	
	List<DiaoDian> findDiaoDian(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM diaodian WHERE district like CONCAT('%','${query}','%' )  or name like CONCAT('%','${query}','%' )  ")	
	Integer findDiaoDianCount(@Param("query") String query);

	
	@Select("select * from diaodian where id = #{id}")
	DiaoDian findDiaoDianById(@Param("id") String id);
	

	
}
	