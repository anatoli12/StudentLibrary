package studentThings;

import collections.Discipline;
import jakarta.xml.bind.annotation.*;
import programs.Program;

import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "Student")
//@XmlType(propOrder = {"name", "program", "status", "year", "group", "gradeList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    //        @XmlElement(name = "name")
    @XmlAttribute
    private String facNum;
    private String name;
    private Program program;
    private StudentStatus status;
    private int year;
    private int group;
    @XmlElement(name = "course")
    private ArrayList<Course> courseList= new ArrayList<>();

    public Student() {
    }

    public Student(String facNum, Program program, int group, String name) {
        super();
        this.name = name;
        this.facNum = facNum;
        this.program = program;
        this.group = group;
        this.year = 1;
        this.status = StudentStatus.ACTIVE;
    }

    public String getName() {
        return name;
    }
    public Program getProgram() {
        return program;
    }

    public int getGroup() {
        return group;
    }

    protected ArrayList<Course> getGradeList() {
        return courseList;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getFacNum() {
        return facNum;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\n' +
                ", facNum='" + facNum + '\n' +
                ", year=" + year + '\n' +
                ", program='" + program + '\n' +
                ", group=" + group + '\n' +
                ", courseList=" + courseList + '\n'+
                ", status=" + status + '\n'+
                "}\n";
    }
    public double getAverageGrade() {
        double avg = 0;
        for (Course disc : courseList) {
            avg += disc.getGrade();
        }
        avg /= courseList.size();
        return avg;
    }
    public void advance(){
        year+=1;
    }
    public void enrollIn(Discipline discipline){
        if(program.getDisciplines().contains(discipline)&&
        discipline.getYear()==year) {
            Course course = new Course(discipline);
            courseList.add(course);
            System.out.println("Successfully added "+discipline);
        } else throw new IllegalArgumentException("The student's program does not allow this discipline!");
    }
    public void addGrade(Discipline disc, double newGrade){
        boolean fl=false;
        for (Course course:courseList) {
            if(disc.getTag().equals(course.getDiscipline().getTag())){
                course.setGrade(newGrade);
                fl=true;
                System.out.println("New grade successfully set!");
                break;
            }
        }
        if(!fl)throw new IllegalArgumentException("Course is not enrolled!");
    }
}
