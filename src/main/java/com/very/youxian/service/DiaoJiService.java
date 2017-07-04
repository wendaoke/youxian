package com.very.youxian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.dao.DiaoJiMapper;
import com.very.youxian.dao.ImageStoreMapper;
import com.very.youxian.entity.DiaoJi;

@Component
public class DiaoJiService {
	@Autowired
	private DiaoJiMapper diaoJiMapper;
	@Autowired
	private ImageStoreMapper imageStoreMapper;

	public List<DiaoJi> findDiaoJiByProvince(String province) {
		return diaoJiMapper.findDiaoJiByCategory(province);
	}

	public List<DiaoJi> findDiaoJi(Integer start, Integer length, String query) {
		return diaoJiMapper.findDiaoJi(query, start, length);
	}

	public Integer findDiaoJiCount(String query) {
		return diaoJiMapper.findDiaoJiCount(query);
	}

	public DiaoJi findDiaoJiById(String id) {
		if (StringUtils.isEmptyOrWhitespaceOnly(id)) {
			return null;
		}
		DiaoJi dd = this.diaoJiMapper.findDiaoJiById(id);
		dd.setImages(imageStoreMapper.findImageByItemId(dd.getId()));
		return dd;
	}

	public List<DiaoJi> findRecommendDiaoJi() {
		return diaoJiMapper.findRecommendDiaoJi();
	}
}
