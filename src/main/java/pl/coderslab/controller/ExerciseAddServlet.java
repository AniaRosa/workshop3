package pl.coderslab.controller;

import pl.coderslab.models.Exercise;
import pl.coderslab.models.ExerciseDao;
import pl.coderslab.models.GroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addExercise")
public class ExerciseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if (title.equals("")) {
            title = "exercise";
        }
        if (description.equals("")) {
            description ="description";
        }
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise(title, description);
        exerciseDao.create(exercise);
        response.sendRedirect(request.getContextPath() + "/exercisesList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercise techExercise = new Exercise();
        request.setAttribute("exercise", techExercise);
        request.setAttribute("actionServlet", "/addExercise");
        request.getRequestDispatcher("/WEB-INF/editOrAddExercise.jsp").forward(request, response);

    }
}
