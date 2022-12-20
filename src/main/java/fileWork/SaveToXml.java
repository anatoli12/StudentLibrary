package fileWork;

import collections.StudentGroup;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaveToXml {
    public static void execute(StudentGroup studentGroup, String path) throws JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(StudentGroup.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(studentGroup, new FileOutputStream(path));
    }
}
