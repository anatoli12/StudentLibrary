package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MenuPatterns {
    static String fn="\\d{8}";
    static String name="\\w+[\\s\\w]*";
    private static MenuPatterns menuPatterns;
    static Pattern enrollPattern = Pattern.compile("\\s*enroll\\s+(?<fn>"+fn+")\\s+(?<program>\\w+)\\s+(?<group>\\d)\\s+(?<name>"+name+")");

    static Pattern advancePattern=Pattern.compile("\\s*advance\\s+("+fn+")\\s*");
    static Pattern changeProgramPattern= Pattern.compile("\\s*change\\s+(?<fn>"+fn+")\\s+program\\s+(?<program>\\w+)\\s*");
    static Pattern changeGroupPattern= Pattern.compile("\\s*change\\s+(?<fn>"+fn+")\\s+group\\s+(?<group>\\d)\\s*");
    static Pattern changeYearPattern= Pattern.compile("\\s*change\\s+(?<fn>"+fn+")\\s+year\\s+(?<year>\\d)\\s*");
    static Pattern graduatePattern = Pattern.compile("\\s*graduate\\s+(?<fn>"+fn+")\\s*");
    static Pattern interruptPattern = Pattern.compile("\\s*interrupt\\s+(?<fn>"+fn+")\\s*");
    static Pattern resumePattern = Pattern.compile("\\s*resume\\s+(?<fn>"+fn+")\\s*");
    static Pattern printPattern = Pattern.compile("\\s*print\\s+(?<fn>"+fn+")\\s*");
    static Pattern printAllPattern = Pattern.compile("\\s*printall\\s+(?<program>\\w+)\\s+(?<year>\\d)\\s*");
    static Pattern enrollInPattern = Pattern.compile("\\s*enrollin\\s+(?<fn>"+fn+")\\s(?<course>\\w+)\\s*");
    static Pattern addGradePattern = Pattern.compile("\\s*addgrade\\s+(?<fn>"+fn+")\\s(?<course>\\w+)\\s+(?<grade>[23456]([\\.,]?(\\d\\d?))?)\\s*");
    static Pattern protocolPattern = Pattern.compile("\\s*protocol\\s+(?<course>\\w+)\\s*");
    static Pattern reportPattern = Pattern.compile("\\s*report\\s+(?<fn>"+fn+")\\s*");
    static Pattern filesPattern = Pattern.compile("\\s*files\\s*");

    private static final List<Pattern> patterns = new ArrayList<>();
    private MenuPatterns(){
        patterns.add(enrollPattern);
        patterns.add(advancePattern);
        patterns.add(changeGroupPattern);
        patterns.add(changeProgramPattern);
        patterns.add(changeYearPattern);
        patterns.add(graduatePattern);
        patterns.add(interruptPattern);
        patterns.add(resumePattern);
        patterns.add(printPattern);
        patterns.add(printAllPattern);
        patterns.add(enrollInPattern);
        patterns.add(addGradePattern);
        patterns.add(protocolPattern);
        patterns.add(reportPattern);
        patterns.add(filesPattern);
    }
    public static MenuPatterns getInstance(){
        if(menuPatterns==null)menuPatterns=new MenuPatterns();
        return menuPatterns;
    }

    public static List<Pattern> getPatterns() {
        return patterns;
    }
}
