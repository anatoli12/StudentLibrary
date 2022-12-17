package fileWork;

import collections.StudentGroup;
import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.util.Scanner;

public class FileManipulator {
    private String pathName;
    private boolean isOpen = false;
    private boolean closeOrSave = false;


    public FileManipulator(String pathName) {
        this.pathName = pathName;
    }

    public void commands() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("*****MENU*****");
        System.out.println("1-> Open");
        System.out.println("2-> Close");
        System.out.println("3-> Save");
        System.out.println("4-> Save as");
        System.out.println("5-> Help");
        System.out.println("6-> Exit");
        System.out.println("**************");
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                try {
                    open();
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            case "2":
                try {
                    close();
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            case "3":
                save();
                break;
            case "4":
                saveAs();
                break;
            case "5":
                help();
                if (choice.equals("5")) {
                    commands();
                }
                break;
            case "6":
                System.exit(0);
                break;

        }
    }


    private void open() throws IOException {

        File file = new File(pathName);
        if (file.exists()) {
            isOpen = true;
            System.out.println("Successfully opened " + pathName);
        } else {
            isOpen = file.createNewFile();
            System.out.println("Successfully created " + pathName);
        }

    }

    private void close() throws IOException {
        if (isOpen) {

            System.out.println("Successfully closed " + pathName);
            closeOrSave = false;
            isOpen = false;
        } else {
            System.out.println("The file is not open");
        }
    }

    private void save() {
        if (isOpen) {
            closeOrSave = true;
            System.out.println("Successfully saved " + pathName);
        } else {
            System.out.println("The file is not open");
        }
    }

    private void saveAs() {
        if (isOpen) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("File Name");
            System.out.print("Change path: ");
            String newFileName = scanner.nextLine();
            closeOrSave = true;
            File file = new File(pathName);
            File file1 = new File(newFileName);
            boolean bool = file.renameTo(file1);
            if (bool) {
                System.out.println("Successfully saved another " + newFileName);
            } else {
                System.out.println("Unable to move the file ........");
            }


        } else {
            System.out.println("The file is not open");
        }
    }

    private void help() {
        System.out.println("> help \n" +
                "The following commands are supported: \n" +
                "open <file> opens <file> \n" +
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

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public boolean isCloseOrSave() {
        return closeOrSave;
    }

    public void setCloseOrSave(boolean closeOrSave) {
        this.closeOrSave = closeOrSave;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}