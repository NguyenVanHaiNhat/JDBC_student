package controller;

import DAO.IStudentDAO;
import DAO.StudentDAO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IStudentDAO studentDAO;

    public void init(){
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            if (action.equals("create")) {
                showNewForm(req, resp);
            } else {
                listStudent(req, resp);
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        if (action.equals("create")){
            try {
                insertStudent(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException{
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Student newstudent = new Student(name, email, address);
        studentDAO.insertStudent(newstudent);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<Student> listUser = studentDAO.selectAllStudent();
        req.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}
