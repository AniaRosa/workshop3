package pl.coderslab.controller;

import pl.coderslab.models.Solution;
import pl.coderslab.models.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/details")
public class SolutionDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String solutionId = request.getParameter("id");
        String exerciseTitle = request.getParameter("title");
        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(Integer.parseInt(solutionId));
        request.setAttribute("solution", solution);
        request.setAttribute("title", exerciseTitle);
        request.getRequestDispatcher("/WEB-INF/solutionDetails.jsp").forward(request, response);
    }
}
