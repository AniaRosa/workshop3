package pl.coderslab.controller;

import pl.coderslab.models.User;
import pl.coderslab.models.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupDetails")
public class GroupDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupId = request.getParameter("id");
        UserDao userDao = new UserDao();
        User[] users = userDao.findAllByGroupId(Integer.parseInt(groupId));
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/groupUsers.jsp").forward(request, response);
    }
}
