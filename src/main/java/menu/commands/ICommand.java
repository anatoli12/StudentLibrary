package menu.commands;

import java.util.regex.Matcher;

public interface ICommand {
    void execute(Matcher m);
}
