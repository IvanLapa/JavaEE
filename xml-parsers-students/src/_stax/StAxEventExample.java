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
		List<Student> menu = new ArrayList<Student>();
		Student food = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

		XMLEventReader xmlEventReader = xmlInputFactory
				.createXMLEventReader(new FileInputStream("menu.xml"));
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			if (xmlEvent.isStartElement()) {
				StartElement startElement = xmlEvent.asStartElement();
				if (startElement.getName().getLocalPart().equals("food")) {
					food = new Student();
					Attribute idAttr = startElement
							.getAttributeByName(new QName("id"));
					if (idAttr != null) {
						food.setId(Integer.parseInt(idAttr.getValue()));
					}
				}
			}
			else if (xmlEvent.isEndElement()){
				EndElement endElement = xmlEvent.asEndElement();
				if (endElement.getName().getLocalPart().equals("food")) {
					menu.add(food);
				}
			}
		}
		
		for (Student f : menu) {
			System.out.println(f.getId());
		}
	}
}
