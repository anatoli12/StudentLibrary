package menu;

import collections.Discipline;
import collections.DisciplinesList;
import collections.StudentGroup;
import programs.Program;
import programs.ProgramsList;
import studentThings.Student;
import studentThings.StudentStatus;

import java.util.regex.Matcher;


public class MenuCommands {
    public static void enroll(Matcher m) {
        Program pr = ProgramsList.getInstance().programFinder(m.group(2).toLowerCase());
        if (pr != null) {
            Student s = new Student(m.group(1), pr, Integer.parseInt(m.group(3)), m.group(4));
            StudentGroup.getInstance().enroll(s);
        } else throw new IllegalArgumentException(m.group(2) + " is not a valid program!");
    }

    public static void advance(Matcher m) {
        String fn = m.group(1);
        StudentGroup.findStudent(fn).advance();
    }

    public static void changeProgram(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        Program newProgram = ProgramsList.getInstance().programFinder(m.group(2));
        s.setProgram(newProgram);
    }

    public static void changeGroup(Matcher m) {
        String fn = m.group(1);
        int newGroup = Integer.parseInt(m.group(2));
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        s.setGroup(newGroup);
    }

    public static void changeYear(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        if (s.getStatus() == StudentStatus.DROPOUT)
            throw new IllegalArgumentException("Student " + fn + " has no rights!");
        int newYear = Integer.parseInt(m.group(2));
        if (s.getYear() + 1 == newYear) s.setYear(newYear);
        else throw new IllegalArgumentException("Illegal year!");
    }

    public static void interrupt(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        s.setStatus(StudentStatus.DROPOUT);
    }

    public static void resume(Matcher m) {
        String fn = m.group(1);
        Student s = StudentGroup.findStudent(fn);
        s.setStatus(StudentStatus.ACTIVE);
    }

    public static void print(Matcher m) {
        String fn = m.group(1);
        try {
            System.out.println(StudentGroup.findStudent(fn));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static void printAll(Matcher m) {
        String pr = m.group(1);
        int year = Integer.parseInt(m.group(2));
        StudentGroup.getInstance();
        for (Student s : StudentGroup.getInstance().getStudents()) {
            if (s.getYear() == year && s.getProgram().getName().matches(pr)) {
                System.out.println(s);
            }
        }
    }

    public static void enrollIn(Matcher m) {
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
    public static void addGrade(Matcher m){
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
    public static void protocol(Matcher m){  //TODO: finish
        String course = m.group(1);
        for (Student s: StudentGroup.getInstance().getStudents()) {

        }
    }

}
