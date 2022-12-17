import collections.StudentGroup;
import fileWork.FileManipulator;
import fileWork.ReadFromXml;
import fileWork.SaveToXml;
import menu.MainMenu;
import studentThings.Student;


import java.io.FileNotFoundException;

import jakarta.xml.bind.*;

public class Main {
    public static void main(String[] args) throws JAXBException {
        //opening a file
        final String fileName = args[0];
        FileManipulator fm = new FileManipulator(fileName);
        //fm.commands();
        fm.setOpen(true);
        StudentGroup studentGroup = StudentGroup.getInstance();
        if (fm.isOpen()) studentGroup = ReadFromXml.execute(fm);
        studentGroup.enroll(new Student("49292482", "SIT", 4, "Arman Armanov"));
        try {
            SaveToXml.execute(studentGroup, fm);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.print(studentGroup);
    }

    public static void main1(String[] args) {
        final String fileName = args[0];
        FileManipulator fm = new FileManipulator(fileName);
        do{
            fm.commands();
            MainMenu.execute();
        }while(true);
    }
}
