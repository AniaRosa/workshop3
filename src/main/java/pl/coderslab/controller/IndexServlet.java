package pl.coderslab.controller;

import pl.coderslab.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        UserDao userDao = new UserDao();
        String numberSolutions = getServletContext().getInitParameter("number-solutions");
        Solution[] solutions = solutionDao.findRecent(Integer.parseInt(numberSolutions));
        Exercise[] exercises = exerciseDao.findAll();
        List<ExerciseDetailsToMainPage> exercisesToView = new ArrayList<>();
        ExerciseDetailsToMainPage exercise;
        for (Solution s : solutions) {
            for (Exercise e : exercises) {
                if (s.getExercisesId() == e.getId()) {
                    exercise = new ExerciseDetailsToMainPage
                            (e.getTitle(),
                                    userDao.read(s.getUserId()).getUserName(),
                                    s.getCreated(),
                                    s.getId());
                    exercisesToView.add(exercise);
                }
            }
        }
        request.setAttribute("solutions", solutions);
        request.setAttribute("exercisesToView", exercisesToView);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
