package _stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAxFilterExample {

	public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
		FileInputStream fis = new FileInputStream("src/resources/students.xml");

		 XMLInputFactory xmlif = null;

	     xmlif = XMLInputFactory.newInstance();
	        
		XMLStreamReader xmlr = xmlif.createFilteredReader(
				xmlif.createXMLStreamReader(fis), new MyStAXFilter());

		int eventType = xmlr.getEventType();
		System.out.println("event type: " + eventType);
		while (xmlr.hasNext()) {
			eventType = xmlr.next();
			System.out.println("event type: " + eventType); 
			if (xmlr.hasName()) {
	            System.out.println("name: " + xmlr.getLocalName());
	        }
			if (xmlr.hasText()) {
	            System.out.println("text: " + xmlr.getText());
	        }



		}

	}

}

class MyStAXFilter implements StreamFilter {
	public boolean accept(XMLStreamReader reader) {
		if (!reader.isStartElement() && !reader.isEndElement()) {
			return false;
		} else {
			return true;
		}
	}
}
