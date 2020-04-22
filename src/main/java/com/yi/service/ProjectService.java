package com.yi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.ProjectVO;
import com.yi.persistance.ProjectDao;
@Service
public class ProjectService {
	@Autowired
	private ProjectDao dao;
	
	public List<ProjectVO> showProjects() throws SQLException {
		return dao.showProjects();
	}
	public ProjectVO showProjectByNo(ProjectVO project) throws SQLException {
		return dao.showProjectByNo(project);
	}
	public void insertProject(ProjectVO project) throws SQLException {
		dao.insertProject(project);
	}
	public void updateProject(ProjectVO project) throws SQLException {
		dao.updateProject(project);
	}
	public void deleteProject(ProjectVO project) throws SQLException {
		dao.deleteProject(project);
	}
}
