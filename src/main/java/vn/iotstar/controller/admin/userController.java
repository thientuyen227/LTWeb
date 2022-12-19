package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.user;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.userServiceImpl;


@WebServlet(urlPatterns = {"/admin/user","/admin/user/add", "/admin/user/delete", "/admin/user/edit"})
public class userController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	userService userservice = new userServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url= req.getRequestURL().toString();
		if(url.contains("/user/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			user user = userservice.get(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/admin/user/profileUser.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/user/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            userservice.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/user");
        }else if(url.contains("/user/profileuser")){
			int id = Integer.parseInt(req.getParameter("id"));
			user user = userservice.get(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/admin/user/profileUser.jsp").forward(req, resp);
		}
		
		else if(url.contains("/user")) {
			List<user> userList = userservice.getAll();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/views/admin/user/user.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/user/edit")) {
			String avatar = req.getParameter("avatar");
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String id_card = req.getParameter("id_card");
            String role = req.getParameter("role");
            int userId = Integer.parseInt(req.getParameter("id"));
            user user = new user();
            user.setAvatar(avatar);
            user.setFirstname(firstName);
            user.setLastname(lastName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setId_card(id_card);
            user.setRole(role);
            user.setId(userId);
            userservice.edit(user);
            resp.sendRedirect(req.getContextPath() + "/admin/user");
        }
		else if(url.contains("/user/add")) {
			req.getRequestDispatcher("/views/user/signUp.jsp").forward(req, resp);
		}
	}
	
}
