package models;

import DAO.Sql2oDepartmentNewsDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    private Sql2oDepartmentNewsDAO departmentNewsDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    public DepartmentNews setupClassifiedNews(){
        DepartmentNews departmentNews = new DepartmentNews("Into the water","A young girl decided to immerse herself in books because she believed she has treasure inside books", 1);
        return departmentNews;
    }
    public DepartmentNews setupAnotherDepartmentNews(){
        DepartmentNews departmentNews = new DepartmentNews("Why is the world going towards tech?","Nowadays a lot of people go for robots than humans",1);
        return departmentNews;
    }
    @Test
    public void addingClassifiedNewsSetsTitle() throws Exception {
        DepartmentNews testDepartment = setupClassifiedNews();
        assertEquals("Into the water", testDepartment.getTitle());
    }
    @Test
    public void addingClassifiedNewsSetsDetails() throws Exception{
        DepartmentNews testClassified = setupClassifiedNews();
        assertEquals("A young girl decided to immerse herself in books because she believed she has treasure inside books",testClassified.getContent());
    }

}
