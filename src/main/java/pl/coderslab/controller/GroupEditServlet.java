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

@WebServlet("/groupEdit")
public class GroupEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Group group = (Group) session.getAttribute("group");
        String name = request.getParameter("name");
        if (name.equals("")) {
            name = group.getName();
        }
        GroupDao groupDao = new GroupDao();
        group.setName(name);
        group.setId(group.getId());
        groupDao.update(group);
        response.sendRedirect(request.getContextPath() + "/groupsList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupId = request.getParameter("id");
        GroupDao groupDao = new GroupDao();
        Group group = groupDao.read(Integer.parseInt(groupId));
        request.setAttribute("group", group);
        request.setAttribute("actionServlet", "/groupEdit");
        request.setAttribute("action", "Nowa nazwa grupy");
        HttpSession session = request.getSession();
        session.setAttribute("group", group);
        request.getRequestDispatcher("/WEB-INF/editOrAddGroup.jsp").forward(request, response);

    }

}
