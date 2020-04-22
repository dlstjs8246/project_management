package com.yi.persistance;

import java.sql.SQLException;
import java.util.List;

import com.yi.domain.ProjectVO;

public interface ProjectDao {
	public List<ProjectVO> showProjects() throws SQLException;
	public ProjectVO showProjectByNo(ProjectVO project) throws SQLException;
	public void insertProject(ProjectVO project) throws SQLException;
	public void updateProject(ProjectVO project) throws SQLException;
	public void deleteProject(ProjectVO project) throws SQLException;
}
