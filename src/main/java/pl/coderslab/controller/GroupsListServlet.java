package pl.coderslab.controller;

import pl.coderslab.models.Group;
import pl.coderslab.models.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupsList")
public class GroupsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        Group[] groups = groupDao.findAll();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("/WEB-INF/groupsList.jsp").forward(request, response);
    }
}
