package menu;

import collections.StudentGroup;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    public static void execute(){
        StudentGroup studentGroup = StudentGroup.getInstance();
        Scanner scanner = new Scanner(System.in);

        String command;
        System.out.println("Options: ");
            System.out.println("enroll <fn> <program>");
            System.out.println("advance <fn>");
            System.out.println("change <fn> <option> <value>");
            System.out.println("graduate <fn>");
            System.out.println("interrupt <fn>");
            System.out.println("resume <fn>");
            System.out.println("print <fn>");
            System.out.println("printall <program> <year>");
            System.out.println("enrollin <fn> <course>");
            System.out.println("addgrade <fn> <course> <grade>");
            System.out.println("protocol <course>");
            System.out.println("report <fn>");
            command=scanner.nextLine();
            Matcher m = MenuPatterns.enrollPattern.matcher(command);
    }
}
