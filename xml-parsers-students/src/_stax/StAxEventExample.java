package _stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import _sax.Student;

public class StAxEventExample {

	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException {
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

		XMLEventReader xmlEventReader = xmlInputFactory
				.createXMLEventReader(new FileInputStream("src/resources/students.xml"));
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			if (xmlEvent.isStartElement()) {
				StartElement startElement = xmlEvent.asStartElement();
				if (startElement.getName().getLocalPart().equals("student")) {
					student = new Student();
					Attribute idAttr = startElement
							.getAttributeByName(new QName("login"));
					if (idAttr != null) {
						student.setLogin(idAttr.getValue());
					}
				}
			}
			else if (xmlEvent.isEndElement()){
				EndElement endElement = xmlEvent.asEndElement();
				if (endElement.getName().getLocalPart().equals("student")) {
					students.add(student);
				}
			}
		}
		
		for (Student s : students) {
			System.out.println(s.getLogin());
		}
	}
}
