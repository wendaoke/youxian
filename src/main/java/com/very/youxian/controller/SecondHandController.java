package com.very.youxian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.entity.SecondHand;
import com.very.youxian.entity.SessionUser;
import com.very.youxian.entity.User;
import com.very.youxian.service.SecondHandService;
import com.very.youxian.service.SessionUserService;
import com.very.youxian.util.HttpUtil;
import com.very.youxian.util.Pager;

@RestController
@ComponentScan
@RequestMapping("/secondhand")
public class SecondHandController {
	@Autowired
	private SecondHandService secondHandService;
	@Autowired
	private SessionUserService sessionUserService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}

	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Integer addSecondHand(@RequestBody SecondHand secondhand) {
		Integer result = secondHandService.addSecondHand(secondhand);
		return result;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Integer updateSecondHand(@RequestBody SecondHand secondhand) {
		Integer result = secondHandService.updateSecondHand(secondhand);
		return result;
	}
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public Pager<SecondHand>  secondHandList(@RequestParam("pageSize") Integer pageSize,@RequestParam("currentPage") Integer currentPage,@RequestParam("queryString") String queryString) {

		Pager<SecondHand> pager = new Pager<SecondHand>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		int totalRow = secondHandService.findSecondHandCount(queryString);
		pager.setTotalRow(totalRow);
		List<SecondHand> ddlst = secondHandService.findSecondHand(queryString,pager.getStart(),pager.getPageSize());
		pager.setList(ddlst);
		return pager;
	}
	
	@CrossOrigin
	@RequestMapping("/mylist")
	@ResponseBody
	public Pager<SecondHand>  mySecondHandList(HttpServletRequest request,@RequestParam("pageSize") Integer pageSize,@RequestParam("currentPage") Integer currentPage) {

		Pager<SecondHand> pager = new Pager<SecondHand>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		String sessionUserId = HttpUtil.getSessionUser(request.getSession());
		SessionUser sUser = sessionUserService.findSessionUserById(sessionUserId);
		if(null == sUser){
			pager.setTotalRow(0);
			pager.setList(null);	
		}else{
			String creator = sUser.getId();
			int totalRow = secondHandService.findCountSecondHandByCreator(creator);
			pager.setTotalRow(totalRow);
			List<SecondHand> ddlst = secondHandService.findSecondHand(creator,pager.getStart(),pager.getPageSize());
			pager.setList(ddlst);	
		}

		return pager;
	}
	
	@CrossOrigin
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public SecondHand  secondHandDetail(@PathVariable String id) {
		if(StringUtils.isEmptyOrWhitespaceOnly(id)){
			return null;
		}
		SecondHand  dd = secondHandService.findSecondHandById(id);
		return dd;
	}
	
	@CrossOrigin
	@RequestMapping("/recommend")
	@ResponseBody
	public List<SecondHand>  queryRecommendSecondHand() {
		 List<SecondHand>   dd = secondHandService.findRecommendedSecondHand();
		return dd;
	}
	
	
}
