package studentThings;

import collections.Discipline;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {
    private Discipline discipline;
    private boolean isGraded;
    private double grade;
    private boolean isEnrolled;

    public Course(Discipline discipline) {
        this.discipline = discipline;
        this.grade = 2.00;
        this.isGraded=false;
        isEnrolled=true;
    }
    public Course(){}

    public Boolean getGraded() {
        return isGraded;
    }

    private void setGraded(boolean graded) {
        isGraded = graded;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {

        if(isEnrolled){
            this.grade = grade;
            setGraded(true);
        }
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Course{" +
                "discipline=" + discipline.getName() +
                ", isGraded=" + isGraded +
                ", grade=" + grade +
                ", isEnrolled=" + isEnrolled +
                '}';
    }
}
