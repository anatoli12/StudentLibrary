package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MenuPatterns {
    static String fn="\\d{8}";
    static String name="\\w+[\\s\\w]*";
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
    static Pattern reportPattern = Pattern.compile("\\s*report\\s+(?<fn>"+fn+")");
}
