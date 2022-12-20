package fileWork;

import collections.StudentGroup;
import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class FileManipulator {
    private String pathName;
    private boolean isOpen = false;

    public FileManipulator(String pathName) {
        this.pathName = pathName;
    }

    public void commands() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        Pattern save_asPattern = Pattern.compile("saveas\\s+(.+)");
        System.out.println("*****OPTIONS*****");
        System.out.println("open");
        System.out.println("close");
        System.out.println("save");
        System.out.println("save as");
        System.out.println("help");
        System.out.println("exit");
        System.out.println("**************");
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();
        choice = choice.strip();
        Matcher m = save_asPattern.matcher(choice);
        if (m.matches()) {
            try {
                saveAs(m.group(1));
            } catch (FileNotFoundException | JAXBException e) {
                throw new RuntimeException(e);
            }
        } else
            switch (choice) {
                case "open":
                    try {
                        StudentGroup.setGr(open());
                        isOpen = true;
                    } catch (JAXBException | IOException e) {
                        System.out.println("Nothing to read");
                    }
                    break;
                case "close":
                    try {
                        close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "save":
                    try {
                        save();
                    } catch (FileNotFoundException | JAXBException e) {
                        throw new RuntimeException(e);
                    } break;
                case "help":
                    help();
                    break;
                case "exit":
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
    }

    private StudentGroup open() throws IOException, JAXBException {
        File file = new File(pathName);
        if (file.exists()) {
            isOpen = true;
            System.out.println("Successfully opened " + pathName);
            return ReadFromXml.execute(pathName);
        } else {
            isOpen = file.createNewFile();
            System.out.println("Successfully created " + pathName);
            return StudentGroup.getInstance();
        }

    }

    private void close() throws IOException {
        if (isOpen) {
            System.out.println("Successfully closed " + pathName);
            isOpen = false;
            StudentGroup.destroy();
        } else {
            System.out.println("The file is not open");
        }
    }

    private void save() throws JAXBException, FileNotFoundException {
        if (isOpen) {
            SaveToXml.execute(StudentGroup.getInstance(), pathName);
            System.out.println("Successfully saved " + pathName);
        } else {
            System.out.println("The file is not open");
        }
    }

    private void saveAs(String saveAsLocation) throws JAXBException, FileNotFoundException {
        if (isOpen) {
            SaveToXml.execute(StudentGroup.getInstance(), saveAsLocation);
            System.out.println("Successfully saved to " + saveAsLocation);
        } else {
            System.out.println("The file is not open");
        }
    }

    private void help() {
        System.out.println("> help \n" +
                "The following commands are supported: \n" +
                "open opens the file <args[0]>\n" +
                "close closes currently opened file \n" +
                "save saves the currently open file \n" +
                "save as <file> saves the currently open file in <file> \n" +
                "help prints this information \n" +
                "exit exists the program \n"
        );


    }

    public boolean isOpen() {
        return isOpen;
    }
}