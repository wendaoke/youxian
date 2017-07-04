package com.very.youxian.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.ImageStoreMapper;
import com.very.youxian.entity.ImageStore;

@Component
public class ImageStoreService {
	@Autowired
	private ImageStoreMapper imageStoreMapper;

	public List<ImageStore> findImageByItemId(String itemId) {
		return imageStoreMapper.findImageByItemId(itemId);
	}

	public Integer addImage(ImageStore image) {
		return imageStoreMapper.addImage(image);
	}

	public Integer deleteImageById(String id) {
		return imageStoreMapper.deleteImageById(id);
	}
	
	public Integer deleteImageByName(String itemId,String imageName){
		return imageStoreMapper.deleteImageByName(itemId, imageName);
	}
}
