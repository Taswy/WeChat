package servlet_web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.WeixinTbl;
import dao.WeixinTblDAO;

public class login_web extends HttpServlet {
	private Session session = null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if(username!=null){
			WeixinTblDAO dao = new WeixinTblDAO();
			List<WeixinTbl> list = dao.findByName(username);
			if(list.isEmpty()){
				out.print("用户不存在");
				response.sendRedirect("index.jsp");
			}else{
				for(WeixinTbl weixin : list){
					if(weixin.getPassword().equals(pwd)){
						request.getSession().setAttribute("username", username);
						request.getSession().setAttribute("id_weixin_tbl", weixin.getIdWeixinTb().toString());
						request.getSession().setAttribute("openid", weixin.getOpenid());
						response.sendRedirect("success_web.jsp");
					}
					else {
						out.print("密码错误");
						response.sendRedirect("index.jsp");
					}
				}
			}
		}
	}
}
