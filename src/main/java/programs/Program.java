package programs;

import collections.Discipline;
import jakarta.xml.bind.annotation.*;

import java.util.HashSet;
@XmlRootElement(name = "Program")
@XmlAccessorType(XmlAccessType.FIELD)
public class Program {
    @XmlElement(name = "discipline")
    private HashSet<Discipline> disciplines= new HashSet<>();
    @XmlAttribute
    private String name;
    public Program(){}

    public Program(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    public void addDiscipline(Discipline disc){
        disciplines.add(disc);
    }

    public HashSet<Discipline> getDisciplines() {
        return disciplines;
    }
}
