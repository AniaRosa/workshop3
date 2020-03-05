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
        Integer userId = (Integer) session.getAttribute("userId");
        String userName = request.getParameter("name");
        String userEmail = request.getParameter("email");
        String groupId = request.getParameter("group");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        User user = userDao.read(userId);
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
        //request.setAttribute("action", "Nowa nazwa grupy");
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        //session.setAttribute("groupName", group.getName());
        request.getRequestDispatcher("/WEB-INF/editOrAddUser.jsp").forward(request, response);
    }
}
