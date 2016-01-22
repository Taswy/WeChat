package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SendMessage.Image;
import SendMessage.ImageMessage;
import SendMessage.TextMessage;
import util.Check;
import util.DataUtil;
import util.MessageUtil;
import util.SelectByJdbc;


public class WeChat extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		if (Check.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		PrintWriter out = response.getWriter();
		Map<String, String> map = MessageUtil.xmlToMap(request);
		String MsgType = map.get("MsgType");
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		if (MsgType.equals("text")) {
			String Content = map.get("Content");
			String message;
			if (Content.equals("图片")) {
				String MediaId = "bL_bAznVaRsh1hPs32Y7uBx5njDqPnVLuCh2t_kwQws7r6i-uF8kwf99XEPcZpgm";
				ImageMessage imageMessage = new ImageMessage(FromUserName, ToUserName);
				Image image = new Image();
				image.setMediaId(MediaId);
				imageMessage.setImage(image);
				message = MessageUtil.MessageToXml(imageMessage,"image");
			}
			else {
				TextMessage textMessage = new SendMessage.TextMessage(FromUserName, ToUserName);
				textMessage.setContent("你发送的内容是:\n"+Content +"\n现在时间是：\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				message = MessageUtil.MessageToXml(textMessage,"");
			}
			System.out.println(message);
			out.print(message);
		}
		else if (MsgType.equals("event")) {
			//查询我的数据
			if (map.get("Event").equals("CLICK")) {
				if (map.get("EventKey").equals("11")) {
					String message;
					String data = null;
					data = SelectByJdbc.getAll(FromUserName);
					TextMessage textMessage = new SendMessage.TextMessage(FromUserName, ToUserName);
					textMessage.setContent("数据是： "+data);
					message = MessageUtil.MessageToXml(textMessage,"");
					out.print(message);
				}
				
			}
			//关注后的推送
			else if (map.get("Event").equals("subscribe")) {
				String message;
				TextMessage textMessage = new SendMessage.TextMessage(FromUserName, ToUserName);
				textMessage.setContent("感谢您的关注，这是智能充电系统的测试号！");
				message = MessageUtil.MessageToXml(textMessage,"");
				out.print(message);
			}
			
		}

		
		
	}

}
