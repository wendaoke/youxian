package com.very.youxian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.entity.DiaoHuo;
import com.very.youxian.service.DiaoHuoService;
import com.very.youxian.util.Pager;

@RestController
@ComponentScan
@RequestMapping("/diaohuo")
public class DiaoHuoController {
	@Autowired
	private  DiaoHuoService diaoHuoService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public Pager<DiaoHuo>  diaoHuoList(@RequestParam("pageSize") Integer pageSize,@RequestParam("currentPage") Integer currentPage,@RequestParam("queryString") String queryString) {

		Pager<DiaoHuo> pager = new Pager<DiaoHuo>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		int totalRow = diaoHuoService.findDiaoHuoCount(queryString);
		pager.setTotalRow(totalRow);
		List<DiaoHuo> ddlst = diaoHuoService.findDiaoHuo(pager.getStart(),pager.getPageSize(),queryString);
		pager.setList(ddlst);
		return pager;
	}
	
	@CrossOrigin
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public DiaoHuo  diaoHuoDetail(@PathVariable String id) {
		if(StringUtils.isEmptyOrWhitespaceOnly(id)){
			return null;
		}
		DiaoHuo  dd = diaoHuoService.findDiaoHuoById(id);
		return dd;
	}
	
	@CrossOrigin
	@RequestMapping("/recommend")
	@ResponseBody
	public List<DiaoHuo>  diaoHuoRecommend() {
		List<DiaoHuo>  dd = diaoHuoService.findRecommendedDiaoHuo();
		return dd;
	}
}
