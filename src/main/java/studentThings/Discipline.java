package studentThings;

public class Discipline {
    private String name;
    private Boolean isGraded = false;
    private double grade = 2.00;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGraded() {
        return isGraded;
    }

    public void setGraded(Boolean graded) {
        isGraded = graded;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
