package menu.commands;

import collections.StudentGroup;

import java.util.regex.Matcher;

public class Advance implements ICommand{

    @Override
    public void execute(Matcher m) {
        String fn = m.group(1);
        StudentGroup.findStudent(fn).advance();
    }
}
