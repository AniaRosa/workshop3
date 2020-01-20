package pl.coderslab.controller;

import pl.coderslab.models.Solution;
import pl.coderslab.models.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        String numberSolutions = getServletContext().getInitParameter("number-solutions");
        Solution[] solutions = solutionDao.findRecent(Integer.parseInt(numberSolutions));
        request.setAttribute("solutions", solutions);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
