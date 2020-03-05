package pl.coderslab.controller;

import pl.coderslab.models.GroupDao;
import pl.coderslab.models.User;
import pl.coderslab.models.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String groupId = request.getParameter("group");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = new User(userName, userEmail, password, Integer.parseInt(groupId));
        userDao.create(user);
        response.sendRedirect(request.getContextPath() + "/usersList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("actionServlet", "/addUser");
        request.getRequestDispatcher("/WEB-INF/editOrAddUser.jsp").forward(request, response);

    }
}
