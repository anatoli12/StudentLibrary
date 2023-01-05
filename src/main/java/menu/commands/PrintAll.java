package menu.commands;

import collections.StudentGroup;
import studentThings.Student;

import java.util.regex.Matcher;

public class PrintAll implements ICommand{
    @Override
    public void execute(Matcher m){
        String pr = m.group(1);
        int year = Integer.parseInt(m.group(2));
        StudentGroup.getInstance();
        for (Student s : StudentGroup.getInstance().getStudents()) {
            if (s.getYear() == year && s.getProgram().getName().matches(pr)) {
                System.out.println(s);
            }
        }
    }
}
