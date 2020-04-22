package com.yi.project;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.ProjectVO;
import com.yi.persistance.ProjectDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectDaoTest {
	@Autowired
	private ProjectDao dao;
	@Test
	public void test00() throws SQLException {
		System.out.println(dao);
	}
	@Test
	public void test01() throws SQLException {
		Calendar cal = GregorianCalendar.getInstance();	
		cal.set(2020, 1, 1);
		Calendar cal2 = GregorianCalendar.getInstance();
		cal2.set(2020, 4, 1);
		ProjectVO project = new ProjectVO("테스트1", "테스트1",cal.getTime(),cal2.getTime(), "r");
		dao.insertProject(project);
	}
	@Test
	public void test02() throws SQLException {
		dao.showProjects();
	}
	@Test
	public void test03() throws SQLException {
		dao.showProjectByNo(new ProjectVO(1));
	}
	@Test
	public void test04() throws SQLException {
		Calendar cal = GregorianCalendar.getInstance();	
		cal.set(2020, 2, 1);
		Calendar cal2 = GregorianCalendar.getInstance();
		cal2.set(2020, 5, 1);
		ProjectVO project = new ProjectVO("테스트2", "테스트2",cal.getTime(),cal2.getTime(), "e");
		dao.updateProject(project);
	}
	@Test
	public void test05() throws SQLException {
		dao.deleteProject(new ProjectVO(1));
	}
	
}
