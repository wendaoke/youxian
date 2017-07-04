package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.DiaoJi;

@Mapper
public interface DiaoJiMapper {
	@Select("select * from diaoji where category = #{category}")
	List<DiaoJi> findDiaoJiByCategory(@Param("category") String category);
	
	@Select("SELECT * FROM diaoji WHERE title like CONCAT('%','${query}','%' )   LIMIT #{start} , #{length} ")	
	List<DiaoJi> findDiaoJi(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM diaoji WHERE title like CONCAT('%','${query}','%' )   ")	
	Integer findDiaoJiCount(@Param("query") String query);

	
	@Select("select * from diaoji where id = #{id}")
	DiaoJi findDiaoJiById(@Param("id") String id);
	
	@Select("select * from diaoji WHERE recommend = 1 ORDER BY update_time DESC LIMIT 3 ")
	List<DiaoJi> findRecommendDiaoJi();
	
}
