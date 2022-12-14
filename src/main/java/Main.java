import collections.StudentGroup;
import fileWork.FileManipulator;
import fileWork.ReadFromXml;
import fileWork.SaveToXml;
import studentThings.Student;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.*;

public class Main {

    public static void main(String[] args) throws JAXBException{
        //opening a file
        final String fileName=args[0];
        FileManipulator fileManipulator = new FileManipulator();
        fileManipulator.commands(fileName);
//making a student list
        List<Student> list = new ArrayList<>();
        list.add(new Student("20621662", "SIT", 2, "Anatoli Dimov"));
        list.add(new Student("20621663", "KST", 1, "Daniel Krustanov"));
        list.add(new Student("20621664", "SIT", 2, "Martin Cholakov"));
        list.add(new Student("19824522", "AT", 5, "Yordan Mavrodinov"));
        list.add(new Student("48651255", "ID", 3, "Fulin Metin"));
        list.add(new Student("87412255", "KS", 1, "Anna Ananieva"));
//student group
//        StudentGroup studentGroup=new StudentGroup(list);
//        SaveToXml.execute(studentGroup, fileName);
            StudentGroup studentGroup= ReadFromXml.execute(fileName);
        for (Student st:studentGroup.getStudents()) {
            System.out.println(st);
        }
    }
}
