package vn.iotstar.controller.vendor;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/vendor"})
public class VendorController extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url= req.getRequestURL().toString();
		if(url.contains("vendor")) {
			req.getRequestDispatcher("/views/vendor/homeVendor.jsp").forward(req, resp);
		}
		
	}
	


}
