package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import po.HibernateSessionFactory;
import po.WeixinTbl;
import dao.WeixinTblDAO;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		out.print("username:" + username + "\n");
		System.out.println("username:" + username);
		if (username != null) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			WeixinTblDAO dao = new WeixinTblDAO();
			List<WeixinTbl> list = dao.findByName(username);
			if (list.isEmpty()) {
					String password = request.getParameter("pwd");
					String openid = request.getParameter("openid");
							WeixinTbl weixin = new WeixinTbl(username, password, openid);
						try {
							dao.save(weixin);
							tx.commit();
							session.close();
							out.print("ע��ɹ����󶨣�");
						} catch (Exception e) {
							out.print("ע��ʧ�ܣ�");
						}
				}
			else {
				out.print("�û��Ѵ���");
			}
			out.close();
		}

		out.close();
	}



}
