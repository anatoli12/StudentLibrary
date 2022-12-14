package fileWork;

import collections.StudentGroup;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class ReadFromXml {
    public static StudentGroup execute(String path) throws JAXBException {
        File file = new File(path);
        JAXBContext context = JAXBContext.newInstance(StudentGroup.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (StudentGroup) unmarshaller.unmarshal(file);
    }
}
