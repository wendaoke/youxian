package com.very.youxian.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.ImageStoreMapper;
import com.very.youxian.dao.SecondHandMapper;
import com.very.youxian.entity.SecondHand;

@Component
public class SecondHandService {
	@Autowired
private SecondHandMapper secondHandMapper;
	@Autowired
	private	ImageStoreMapper imageStoreMapper;
	public SecondHand findSecondHandById(String id){
		return secondHandMapper.findSecondHandById(id);
	}
	public Integer addSecondHand(SecondHand secondHand){
		secondHand.setUpdate_time(new Timestamp(System.currentTimeMillis()));
		return secondHandMapper.addSecondHand(secondHand);
	}
	public Integer updateSecondHand(SecondHand secondhand){
		secondhand.setUpdate_time(new Timestamp(System.currentTimeMillis()));
		return secondHandMapper.updateSecondHand(secondhand);
	}
	
	public Integer findCountSecondHandByCreator(String creator ){
		return secondHandMapper.findCountSecondHandByCreator(creator);
	}
	public List<SecondHand> findSecondHandByCreator(String creator,Integer start,Integer length){
		return secondHandMapper.findSecondHandByCreator(creator, start,length);
	}
	
	public List<SecondHand> findSecondHand(String query,Integer start, Integer length){
		return secondHandMapper.findSecondHand(query, start, length);
	}
	
	public Integer findSecondHandCount(String query){
		return secondHandMapper.findSecondHandCount(query);
	}
	public List<SecondHand> findRecommendedSecondHand(){
		return secondHandMapper.findRecommendedSecondHand();
	}
		
	
}
