package menu.commands;

import collections.StudentGroup;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class ChangeGroup implements ICommand{
    @Override
    public void execute(Matcher m){
        String fn = m.group(1);
        int newGroup = Integer.parseInt(m.group(2));
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        s.setGroup(newGroup);
    }
}
