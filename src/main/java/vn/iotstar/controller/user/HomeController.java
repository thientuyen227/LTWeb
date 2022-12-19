package vn.iotstar.controller.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.category;
import vn.iotstar.model.product;
import vn.iotstar.service.categoryService;
import vn.iotstar.service.productService;
import vn.iotstar.service.impl.categoryServiceImpl;
import vn.iotstar.service.impl.productServiceImpl;

@WebServlet (urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;	
	productService productservice= new productServiceImpl();
	categoryService categoryService = new categoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url= req.getRequestURL().toString();
		if(url.contains("/home")) {
			List<category> categoryList = categoryService.getAll();
			List<product> productList = productservice.getAll();
			List<product> newListProduct = productservice.newListProduct();
			req.setAttribute("categoryList", categoryList);
			req.setAttribute("productList", productList);
			req.setAttribute("newListProduct", newListProduct);
			req.getRequestDispatcher("/views/user/web.jsp").forward(req, resp);
		}
		
	}
	


}
