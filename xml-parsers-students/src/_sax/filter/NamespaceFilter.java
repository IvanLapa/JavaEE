package _sax.filter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class NamespaceFilter extends XMLFilterImpl {
	
	public NamespaceFilter(XMLReader reader){
		super(reader);
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("----in NamespaceFilter");
		super.startElement(uri+"2", localName, qName, attributes);
	}
}
