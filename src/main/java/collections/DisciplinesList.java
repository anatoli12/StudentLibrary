package collections;

import java.util.ArrayList;

public final class DisciplinesList {
    private static ArrayList<Discipline> disciplines = new ArrayList<>();
    private static DisciplinesList disciplinesList;

    private DisciplinesList() {
        disciplines.add(new Discipline("Programming Fundamentals", true, 1,"PF"));
        disciplines.add(new Discipline("Web Design", true, 2,"WD"));
        disciplines.add(new Discipline("Electronics", false, 3,"EL"));
        disciplines.add(new Discipline("English", true, 4,"ENG"));
        disciplines.add(new Discipline("Computer Organisation", true, 1,"CO"));
        disciplines.add(new Discipline("Automation", false, 2,"AUT"));
        disciplines.add(new Discipline("Maths", true, 3,"MAT"));
        disciplines.add(new Discipline("OOP", true, 4,"OOP"));
        disciplines.add(new Discipline("Software specifications", false, 1,"SS"));
        disciplines.add(new Discipline("Programming systems", true, 2,"PS"));
        disciplines.add(new Discipline("Graphical systems", true, 3, "GS"));
        disciplines.add(new Discipline("Web Applications", false, 4,"WA"));
        disciplines.add(new Discipline("Databases", true, 1,"SQL"));
        disciplines.add(new Discipline("Programming Databases", true, 2, "PLSQL"));
        disciplines.add(new Discipline("Script Languages", false, 3,"SL"));
        disciplines.add(new Discipline("Data Structures and Algorithms", true, 4,"DS"));
        disciplines.add(new Discipline("System analysis", true, 1,"SA"));
    }

    public static DisciplinesList getInstance() {
        if (disciplinesList == null) disciplinesList = new DisciplinesList();
        return disciplinesList;
    }
}
