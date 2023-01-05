package collections;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import studentThings.Student;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public final class StudentGroup {
    private static StudentGroup gr;
    private List<Student> students = new ArrayList<>();

    private StudentGroup() {
    }

    public static StudentGroup getInstance() {
        if (gr == null)
            gr = new StudentGroup();
        return gr;
    }

    public static void destroy() {
        gr = null;
    }

    @XmlElement(name = "student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void enroll(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "students=" + students +
                "}";
    }

    public static void setGr(StudentGroup gr) {
        StudentGroup.gr = gr;
    }

    public static Student findStudent(String fn) throws IllegalArgumentException {
        for (Student stud : gr.students) {
            if (stud.getFacNum().matches(fn)) {
                return stud;
            }
        }
        throw new IllegalArgumentException("Student not found!");
    }
}
