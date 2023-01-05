package menu.commands;

import collections.StudentGroup;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class Resume implements ICommand{
    @Override
    public void execute(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        s.setStatus(StudentStatus.ACTIVE);
    }
}
