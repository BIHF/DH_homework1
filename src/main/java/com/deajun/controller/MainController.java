package com.deajun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deajun.service.BoardService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}



	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String main2() {
		logger.info("test");
		logger.info("board의 개수는? " + boardService.getCount());
		return "home";
	}
	
	
}
