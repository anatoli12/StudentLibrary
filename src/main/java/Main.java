import collections.StudentGroup;
import fileWork.FileManipulator;
import studentThings.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.*;

public class Main {
    final static String theFilePath = "test.xml";

    private static void listToFile(ArrayList<Student> students) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        for (Student student : students) {
            marshaller.marshal(student, new FileOutputStream(theFilePath));
        }
    }

    private static void fileToList(ArrayList<Student> students) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Student.class);

    }

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        FileManipulator fileManipulator = new FileManipulator();
        fileManipulator.commands(theFilePath);

        JAXBContext contextObj = JAXBContext.newInstance(StudentGroup.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        List<Student> list = new ArrayList<>();
        list.add(new Student("20621662", "SIT", 2, "Anatoli Dimov"));
        list.add(new Student("20621663", "KST", 1, "Daniel Krustanov"));
        list.add(new Student("20621664", "SIT", 2, "Martin Cholakov"));
        list.add(new Student("19824522", "AT", 5, "Yordan Mavrodinov"));
        list.add(new Student("48651255", "ID", 3, "Fulin Metin"));
        list.add(new Student("87412255", "KS", 1, "Anna Ananieva"));

        StudentGroup studentGroup=new StudentGroup(list);

        marshallerObj.marshal(studentGroup, System.out);

    }
}
