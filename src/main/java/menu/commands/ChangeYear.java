package menu.commands;

import collections.StudentGroup;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class ChangeYear implements ICommand{
    @Override
    public void execute(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        int newYear = Integer.parseInt(m.group(2));
        if (s.getYear() + 1 == newYear) s.setYear(newYear);
        else throw new IllegalArgumentException("Illegal year!");
    }
}
