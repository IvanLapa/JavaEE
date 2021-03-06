package _java._ee._02._jsptag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import _java._ee._02._jspbean.JSPSetBean;

public class SpecialJSPTag extends TagSupport  {
	private JSPSetBean set;
	
	public JSPSetBean getSet() {
		return set;
	}

	public void setSet(JSPSetBean set) {
		this.set = set;
	}


	@Override
	public int doStartTag() throws JspException {
		int size = new Integer(set.getSize());
		String str = "Size = <b>(" + size + ")</b>";
		try{
			JspWriter out = pageContext.getOut();
			out.write(str);
			
			out.write("<table border=\"1\">");
			for(int i=0; i<size; i++){
				out.write("<tr><td>");
				out.write(set.getElement());
				out.write("</td></tr>");
			}
			out.write("</table>");
			
		}catch(IOException e){
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
}
