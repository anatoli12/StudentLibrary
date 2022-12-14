package studentThings;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Student")
@XmlType(propOrder = {"name", "program", "status", "year", "group", "gradeList"})
public class Student implements Serializable {
        @XmlElement(name = "name")
    private String name;
        @XmlAttribute
    private String facNum;
        @XmlElement(name = "year")
    private int year;
        @XmlElement(name = "program")
    private String program;
        @XmlElement(name = "group")
    private int group;
        @XmlElement(name ="gradeList")
    private ArrayList<Discipline> gradeList;
        @XmlElement(name = "status")
    private StudentStatus status;
    public Student(){}

    public Student(String facNum, String program, int group, String name) {
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

    public String getProgram() {
        return program;
    }

    public int getGroup() {
        return group;
    }

    protected ArrayList<Discipline> getGradeList() {
        return gradeList;
    }

    public int getYear() {
        return year;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    public String getFacNum() {
        return facNum;
    }

    public StudentStatus getStatus() {
        return status;
    }

    protected void setStatus(StudentStatus status) {
        this.status = status;
    }

    public double getAverageGrade() {
        double avg = 0;
        for (Discipline disc : gradeList) {
            avg += disc.getGrade();
        }
        avg /= gradeList.size();
        return avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "\nname='" + name + '\'' +
                "\nfacNum='" + facNum + '\'' +
                "\nstatus='" + status + '\'' +
                "\nyear=" + year +
                "\nprogram='" + program + '\'' +
                "\ngroup=" + group +
                "\ngradeList=" + gradeList +
                "\n}";
    }
}
