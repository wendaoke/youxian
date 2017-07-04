package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.ImageStore;

@Mapper
public interface ImageStoreMapper {

	@Select("SELECT image_id as imageId, item_id as itemId, image_name as imageName, image_desc as imageDesc FROM image_store where item_id = #{itemId} ")
	List<ImageStore> findImageByItemId(@Param("itemId") String itemId);

	@Insert("insert into image_store(image_id,item_id,image_name,image_desc) "
			+ "values(#{imageId},#{itemId},#{imageName},#{imageDesc})  ")
	Integer addImage(ImageStore image);
	
	@Delete("delete from image_store where id=#{id}")  
	Integer deleteImageById(String id);
	
	@Delete("delete from image_store where item_id=#{itemId} and image_name=#{imageName}")  
	Integer deleteImageByName(@Param("itemId") String itemId,@Param("imageName") String imageName);	
}
