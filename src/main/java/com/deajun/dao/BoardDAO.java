package com.deajun.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired(required=true)
	protected SqlSessionTemplate sqlSession;	
	
	public int countBoard() {
		try {
			System.out.println(sqlSession.selectOne("board.selectBoard"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 1;
	}
}
