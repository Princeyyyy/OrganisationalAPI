package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralNewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void addNews_getNewsTitle(){
        GeneralNews news = new GeneralNews("Covid is deadly","It has taken the world by storm");
        assertEquals("Covid is deadly",news.getTitle());
    }
    @Test
    public void addNews_getAllNews(){
        GeneralNews news = new GeneralNews("Covid is deadly","It has taken the world by storm");
        GeneralNews anotherNews = new GeneralNews("Not my own","So he just decided to leave out of nowhere");
        assertNotEquals(news,anotherNews);
    }
}