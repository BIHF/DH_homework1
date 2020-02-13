package com.deajun.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deajun.service.BoardService;
import com.deajun.vo.Board;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}



	@RequestMapping(value = {"/", "/list", "/home", "/view"}, method = RequestMethod.GET)
	public String main2(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "home";
	}
	
	@RequestMapping(value="/board", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertBoard(String content) {
		Board board = new Board();
		board.setContent(content);
		double reuslt =boardService.insertBoard(board);
		Map<String, Object> map = new HashMap<String, Object>();
		if(reuslt < 0 ) {
			map.put("reuslt", false);
		}else {
			map.put("reuslt", true);
			map.put("no", reuslt);
		}
		return map;
	}
	
	@RequestMapping(value="/board", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteBoard(Double no) {
		System.out.println(no);
		Map<String, Object> map = new HashMap<String, Object>();
		if(boardService.deleteBoard(no)) {
			map.put("result", true);
		}else {
			map.put("result", false);
		}
		return map;
	}
	
	
}
