package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.Comment;

@Mapper
public interface CommentMapper {

	
	@Select("SELECT * FROM hahadiaoyu_comment WHERE type = #{type} and item_id =#{item_id} order by update_time desc LIMIT #{start} , #{length} ")	
	List<Comment> findComment(@Param("type") Integer type,@Param("item_id") String itemId,@Param("start") Integer start,@Param("length") Integer length);

	@Select("SELECT count(*) FROM hahadiaoyu_comment WHERE type = #{type} and item_id =#{item_id} order by update_time desc   ")	
	Integer findCommentCount(@Param("type") Integer type,@Param("item_id") String itemId);
	
	@Insert("insert into hahadiaoyu_comment (id,type,item_id,content,commentator_id,commentator_name,commentator_headimg) "
			+ "values(#{id},#{type},#{item_id},#{content},#{commentator_id},#{commentator_name},#{commentator_headimg})  ")
	Integer addComment(Comment comment);
	
}
