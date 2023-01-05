package menu.commands;

import collections.StudentGroup;
import programs.Program;
import programs.ProgramsList;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class ChangeProgram implements ICommand{
    @Override
    public void execute(Matcher m){
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        Program newProgram = ProgramsList.getInstance().programFinder(m.group(2));
        s.setProgram(newProgram);
    }
}
