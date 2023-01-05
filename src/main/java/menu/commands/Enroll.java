package menu.commands;

import collections.StudentGroup;
import programs.Program;
import programs.ProgramsList;
import studentThings.Student;

import java.util.regex.Matcher;

public class Enroll implements ICommand{

    @Override
    public void execute(Matcher m) {
        Program pr = ProgramsList.getInstance().programFinder(m.group(2).toLowerCase());
        if (pr != null) {
            Student s = new Student(m.group(1), pr, Integer.parseInt(m.group(3)), m.group(4));
            StudentGroup.getInstance().enroll(s);
        } else throw new IllegalArgumentException(m.group(2) + " is not a valid program!");
    }
}
