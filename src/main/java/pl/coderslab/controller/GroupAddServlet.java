package pl.coderslab.controller;

import pl.coderslab.models.Group;
import pl.coderslab.models.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addGroup")
public class GroupAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name.equals("")) {
            name = "group name";
        }
        GroupDao groupDao = new GroupDao();
        Group group = new Group(name);
        groupDao.create(group);
        response.sendRedirect(request.getContextPath() + "/groupsList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group techGroup = new Group();
        request.setAttribute("group", techGroup);
        request.setAttribute("actionServlet", "/addGroup");
        request.setAttribute("action", "Nazwa nowej grupy");
        request.getRequestDispatcher("/WEB-INF/editOrAddGroup.jsp").forward(request, response);

    }

}

