package DAO;

import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDAO {

    void add(GeneralNews generalNews);

    List<GeneralNews> getAllGeneralNews();

    GeneralNews getGeneralNewsById(int id);

}
