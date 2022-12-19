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

@WebServlet(urlPatterns = "/home/signup")
public class SignUpController extends HttpServlet {

	userService userservice = new userServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("signup")){
			req.getRequestDispatcher("/views/user/signUp.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("signup")) {
			String firstName = req.getParameter("firstname");
			String lastName = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String id_card = req.getParameter("id_card");
			String password =req.getParameter("password");
			user user=new user();
			user.setFirstname(firstName);
			user.setLastname(lastName);
			user.setEmail(email);
			user.setPhone(phone);
			user.setId_card(id_card);
			user.setPassword(password);
			userservice.insert(user);
			resp.sendRedirect(req.getContextPath() + "/home/signin");
		}
	}

}
