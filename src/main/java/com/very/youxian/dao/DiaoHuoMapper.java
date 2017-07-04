package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.DiaoHuo;

@Mapper
public interface DiaoHuoMapper {
	
	@Select("SELECT * FROM diaohuo WHERE district like CONCAT('%','${query}','%' )   LIMIT #{start} , #{length} ")	
	List<DiaoHuo> findDiaoHuo(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM diaohuo WHERE district like CONCAT('%','${query}','%' )   ")	
	Integer findDiaoHuoCount(@Param("query") String query);

	
	@Select("select * from diaohuo where id = #{id}")
	DiaoHuo findDiaoHuoById(@Param("id") String id);
	
	@Select("select * from diaohuo WHERE recommend = 1 ORDER BY update_time DESC LIMIT 3 ")
	List<DiaoHuo>  findRecommendedDiaoHuo();
	
}
