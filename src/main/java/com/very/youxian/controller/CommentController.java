package com.very.youxian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.StringUtils;
import com.very.youxian.entity.Comment;
import com.very.youxian.entity.User;
import com.very.youxian.service.CommentService;
import com.very.youxian.service.UserService;
import com.very.youxian.util.IdGenerator;
import com.very.youxian.util.Pager;

@RestController
@ComponentScan
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home() {
		return "Hello";
	}

	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public Pager<Comment> diaoDianCommentList(@RequestParam("pageSize") Integer pageSize, @RequestParam("currentPage") Integer currentPage, @RequestParam("type") Integer type,
			@RequestParam("itemId") String itemId) {

		Pager<Comment> pager = new Pager<Comment>();
		pager.setPageSize(pageSize);
		pager.setCurPage(currentPage);
		int totalRow = commentService.findCommentCount(type, itemId);
		pager.setTotalRow(totalRow);
		List<Comment> ddlst = commentService.findComment(type, itemId, pager.getStart(), pager.getPageSize());
		pager.setList(ddlst);
		return pager;
	}

	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Integer diaoDianCommentAdd(@RequestBody Comment comment) {
		String userId = comment.getCommentator_id();
		if (StringUtils.isEmptyOrWhitespaceOnly(userId)) {
			return 0;
		}
		User user = userService.findUserById(userId);
		comment.setId(IdGenerator.uuid32());
		comment.setCommentator_id(user.getId());
		comment.setCommentator_headimg(user.getHeadimgurl());
		comment.setCommentator_name(user.getNickname());
		commentService.addComment(comment);
		return 1;
	}
}
