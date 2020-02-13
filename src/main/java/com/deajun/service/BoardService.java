package com.deajun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deajun.dao.BoardDAO;
import com.deajun.vo.Board;

@Service("boardService")
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public int getCount() {
		return boardDAO.countBoard();
	}
	
	public List<Board> getBoardList() {
		return boardDAO.findAllList();
	}
	
	public double insertBoard(Board board) {
		if(boardDAO.insertBoard(board)) {
			return board.getNo();
		}else {
			return -1.0;
		} 
	}
	public boolean deleteBoard(double no) {
		return boardDAO.deleteBoard(no);
	}
}
