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

@WebServlet(urlPatterns = "/home/signin/profileuser")
public class ProfileUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	userService userservice= new userServiceImpl();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("profileuser")) {
			req.getRequestDispatcher("/views/user/profileUser.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("profileuser")) {
			user User = new user();
			int id= ((user) req.getSession().getAttribute("User")).getId();
			User.setId(id);
			User.setAvatar(req.getParameter("avatar"));
			User.setFirstname(req.getParameter("firstname"));
			User.setLastname(req.getParameter("lastname"));
			User.setEmail(req.getParameter("email"));
			User.setPhone(req.getParameter("phone"));
			User.setId_card(req.getParameter("id_card"));
			User.setRole(req.getParameter("role"));
			User.seteWallet(0);
			
			userservice.edit(User);
			req.getSession().setAttribute("User", User);
			resp.sendRedirect(req.getContextPath() + "/home/signin/profileuser");
		}
	}

}
