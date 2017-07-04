package com.very.youxian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.dao.DiaoDianMapper;
import com.very.youxian.dao.ImageStoreMapper;
import com.very.youxian.entity.DiaoDian;
@Component
public class DiaoDianService {
	@Autowired
	private DiaoDianMapper diaodDianMapper;
	@Autowired
	private	ImageStoreMapper imageStoreMapper;
	public List<DiaoDian> findDiaoDianByProvince(String province) {
		return diaodDianMapper.findDiaoDianByProvince(province);
	}

	public List<DiaoDian> findDiaoDian(Integer start,Integer length,String query) {
		return diaodDianMapper.findDiaoDian(query,start, length);
	}
	
	public Integer findDiaoDianCount(String query){
		return diaodDianMapper.findDiaoDianCount(query);
	}
	public DiaoDian findDiaoDianById(String id) {
		if(StringUtils.isEmptyOrWhitespaceOnly(id)){
			return null;
		}
		DiaoDian dd = this.diaodDianMapper.findDiaoDianById(id);
		dd.setImages(imageStoreMapper.findImageByItemId(dd.getId()));
		return dd;
	}

}
