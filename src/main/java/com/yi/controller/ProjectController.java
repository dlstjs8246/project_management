package com.yi.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.ProjectVO;
import com.yi.service.ProjectService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	private ProjectService service;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:list";
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws SQLException {
		List<ProjectVO> list = service.showProjects();
		System.out.println(list);
		model.addAttribute("list", list);
		return "list";
	}
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertGet() throws SQLException {
		return "insert";
	}
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertPost(ProjectVO vo, Model model) throws SQLException {
		service.insertProject(vo);
		return "redirect:list";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(ProjectVO vo, Model model) throws SQLException {
		vo = service.showProjectByNo(vo);
		model.addAttribute("vo",vo);
		return "detail";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyGet(ProjectVO vo, Model model) throws SQLException {
		vo = service.showProjectByNo(vo);
		model.addAttribute("vo",vo);
		return "modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(ProjectVO vo, Model model) throws SQLException {
		service.updateProject(vo);
		return "redirect:detail?no="+vo.getNo();
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(ProjectVO vo, Model model) throws SQLException {
		service.deleteProject(vo);
		return "redirect:list";
	}
	
}
