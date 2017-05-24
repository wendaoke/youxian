package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.DiaoDian;
import com.very.youxian.entity.DiaoDianImage;

@Mapper
public interface DiaoDianMapper {
	@Select("select * from hahadiaoyu_diaodian where province = #{province}")
	List<DiaoDian> findDiaoDianByProvince(@Param("province") String province);
	
	@Select("SELECT * FROM hahadiaoyu_diaodian WHERE district like CONCAT('%','${query}','%' )   LIMIT #{start} , #{length} ")	
	List<DiaoDian> findDiaoDian(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM hahadiaoyu_diaodian WHERE district like CONCAT('%','${query}','%' )   ")	
	Integer findDiaoDianCount(@Param("query") String query);

	Integer findCommentCount();
	
	@Select("select * from hahadiaoyu_diaodian where id = #{id}")
	DiaoDian findDiaoDianById(@Param("id") String id);
	@Select("select * from hahadiaoyu_diaodianimage where diaodian_id = #{diaodian_id}")
	List<DiaoDianImage> findDiaoDianImages(@Param("diaodian_id") String diaodian_id);
	
}
