package fileWork;

import java.io.*;
import java.util.Scanner;

public class FileManipulator {
    private boolean isOpen = false;
    private boolean closeOrSave = false;

    public void commands(String pathName) {
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
                    open(pathName);
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            case "2":
                try {
                    close(pathName);
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
            case "3":
                save(pathName);
                break;
            case "4":
                saveAs(pathName);
                break;
            case "5":
                help();
                if (choice.equals("5")) {
                    commands(pathName);
                }
                break;
            case "6":
                System.exit(0);
                break;

        }
    }


    private void open(String pathName) throws IOException {

        File file = new File(pathName);
        if (file.exists()) {
            isOpen = true;
            System.out.println("Successfully opened " + pathName);
        } else {
            isOpen = file.createNewFile();
            System.out.println("Successfully created " + pathName);
        }

    }

    private void close(String pathName) throws IOException {
        if (isOpen) {

            System.out.println("Successfully closed " + pathName);
            closeOrSave = false;
            isOpen = false;
        } else {
            System.out.println("The file is not open");
        }
    }

    private void save(String pathName) {
        if (isOpen) {
            closeOrSave = true;
            System.out.println("Successfully saved " + pathName);
        } else {
            System.out.println("The file is not open");
        }
    }

    private void saveAs(String pathName) {
        if (isOpen) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("File Name");
            System.out.print("Change path: ");
            String newFileName = scanner.nextLine();
            closeOrSave = true;
            File file = new File(pathName);
            File file1 = new File("C:/xmlFiles/" + newFileName);

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

}