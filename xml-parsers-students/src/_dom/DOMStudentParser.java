package _dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

import _sax.Student;

public class DOMStudentParser {
	
	public static void main(String[] args) throws SAXException, IOException{
		
		//создание DOM-анализатора (Xerces)
		
		 DOMParser parser = new DOMParser(); 
		 parser.parse("src/resources/students.xml");
		 Document document = parser.getDocument();
		 
		 Element root = document.getDocumentElement();

		 List<Student> students = new ArrayList<Student>();
			
			NodeList studentNodes = root.getElementsByTagName("student");
			Student student = null;
			for (int i = 0; i < studentNodes.getLength(); i++) {
				student = new Student();
				Element studentElement = (Element) studentNodes.item(i);
				student.setLogin(studentElement.getAttribute("login"));
				student.setName(getSingleChild(studentElement, "name").getTextContent().trim());
				student.setTelephone(getSingleChild(studentElement, "telephone").getTextContent().trim());
				student.setCountry(getSingleChild(studentElement, "country").getTextContent().trim());
				student.setCity(getSingleChild(studentElement, "city").getTextContent().trim());
				student.setStreet(getSingleChild(studentElement, "street").getTextContent().trim());
				students.add(student);
			}
			
			for (Student f: students) {
				System.out.println(f.getLogin() + ", " + f.getName() + ", " + f.getTelephone() + ", " + f.getCountry() + ", " + f.getCity() + ", " + f.getStreet());
			}

	}
	
	private static Element getSingleChild(Element element, String childName){
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}
}
