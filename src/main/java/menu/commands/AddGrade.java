package menu.commands;

import collections.Discipline;
import collections.DisciplinesList;
import collections.StudentGroup;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;

public class AddGrade implements ICommand{
    @Override
    public void execute(Matcher m){
        String fn = m.group(1);
        String discTag = m.group(2);
        double grade = Double.parseDouble(m.group(3));
        Discipline toPass = null;
        if(grade<2.00||grade>6.00)throw new IllegalArgumentException("Grade must be from 2.00 to 6.00.");
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        for (Discipline d : DisciplinesList.getInstance().getDisciplines()) {
            if (d.getTag().matches(discTag)) {
                toPass = d;
                break;
            }
        }
        if (toPass != null) {
            s.addGrade(toPass, grade);
        } else throw new IllegalArgumentException("No such discipline.");
    }
}
