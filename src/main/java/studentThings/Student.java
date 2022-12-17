package studentThings;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "Student")
//@XmlType(propOrder = {"name", "program", "status", "year", "group", "gradeList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    //        @XmlElement(name = "name")
    @XmlAttribute
    private String facNum;
    private String name;
    private String program;
    private StudentStatus status;
    private int year;
    private int group;
    private ArrayList<Exam> examList;

    public Student() {
    }

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

    protected ArrayList<Exam> getGradeList() {
        return examList;
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
        for (Exam disc : examList) {
            avg += disc.getGrade();
        }
        avg /= examList.size();
        return avg;
    }

    //@Override
    public String toStringFirst() {
        return "Student{" +
                "\nname='" + name + '\'' +
                "\nfacNum='" + facNum + '\'' +
                "\nstatus='" + status + '\'' +
                "\nyear=" + year +
                "\nprogram='" + program + '\'' +
                "\ngroup=" + group +
                "\ngradeList=" + examList +
                "\n}";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", facNum='" + facNum + '\'' +
                ", year=" + year +
                ", program='" + program + '\'' +
                ", group=" + group +
                ", gradeList=" + examList +
                ", status=" + status +
                "}\n";
    }
}
