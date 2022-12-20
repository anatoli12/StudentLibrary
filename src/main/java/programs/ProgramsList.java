package programs;

import collections.DisciplinesList;

public class ProgramsList {
    private static ProgramsList programsList;
    private static Program sit;
    private static Program kst;
    private static Program ict;
    private ProgramsList() {
        sit = new Program("sit");
        sit.addDiscipline(DisciplinesList.getPf());
        sit.addDiscipline(DisciplinesList.getSis());
        sit.addDiscipline(DisciplinesList.getWeb());
        sit.addDiscipline(DisciplinesList.getAut());
        sit.addDiscipline(DisciplinesList.getMaths());
        sit.addDiscipline(DisciplinesList.getEl());

        kst = new Program("kst");
        kst.addDiscipline(DisciplinesList.getPf());
        kst.addDiscipline(DisciplinesList.getSis());
        kst.addDiscipline(DisciplinesList.getWeb());
        kst.addDiscipline(DisciplinesList.getAut());
        kst.addDiscipline(DisciplinesList.getMaths());
        kst.addDiscipline(DisciplinesList.getEl());

        ict = new Program("ict");
        ict.addDiscipline(DisciplinesList.getPf());
        ict.addDiscipline(DisciplinesList.getSis());
        ict.addDiscipline(DisciplinesList.getWeb());
        ict.addDiscipline(DisciplinesList.getAut());
        ict.addDiscipline(DisciplinesList.getMaths());
        ict.addDiscipline(DisciplinesList.getEl());
    }
    public static ProgramsList getInstance(){
        if(programsList == null)programsList=new ProgramsList();
        return programsList;
    }
    public Program programFinder(String pr){
        switch (pr) {
            case "sit":
                return sit;
            case "ict":
                return ict;
            case "kst":
                return kst;
        }
        return null;
    }
}
