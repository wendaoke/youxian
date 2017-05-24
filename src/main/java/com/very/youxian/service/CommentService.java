package com.very.youxian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.very.youxian.dao.CommentMapper;
import com.very.youxian.entity.Comment;

@Component
public class CommentService {
	@Autowired
	private CommentMapper mapper;

	public List<Comment> findComment(int type, String itemId, int start, int length) {
		return mapper.findComment(type, itemId, start, length);
	}

	public Integer findCommentCount(Integer type, String itemId) {
		return mapper.findCommentCount(type, itemId);
	}

	public Integer addComment(Comment comment) {
		return mapper.addComment(comment);
	}

}
