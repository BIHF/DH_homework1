package com.deajun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deajun.dao.BoardDAO;

@Service("boardService")
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public int getCount() {
		return boardDAO.countBoard();
	}
}
