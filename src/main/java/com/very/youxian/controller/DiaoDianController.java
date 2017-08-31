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
import com.very.youxian.entity.DiaoDian;
import com.very.youxian.service.DiaoDianService;
import com.very.youxian.util.Pager;

@RestController
@ComponentScan
@RequestMapping("/diaodian")
public class DiaoDianController {
	@Autowired
	private  DiaoDianService diaoDianService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public Pager<DiaoDian>  diaoDianList(@RequestParam(value="pageSize",defaultValue = "10") Integer pageSize,@RequestParam(value="currentPage",defaultValue = "1") Integer currentPage,@RequestParam(value="queryString",defaultValue = "") String queryString) {

		Pager<DiaoDian> pager = new Pager<DiaoDian>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		int totalRow = diaoDianService.findDiaoDianCount(queryString);
		pager.setTotalRow(totalRow);
		List<DiaoDian> ddlst = diaoDianService.findDiaoDian(pager.getStart(),pager.getPageSize(),queryString);
		pager.setList(ddlst);
		return pager;
	}
	
	@CrossOrigin
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public DiaoDian  diaoDianDetail(@PathVariable String id) {
		if(StringUtils.isEmptyOrWhitespaceOnly(id)){
			return null;
		}
		DiaoDian  dd = diaoDianService.findDiaoDianById(id);
		return dd;
	}
}
