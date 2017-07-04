package com.very.youxian.service;

import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.dao.DiaoHuoMapper;
import com.very.youxian.dao.ImageStoreMapper;
import com.very.youxian.entity.DiaoHuo;
import com.very.youxian.entity.ImageStore;

@Component
public class DiaoHuoService {
	@Autowired
	private DiaoHuoMapper diaoHuoMapper;
	@Autowired
	private ImageStoreMapper imageStoreMapper;

	public List<DiaoHuo> findDiaoHuo(Integer start, Integer length, String query) {
		return diaoHuoMapper.findDiaoHuo(query, start, length);
	}

	public Integer findDiaoHuoCount(String query) {
		return diaoHuoMapper.findDiaoHuoCount(query);
	}

	public DiaoHuo findDiaoHuoById(String id) {
		if (StringUtils.isEmptyOrWhitespaceOnly(id)) {
			return null;
		}
		DiaoHuo dd = this.diaoHuoMapper.findDiaoHuoById(id);
		dd.setImages(imageStoreMapper.findImageByItemId(dd.getId()));
		return dd;
	}

	public List<DiaoHuo> findRecommendedDiaoHuo() {
		List<DiaoHuo> dhl = diaoHuoMapper.findRecommendedDiaoHuo();
		for (DiaoHuo dh : dhl) {
			List<ImageStore> imglst = imageStoreMapper.findImageByItemId(dh.getId());
			if (CollectionUtils.isEmpty(imglst) || imglst.size() == 0) {
				dh.setThumbnail("");
			} else {
				dh.setThumbnail(imglst.get(0).getImageName());
			}

		}
		return dhl;
	}

}
