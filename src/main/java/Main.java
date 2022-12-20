
import fileWork.FileManipulator;
import menu.MainMenu;
public class Main {
    public static void main(String[] args) {
        final String fileName = args[0];
        FileManipulator fm = new FileManipulator(fileName);
        while(true) {
            fm.commands();
            if(fm.isOpen()) MainMenu.execute();
        }
    }
}
