package util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import ReceiveMessage.TextMessage;
import SendMessage.Image;
import com.thoughtworks.xstream.XStream;


public class MessageUtil {
	public static Map<String, String> xmlToMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader  reader = new SAXReader();
		try {
			InputStream ins = request.getInputStream();
			Document document = reader.read(ins);
			Element root = document.getRootElement();
			List<Element> list = root.elements();
			
			for (Element element : list) {
				map.put(element.getName(),element.getText());
			}
			ins.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;	
	}
	
	public static String MessageToXml(Object object,String type) {
		XStream xStream = new XStream();
		xStream.alias("xml", object.getClass());
		if (type.equals("image")) {
			xStream.alias("Image", new Image().getClass());
		}
		return xStream.toXML(object);
	}

}
