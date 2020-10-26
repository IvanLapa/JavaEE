package _stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import _sax.Student;

public class StAXStudentParser {

	public static void main(String[] args) throws FileNotFoundException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("src/resources/students.xml");

			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Student> students = process(reader);

			for (Student student: students) {
				System.out.println(student.getName());
				System.out.println(student.getTelephone());
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	private static List<Student> process(XMLStreamReader reader)
			throws XMLStreamException {
		
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		
		StudentTagName elementName = null;
		while (reader.hasNext()) {

			int type = reader.next();
			
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = StudentTagName.getElementTagName(reader
						.getLocalName());
				switch (elementName) {
				case STUDENT:
					student = new Student();
					String login = reader.getAttributeValue(
							null, "login")
;
					student.setLogin(login);
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case NAME:
					student.setName(text);
					break;
				case TELEPHONE:
					student.setTelephone(text);
					break;
				case ADDRESS:
					//student.setDescription(text);
					break;
				case COUNTRY:
					student.setCountry(text);
					break;
				case CITY:
					student.setCity(text);
					break;
				case STREET:
					student.setStreet(text);
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = StudentTagName.getElementTagName(reader
						.getLocalName());
				switch (elementName) {
				case STUDENT:
					students.add(student);
				}

			}

		}
		return students;
	}
}
