package collections;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Discipline {
    private String name;
    @XmlTransient
    private boolean isMandatory;
    @XmlTransient
    private int year;
    private String tag;

    public Discipline(String name, boolean isMandatory, int year, String tag) {
        this.name = name;
        this.isMandatory = isMandatory;
        this.year = year;
        this.tag=tag;
    }
    public Discipline(){}

    public String getName() {
        return name;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public int getYear() {
        return year;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
