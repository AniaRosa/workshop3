package pl.coderslab.controller;

import pl.coderslab.models.Exercise;
import pl.coderslab.models.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/exerciseEdit")
public class ExerciseEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Exercise exercise = (Exercise) session.getAttribute("exercise");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        if (title.equals("")) {
            title = exercise.getTitle();
        }
        if (description.equals("")) {
            description = exercise.getDescription();
        }

        ExerciseDao exerciseDao = new ExerciseDao();
        exercise.setId(exercise.getId());
        exercise.setTitle(title);
        exercise.setDescription(description);
        exerciseDao.update(exercise);
        response.sendRedirect(request.getContextPath() + "/exercisesList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exerciseId = request.getParameter("id");
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = exerciseDao.read(Integer.parseInt(exerciseId));
        request.setAttribute("exercise", exercise);
        request.setAttribute("actionServlet", "/exerciseEdit");
        HttpSession session = request.getSession();
        session.setAttribute("exercise", exercise);
        request.getRequestDispatcher("/WEB-INF/editOrAddExercise.jsp").forward(request, response);
    }
}
