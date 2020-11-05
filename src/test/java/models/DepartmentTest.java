package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Department setUpDepartment(){
        Department department = new Department("Finance","Deal with money");
        return department;
    }
    @Test
    public void addDepartment_getName(){
        Department department = setUpDepartment();
        assertEquals("Finance",department.getDepartmentName());
    }
    @Test
    public void addDepartment_getDescription(){
        Department department = setUpDepartment();
        assertEquals("Deal with money",department.getDescription());
    }

}
