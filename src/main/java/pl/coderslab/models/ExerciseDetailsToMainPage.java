package pl.coderslab.models;

public class ExerciseDetailsToMainPage {

    private String exerciseTile;
    private String exerciseAuthor;
    private String exerciseCreationDate;
    private int exerciseSolutionId;

    public ExerciseDetailsToMainPage(String exerciseTile, String exerciseAuthor, String exerciseCreationDate, int exerciseSolutionId) {
        this.exerciseTile = exerciseTile;
        this.exerciseAuthor = exerciseAuthor;
        this.exerciseCreationDate = exerciseCreationDate;
        this.exerciseSolutionId = exerciseSolutionId;
    }

    public int getExerciseSolutionId() {
        return exerciseSolutionId;
    }

    public void setExerciseSolutionId(int exerciseSolutionId) {
        this.exerciseSolutionId = exerciseSolutionId;
    }

    public String getExerciseTile() {
        return exerciseTile;
    }

    public void setExerciseTile(String exerciseTile) {
        this.exerciseTile = exerciseTile;
    }

    public String getExerciseAuthor() {
        return exerciseAuthor;
    }

    public void setExerciseAuthor(String exerciseAuthor) {
        this.exerciseAuthor = exerciseAuthor;
    }

    public String getExerciseCreationDate() {
        return exerciseCreationDate;
    }

    public void setExerciseCreationDate(String exerciseCreationDate) {
        this.exerciseCreationDate = exerciseCreationDate;
    }
}
