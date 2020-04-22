package com.yi.persistance;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.ProjectVO;
@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private SqlSession session;
	private static final String namespace = "mappers.projectMapper.";
	@Override
	public List<ProjectVO> showProjects() throws SQLException {
		return session.selectList(namespace + "showProjects");
	}

	@Override
	public ProjectVO showProjectByNo(ProjectVO project) throws SQLException {
		return session.selectOne(namespace + "showProjectByNo",project);
	}

	@Override
	public void insertProject(ProjectVO project) throws SQLException {
		session.insert(namespace + "insertProject",project);

	}

	@Override
	public void updateProject(ProjectVO project) throws SQLException {
		session.update(namespace + "updateProject",project);

	}

	@Override
	public void deleteProject(ProjectVO project) throws SQLException {
		session.delete(namespace + "deleteProject",project);

	}

}
