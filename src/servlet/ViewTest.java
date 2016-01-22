package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javassist.compiler.ast.NewExpr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.WeixinTbl;

import net.sf.json.JSONObject;

import util.Check;
import util.WeChatUtil;

public class ViewTest extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		System.out.println(code);
		JSONObject jsonObject;
		jsonObject = WeChatUtil.getInfor(WeChatUtil.getOpenid(code));
		System.out.println("用户名： "+jsonObject.getString("nickname"));
		System.out.println("性别： "+jsonObject.getString("sex"));
		System.out.println("城市： "+jsonObject.getString("city"));
		System.out.println("省份： "+jsonObject.getString("province"));
		System.out.println("国家： "+jsonObject.getString("country"));
		System.out.println("头像： "+jsonObject.getString("headimgurl"));
		String openid = jsonObject.getString("openid");
		WeixinTbl	user =	Check.checkBind(openid);
		if(user!=null)
		{
			request.getSession().setAttribute("username",user.getName());
			response.sendRedirect("successBind.jsp");
		}else {
			request.getSession().setAttribute("openid",openid);
			response.sendRedirect("login.jsp");
		}
	
	}

}
