package menu.commands;

import collections.StudentGroup;

import java.util.regex.Matcher;

public class Print implements ICommand{


    @Override
    public void execute(Matcher m) {
        String fn = m.group(1);
        try {
            System.out.println(StudentGroup.findStudent(fn));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
