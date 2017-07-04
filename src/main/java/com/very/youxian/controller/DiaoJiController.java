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
import com.very.youxian.entity.DiaoJi;
import com.very.youxian.service.DiaoJiService;
import com.very.youxian.util.Pager;

@RestController
@ComponentScan
@RequestMapping("/diaoji")
public class DiaoJiController {
	@Autowired
	private DiaoJiService service;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}

	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public Pager<DiaoJi> DiaoJiList(@RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage, @RequestParam("queryString") String queryString) {

		Pager<DiaoJi> pager = new Pager<DiaoJi>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		int totalRow = service.findDiaoJiCount(queryString);
		pager.setTotalRow(totalRow);
		List<DiaoJi> ddlst = service.findDiaoJi(pager.getStart(), pager.getPageSize(), queryString);
		pager.setList(ddlst);
		return pager;
	}

	@CrossOrigin
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public DiaoJi DiaoJiDetail(@PathVariable String id) {
		if (StringUtils.isEmptyOrWhitespaceOnly(id)) {
			return null;
		}
		DiaoJi dd = service.findDiaoJiById(id);
		return dd;
	}

	@CrossOrigin
	@RequestMapping("/recommend")
	@ResponseBody
	public List<DiaoJi> findRecommendDiaoJi() {
		List<DiaoJi> dd = service.findRecommendDiaoJi();
		return dd;
	}
}
