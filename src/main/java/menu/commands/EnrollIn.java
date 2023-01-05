package menu.commands;

import collections.Discipline;
import collections.DisciplinesList;
import collections.StudentGroup;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class EnrollIn implements ICommand{
    @Override
    public void execute(Matcher m) {
        String fn = m.group(1);
        String discTag = m.group(2);
        Discipline toPass = null;
        for (Discipline d : DisciplinesList.getInstance().getDisciplines()) {
            if (d.getTag().matches(discTag)) {
                toPass = d;
                break;
            }
        }
        if (toPass != null) {
            Student s = StudentGroup.findStudent(fn);
            if (s.getStatus() == StudentStatus.DROPOUT)
                throw new IllegalArgumentException("Student " + fn + " has no rights!");
            s.enrollIn(toPass);
        } else throw new IllegalArgumentException("No such discipline.");
    }
}
