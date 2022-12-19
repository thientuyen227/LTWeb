package vn.iotstar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.user;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.userServiceImpl;

@WebServlet(urlPatterns = { "/home/signin","/home/signout" })
public class SignInController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	userService userservice = new userServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("signin")) {
			req.getRequestDispatcher("/views/user/signIn.jsp").forward(req, resp);
		}
		else if(url.contains("signout")){
			req.getSession().removeAttribute("User");
			resp.sendRedirect(req.getContextPath() + "/home/signin");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("/signin")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			user users = userservice.signIn(username, password);
			if (users != null) {
				if(users.getRole().equals("user")) {
					req.getSession().setAttribute("User", users);
					resp.sendRedirect(req.getContextPath() + "/home");
				}
				else if(users.getRole().equals("admin")){
					req.getSession().setAttribute("admin", users);
					resp.sendRedirect(req.getContextPath() + "/admin");
				}
			} 
			else {
				req.getRequestDispatcher("/views/user/signIn.jsp").forward(req, resp);
			}

		}

	}

}
