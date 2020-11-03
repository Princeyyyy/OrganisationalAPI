package models;

public class DepartmentNews extends GeneralNews {

    private int departmentId;


    public DepartmentNews(String title, String content, int departmentId) {
        super(title, content);
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(int departmentId) {

        this.departmentId = departmentId;
    }
}
