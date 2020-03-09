package pl.coderslab.controller;

import pl.coderslab.models.Group;
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
        request.setAttribute("name", userName);
        String userEmail = request.getParameter("email");
        request.setAttribute("email", userEmail);
        String groupId = request.getParameter("group");
        request.setAttribute("groupId", groupId);
        String password = request.getParameter("password");
        while (userName.equals("") || userEmail.equals("") || password.equals("")) {
            userName = request.getParameter("name");
            request.setAttribute("name", userName);
            userEmail = request.getParameter("email");
            request.setAttribute("email", userEmail);
            groupId = request.getParameter("group");
            request.setAttribute("groupId", groupId);
            password = request.getParameter("password");

            request.setAttribute("error", "Pola nie mogą być puste!");
            GroupDao groupDao = new GroupDao();
            Group[] groups = groupDao.findAll();
            request.setAttribute("groups", groups);
            User techUser = new User();
            request.setAttribute("user", techUser);
            request.setAttribute("actionServlet", "/addUser");
            request.getRequestDispatcher("/WEB-INF/editOrAddUser.jsp").forward(request, response);
        }
        UserDao userDao = new UserDao();
        User user = new User(userName, userEmail, password, Integer.parseInt(groupId));
        userDao.create(user);
        response.sendRedirect(request.getContextPath() + "/usersList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User techUser = new User();
        request.setAttribute("user", techUser);
        GroupDao groupDao = new GroupDao();
        Group[] groups = groupDao.findAll();
        request.setAttribute("groups", groups);
        request.setAttribute("actionServlet", "/addUser");
        request.getRequestDispatcher("/WEB-INF/editOrAddUser.jsp").forward(request, response);

    }
}
