package com.deajun.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deajun.vo.Board;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired(required=true)
	protected SqlSessionTemplate sqlSession;	
	
	public int countBoard() {
		return sqlSession.selectOne("board.selectBoard");
	}
	
	public List<Board> findAllList(){
		return sqlSession.selectList("board.findAllList");
	}
	
	public boolean insertBoard(Board board) {
		return sqlSession.insert("board.insertBoard", board) == 1;
	}
	public boolean deleteBoard(double no) {
		return sqlSession.delete("board.deleteBoard", no) == 1;
	}
}
