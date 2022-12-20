package menu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        MenuPatterns menuPatterns = MenuPatterns.getInstance();
        int i;
        Matcher m = null;
        String command;
        loop:
        while (true) {
            System.out.println("Options: ");
            System.out.println("enroll <fn> <program> <group> <name>");
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
            System.out.println("files");
            command = scanner.nextLine();
            for (i = 0; i < menuPatterns.getPatterns().size(); i++) {
                m = menuPatterns.getPatterns().get(i).matcher(command);
                if (m.matches()) {
                    break;
                }
            }
            switch (i) {
                case 0: //enroll
                    MenuCommands.enroll(m);
                    break;
                case 1: //advance
                    MenuCommands.advance(m);
                    break;
                case 2: //change group
                    try {
                        MenuCommands.changeGroup(m);
                    } catch (IllegalArgumentException e){
                        System.out.println(e);
                    }
                    break;
                case 3: //change program
                    try {
                        MenuCommands.changeProgram(m);
                    } catch (IllegalArgumentException e){
                        System.out.println(e);
                    }
                    break;
                case 4: //change year
                    try {
                        MenuCommands.changeYear(m);
                    } catch (IllegalArgumentException e){
                        System.out.println(e);
                    }
                    break;
                case 5: //graduate
//                    MenuCommands.
                    break;
                case 6: //interrupt
                    MenuCommands.interrupt(m);
                    break;
                case 7: // resume
                    MenuCommands.resume(m);
                    break;
                case 8: //print
                    MenuCommands.print(m);
                    break;
                case 9: //printall
                    MenuCommands.printAll(m);
                    break;
                case 10: //enrollin
                    MenuCommands.enrollIn(m);
                    break;
                case 11: //addgrade
                    MenuCommands.addGrade(m);
                    break;
                case 12:
                    MenuCommands.protocol(m);
                    break;
                case 14: //files
                    break loop;
                default:
                    System.out.println("Invalid command!");

            }
        }
    }
}
