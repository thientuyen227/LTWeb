package vn.iotstar.controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.product;
import vn.iotstar.service.categoryService;
import vn.iotstar.service.productService;
import vn.iotstar.service.impl.categoryServiceImpl;
import vn.iotstar.service.impl.productServiceImpl;


@WebServlet(urlPatterns = {"/vendor/product"})
public class ProductController extends HttpServlet {

	categoryService categoryservice= new categoryServiceImpl();
	productService productservice = new productServiceImpl();
	
	private static final long serialVersionUID = 1L;

	public ProductController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("product")) {
			List<product> productList = productservice.getAllProductByAdmin();
			req.setAttribute("productList", productList);
            req.getRequestDispatcher("/views/admin/product/product.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
