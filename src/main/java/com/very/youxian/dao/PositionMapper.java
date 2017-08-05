package com.very.youxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.very.youxian.entity.City;

@Mapper
public interface PositionMapper {
	@Select("select id,province_id as provinceId,city_id as cityId,city_name as cityName from position_city where city_name like  '%${cityName}%' ")
	List<City> findCityByName(@Param("cityName") String cityName);
	
}
	