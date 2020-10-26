package _sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxDemo {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		XMLReader reader = XMLReaderFactory.createXMLReader();
		StudentSaxHandler handler = new StudentSaxHandler();
		reader.setContentHandler(handler);
		//reader.setErrorHandler(handler);
		
		try{
			reader.parse(new InputSource("src/resources/students.xml"));
		}catch(Exception e){
			System.out.println("!!!!!!!!!!!!");
		}

	/*	// включение проверки действительности
		reader.setFeature("http://xml.org/sax/features/validation", true);

		// включение обработки пространств имен
		reader.setFeature("http://xml.org/sax/features/namespaces", true);

		// включение канонизации строк
		reader.setFeature("http://xml.org/sax/features/string-interning", true);

		// отключение обработки схем
		reader.setFeature("http://apache.org/xml/features/validation/schema",
				false);*/

		List<Student> students = handler.getStudentsList();

		for (Student student : students) {
			System.out.println(student.getLogin());
		}
	}
}
