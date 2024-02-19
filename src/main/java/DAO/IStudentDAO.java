package DAO;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student) throws SQLException;
    public Student selectStudent(int id);
    public List<Student> selectAllStudent();
}
