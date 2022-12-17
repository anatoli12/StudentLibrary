package collections;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import studentThings.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement
public final class StudentGroup {
    private static StudentGroup gr;
    private List<Student> students= new ArrayList<>();
    private static final String message="This is a student group!";

//    public StudentGroup() {
//    }
//
//    public StudentGroup(List<Student> students) {
//        super();
//        this.students = students;
//    }
    private StudentGroup(){}
    public static StudentGroup getInstance(){
        if(gr==null)
            gr=new StudentGroup();
        return gr;
    }
    @XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @XmlElement
    public String getMessage(){
        return message;
    }

    public void enroll(Student student){students.add(student);}

    @Override
    public String toString() {
        return "StudentGroup{" +
                "students=" + students +
                "}";
    }
}
