package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.SecondHand;

@Mapper
public interface SecondHandMapper {


	@Insert("insert into secondhand(id,title,content,province,city,area,address,contact_way,contact_info,status,creator,update_time) "
			+ "values(#{id},#{title},#{content},#{province},#{city},#{area},#{address},#{contactWay},#{contactInfo},#{status},#{creator},#{updateTime})  ")
	Integer addSecondHand(SecondHand secondhand);
	
	@Select("SELECT * FROM secondhand where creator = #{creator} ")
	List<SecondHand> findSecondHandByCreator(@Param("creator") String creator);

	@Select("SELECT * FROM secondhand WHERE area like CONCAT('%','${query}','%' )   LIMIT #{start} , #{length} ")	
	List<SecondHand> findSecondHand(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM secondhand WHERE area like CONCAT('%','${query}','%' )   ")	
	Integer findSecondHandCount(@Param("query") String query);

	
	@Select("select * from secondhand where id = #{id}")
	SecondHand findSecondHandById(@Param("id") String id);
	
	@Select("SELECT * FROM secondhand WHERE recommend = 1 ORDER BY update_time DESC LIMIT 3 ")
	List<SecondHand> findRecommendedSecondHand();
	
}
