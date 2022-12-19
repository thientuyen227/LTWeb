package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.product;
import vn.iotstar.service.productService;
import vn.iotstar.service.impl.productServiceImpl;

@WebServlet(urlPatterns = { "/home/product", "/home/productdetail" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	productService productservice = new productServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("productdetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			product product = productservice.get(id);
			req.setAttribute("product", product);
			req.getRequestDispatcher("/views/user/productDetail.jsp").forward(req, resp);
		} else if (url.contains("product")) {

			List<product> productList = productservice.getAll();
			List<product> newListProduct = productservice.newListProduct();
			req.setAttribute("productList", productList);
			req.setAttribute("newListProduct", newListProduct);
			req.getRequestDispatcher("/views/user/product.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("product")) {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String searchKeyWord = req.getParameter("searchKeyWord");
			System.out.print(searchKeyWord);
			if (searchKeyWord != null) {
				List<product> searchProductByName = productservice.searchProductByName(searchKeyWord);
				req.setAttribute("productList", searchProductByName);
			}
			if (req.getParameter("productShowing") != null) {
				String productShowings = req.getParameter("productShowing");
				List<product> listShowings = productservice.listShowing(Integer.parseInt(productShowings));
				
				req.setAttribute("productList", listShowings);
			}
			if (req.getParameter("filterByPrice") != null) {
				String filterByPrice = req.getParameter("filterByPrice");
				List<product> listFilterByPrices = productservice.filterByPrice(filterByPrice);
				req.setAttribute("productList", listFilterByPrices);
			}
			if (req.getParameter("filterByRating") != null) {
				String filterByRating = req.getParameter("filterByRating");
				List<product> listFilterByRatings = productservice.filterByRating(Integer.parseInt(filterByRating));
				req.setAttribute("productList", listFilterByRatings);
			}
			

			req.getRequestDispatcher("/views/user/product.jsp").forward(req, resp);
		} else if (url.contains("detail")) {

			req.getRequestDispatcher("/views/user/productDetail.jsp").forward(req, resp);
		}
	}
}
