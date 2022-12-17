package collections;

public class Discipline {
    private String name;
    private String shortName;
    private boolean isMandatory;
    private int year;

    public Discipline(String name, boolean isMandatory, int year, String shortName) {
        this.name = name;
        this.isMandatory = isMandatory;
        this.year = year;
        this.shortName=shortName;
    }
}
