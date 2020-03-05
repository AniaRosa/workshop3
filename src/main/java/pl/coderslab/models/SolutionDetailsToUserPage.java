package pl.coderslab.models;

public class SolutionDetailsToUserPage {
    private String exerciseTitle;
    private String created;
    private String updated;
    private String description;

    public SolutionDetailsToUserPage(String exerciseTitle, String created, String updated, String description) {
        this.exerciseTitle = exerciseTitle;
        this.created = created;
        this.updated = updated;
        this.description = description;
    }

    public String getExerciseTitle() {
        return exerciseTitle;
    }

    public void setExerciseTitle(String exerciseTitle) {
        this.exerciseTitle = exerciseTitle;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        if (updated == null) {
            return "";
        }
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
