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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String groupId = request.getParameter("group");
        String password = request.getParameter("password");
        GroupDao groupDao = new GroupDao();
        Group[] groups = groupDao.findAll();
        boolean checkGroupId = false;
        for (Group group : groups) {
            if (group.getId() == Integer.parseInt(groupId)) {
                checkGroupId = true;
            }
        }
        if (!checkGroupId) {
            groupId = String.valueOf(user.getUserGroupId());
        }
        if (userName.equals("")) {
            userName = user.getUserName();
        }
        if (userEmail.equals("")) {
            userEmail = user.getEmail();
        }
        if (groupId.equals("")) {
            groupId = String.valueOf(user.getUserGroupId());
        }
        if (password.equals("")) {
            password = user.getPassword();
        }
        UserDao userDao = new UserDao();
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setUserGroupId(Integer.parseInt(groupId));
        user.setUserName(userName);
        userDao.update(user);
        response.sendRedirect(request.getContextPath() + "/usersList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        UserDao userDao = new UserDao();
        User user = userDao.read(Integer.parseInt(userId));
        request.setAttribute("user", user);
        request.setAttribute("actionServlet", "/userEdit");
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/editOrAddUser.jsp").forward(request, response);
    }
}
