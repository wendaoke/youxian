package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.very.youxian.entity.SecondHand;

@Mapper
public interface SecondHandMapper {


	@Insert("insert into secondhand(id,title,content,province,city,area,address,contact_way,contact_info,status,creator,update_time) "
			+ "values(#{id},#{title},#{content},#{province},#{city},#{area},#{address},#{contactWay},#{contactInfo},#{status},#{creator},#{update_time})  ")
	Integer addSecondHand(SecondHand secondhand);
	
	@Update("update secondhand set title = #{title} ,content = #{content},province = #{province},city = #{city},area = #{area},address = #{address},"
			+ "contact_way =#{contactWay},contact_info =#{contactInfo},status = #{status},creator = #{creator},update_time = #{update_time} where id = #{id}")
	Integer updateSecondHand(SecondHand secondhand);
	
	@Select("SELECT id,title,content,province,city,area,address,contact_way as contactWay,contact_info as contactInfo,status,creator,update_time FROM secondhand where creator = #{creator} LIMIT #{start} , #{length} ")	
	List<SecondHand> findSecondHandByCreator(@Param("creator") String creator,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM secondhand where creator = #{creator} ")	
	Integer findCountSecondHandByCreator(@Param("creator") String creator);
	
	@Select("SELECT id,title,content,province,city,area,address,contact_way as contactWay,contact_info as contactInfo,status,creator,update_time FROM secondhand WHERE area like CONCAT('%','${query}','%' )   LIMIT #{start} , #{length} ")	
	List<SecondHand> findSecondHand(@Param("query") String query,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM secondhand WHERE area like CONCAT('%','${query}','%' )   ")	
	Integer findSecondHandCount(@Param("query") String query);

	
	@Select("select id,title,content,province,city,area,address,contact_way as contactWay,contact_info as contactInfo,status,creator,update_time from secondhand where id = #{id}")
	SecondHand findSecondHandById(@Param("id") String id);
	
	@Select("SELECT id,title,content,province,city,area,address,contact_way as contactWay,contact_info as contactInfo,status,creator,update_time FROM secondhand WHERE recommend = 1 ORDER BY update_time DESC LIMIT 3 ")
	List<SecondHand> findRecommendedSecondHand();
	
}
