package vn.iotstar.controller.admin;

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


@WebServlet(urlPatterns = {"/admin/category", "/admin/product", "/admin/product/unisactive", "/admin/product/isactive", "/admin/productdetail", "/admin/category/add", "/admin/category/edit","/admin/category/delete"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	categoryService categoryservice= new categoryServiceImpl();
	productService productservice = new productServiceImpl();
	
	

	public ProductController() {
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		
		if(url.contains("/admin/product/isactive")) {
			int id = Integer.parseInt(req.getParameter("id"));
			productservice.isActive(1, id);
			resp.sendRedirect(req.getContextPath() + "/admin/product");
		}
		else if(url.contains("/admin/product/unisactive")) {
			int id = Integer.parseInt(req.getParameter("id"));
			productservice.isActive(0, id);
			resp.sendRedirect(req.getContextPath() + "/admin/product");
		}
		else if(url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			category category = categoryservice.get(id);
			req.setAttribute("category", category);
			req.getRequestDispatcher("/views/admin/product/category/edit.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryservice.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/category");
        }
		else  if (url.contains("/admin/category")) {
			List<category> categoryList = categoryservice.getAll();
			req.setAttribute("categoryList", categoryList);
            req.getRequestDispatcher("/views/admin/product/category/category.jsp").forward(req, resp);
        }
		else if(url.contains("/admin/productdetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			product product = productservice.get(id);
			req.setAttribute("product", product);
            req.getRequestDispatcher("/views/admin/product/productDetail.jsp").forward(req, resp);
		}
		else if(url.contains("/admin/product")) {
			List<product> productList = productservice.getAllProductByAdmin();
			req.setAttribute("productList", productList);
            req.getRequestDispatcher("/views/admin/product/product.jsp").forward(req, resp);
		}
		
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURL().toString();
		if (url.contains("/admin/category/add")) {
            String categoryName = req.getParameter("categoryName");
            category category = new category();
            category.setCategoryName(categoryName);
            categoryservice.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category");
        }
		else if (url.contains("/admin/category/edit")) {
            String categoryName = req.getParameter("categoryName");
            int categoryId = Integer.parseInt(req.getParameter("id"));
            category category = new category();
            category.setCategoryName(categoryName);
            category.setId(categoryId);
            categoryservice.edit(category);
            resp.sendRedirect(req.getContextPath() + "/admin/category");
        }
		else if (req.getParameter("productShowing") != null) {
			String productShowings = req.getParameter("productShowing");
			List<product> listShowings = productservice.listShowing(Integer.parseInt(productShowings));
			req.setAttribute("productList", listShowings);
			req.getRequestDispatcher("/views/admin/product/product.jsp").forward(req, resp);
		}

	}

}
