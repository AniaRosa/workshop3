package pl.coderslab.controller;

import pl.coderslab.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/userDetails")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        UserDao userDao = new UserDao();
        User user = userDao.read(Integer.parseInt(userId));
        request.setAttribute("user", user);
        SolutionDao solutionDao = new SolutionDao();
        Solution[] userSolutions = solutionDao.findAllByUserId(Integer.parseInt(userId));
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] exercises = exerciseDao.findAll();
        List<SolutionDetailsToUserPage> solutionsToView = new LinkedList<>();
        for (Solution solution : userSolutions) {
            for (Exercise exercise : exercises) {
                if (solution.getExercisesId() == exercise.getId()) {
                    SolutionDetailsToUserPage solutionDetails = new SolutionDetailsToUserPage
                            (exercise.getTitle(),
                                    solution.getCreated(),
                                    solution.getUpdated(),
                                    solution.getDescription());
                    solutionsToView.add(solutionDetails);
                }
            }
        }
        request.setAttribute("solutionsToView", solutionsToView);
        request.getRequestDispatcher("/WEB-INF/userDetails.jsp").forward(request, response);
    }
}
