package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public User setUpUser(){
        User employee = new User("Lewis","Managing Director", "Ensuring work is done", 1);
        return employee;
    }
    @Test
    public void addEmployee_getsName(){
        User employee = setUpUser();
        assertEquals("Lewis",employee.getName());
    }
    @Test
    public void addEmployee_getPosition(){
        User employee = setUpUser();
        assertEquals("Managing Director",employee.getUserPosition());
    }

}