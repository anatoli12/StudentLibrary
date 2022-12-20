package collections;

import java.util.ArrayList;

public final class DisciplinesList {
    private static DisciplinesList disciplinesList;
    private static final ArrayList<Discipline> disciplines=new ArrayList<>();
    private static final Discipline pf = new Discipline("Programming Fundamentals", true, 1, "pf");
    private static final Discipline wd =new Discipline("Web Design", true, 2, "wd");
    private static final Discipline el = new Discipline("Electronics", false, 3, "el");
    private static final Discipline english=new Discipline("English", true, 4, "english");
    private static final Discipline co = new Discipline("Computer Organisation", true, 1, "co");
    private static final Discipline aut = new Discipline("Automation", false, 2, "aut");
    private static final Discipline maths = new Discipline("Maths", true, 3, "maths");
    private static final Discipline oop = new Discipline("OOP", true, 4, "oop");
    private static final Discipline sis = new Discipline("Software specifications", false, 1, "sis");
    private static final Discipline ps = new  Discipline("Programming systems", true, 2, "ps");
    private static final Discipline gs = new  Discipline("Graphical systems", true, 3, "gs");
    private static final Discipline web = new  Discipline("Web Applications", false, 4, "web");
    private static final Discipline sql = new Discipline("Databases", true, 1, "sql");
    private static final Discipline plsql = new Discipline("Programming Databases", true, 2, "plsql");
    private static final Discipline sl = new Discipline("Script Languages", false, 3, "sl");
    private static final Discipline ds = new Discipline("Data Structures and Algorithms", true, 4, "ds");
    private static final Discipline sa = new Discipline("System analysis", true, 1, "sa");

    private DisciplinesList() {
        disciplines.add(pf);
        disciplines.add(wd);
        disciplines.add(el);
        disciplines.add(english);
        disciplines.add(co);
        disciplines.add(aut);
        disciplines.add(maths);
        disciplines.add(oop);
        disciplines.add(sis);
        disciplines.add(ps);
        disciplines.add(gs);
        disciplines.add(web);
        disciplines.add(sql);
        disciplines.add(plsql);
        disciplines.add(sl);
        disciplines.add(ds);
        disciplines.add(sa);
    }

    public static Discipline getPlsql() {
        return plsql;
    }

    public static Discipline getCo() {
        return co;
    }

    public static Discipline getDs() {
        return ds;
    }

    public static Discipline getEl() {
        return el;
    }

    public static Discipline getAut() {
        return aut;
    }

    public static Discipline getEnglish() {
        return english;
    }

    public static Discipline getGs() {
        return gs;
    }

    public static Discipline getEwd() {
        return wd;
    }

    public static Discipline getMaths() {
        return maths;
    }

    public static Discipline getPf() {
        return pf;
    }

    public static Discipline getPs() {
        return ps;
    }

    public static Discipline getOop() {
        return oop;
    }

    public static Discipline getSa() {
        return sa;
    }

    public static Discipline getSl() {
        return sl;
    }

    public static Discipline getSis() {
        return sis;
    }

    public static Discipline getSql() {
        return sql;
    }

    public static Discipline getWeb() {
        return web;
    }
    public static DisciplinesList getInstance(){
        if (disciplinesList == null) disciplinesList = new DisciplinesList();
        return disciplinesList;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }
}
