package _sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentSaxHandler extends DefaultHandler {
	private List<Student> studentsList = new ArrayList<Student>();
	
	private Student student;
	private StringBuilder text;

	public List<Student> getStudentsList() {
		return studentsList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName: " + localName
				+ ", qName: " + qName);
		
		text = new StringBuilder();
		if (qName.equals("student")){
			student = new Student();
			student.setLogin(attributes.getValue("login"));
		}
	}
	
	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		StudentTagName tagName = StudentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){
		case NAME:
			student.setName(text.toString());
			break;
		case TELEPHONE:
			student.setTelephone(text.toString());
			break;
		case ADDRESS:
			System.out.println("Y");
			break;
		case COUNTRY:
			student.setCountry(text.toString());
			break;
		case CITY:
			student.setCity(text.toString());
			break;
		case STREET:
			student.setStreet(text.toString());
			break;
		case STUDENT:
			studentsList.add(student);
			student = null;
			break;		
		}
	}

    public void warning(SAXParseException exception) {
		System.out.println("WARNING: line " + exception.getLineNumber() );
	}

	public void error(SAXParseException exception) {
		System.out.println("ERROR: line " + exception.getLineNumber() );
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("FATAL: line " + exception.getLineNumber() );
		throw (exception);
	}
}

