package DAO;

import models.DepartmentNews;
import models.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDAO implements DepartmentNewsDAO {

    private final Sql2o sql2o;

    public Sql2oDepartmentNewsDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (title, content, departmentId) values (:title, :content, :departmentId)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        String sql = "SELECT * FROM news WHERE departmentId <> ''";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(DepartmentNews.class);
        }catch(Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }


    @Override
    public DepartmentNews getDepartmentNewsById(int id) {
        String sql = "SELECT * FROM news WHERE id =:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(DepartmentNews.class);
        }catch(Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }
}
