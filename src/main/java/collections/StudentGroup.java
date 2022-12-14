package collections;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import studentThings.Student;

import java.util.List;

@XmlRootElement
public class StudentGroup {
    private List<Student> students;
    private static final String message="This is a student group!";

    public StudentGroup() {
    }

    public StudentGroup(List<Student> students) {
        super();
        this.students = students;
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
}
