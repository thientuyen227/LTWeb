package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.service.impl.userFollowProductServiceImpl;
import vn.iotstar.service.impl.userFollowStoreServiceImpl;
import vn.iotstar.model.UserFollowProduct;
import vn.iotstar.model.UserFollowStore;
import vn.iotstar.model.user;
import vn.iotstar.service.userFollowProductService;
import vn.iotstar.service.userFollowStoreService;

@WebServlet(urlPatterns = { "/home/followingproduct", "/home/followingproduct/add", "/home/followingproduct/delete",
		"/home/followingstore", "/home/followingstore/add", "/home/followingstore/delete" })
public class followingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	userFollowProductService userFollowProductService = new userFollowProductServiceImpl();
	userFollowStoreService userFollowStoreService = new userFollowStoreServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("followingstore/add")) {
			user user = (user) req.getSession().getAttribute("User");
			UserFollowStore userFollowStore = new UserFollowStore();
			userFollowStore.setUserId(user.getId());
			userFollowStore.setStoreId(Integer.parseInt(req.getParameter("id")));
			userFollowStoreService.insert(userFollowStore);
			resp.sendRedirect(req.getContextPath() + "/home/followingstore");
		} else if (url.contains("followingproduct/add")) {
			user user = (user) req.getSession().getAttribute("User");
			UserFollowProduct userFollowProduct = new UserFollowProduct();
			userFollowProduct.setUserId(user.getId());
			userFollowProduct.setProductId(Integer.parseInt(req.getParameter("id")));
			userFollowProductService.insert(userFollowProduct);
			resp.sendRedirect(req.getContextPath() + "/home/followingproduct");
		} else if (url.contains("followingproduct/delete")) {
			userFollowProductService.delete(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + "/home/followingproduct");
		} else if (url.contains("followingstore/delete")) {
			userFollowStoreService.delete(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect(req.getContextPath() + "/home/followingstore");
		} else if (url.contains("followingproduct")) {
			user user = (user) req.getSession().getAttribute("User");
			if(user==null) {
				req.getRequestDispatcher("/views/user/followingProduct.jsp").forward(req, resp);
			}
			else {
				List<UserFollowProduct> userFollowProductList = userFollowProductService.findByUserId(user.getId());
				req.setAttribute("userFollowProductList", userFollowProductList);
				req.getRequestDispatcher("/views/user/followingProduct.jsp").forward(req, resp);
			}
		} else if (url.contains("followingstore")) {
			user user = (user) req.getSession().getAttribute("User");
			if(user==null) {
				req.getRequestDispatcher("/views/user/followingStore.jsp").forward(req, resp);
			}
			else {
				List<UserFollowStore> userFollowStoreList = userFollowStoreService.findByUserId(user.getId());
				req.setAttribute("userFollowStoreList", userFollowStoreList);
				req.getRequestDispatcher("/views/user/followingStore.jsp").forward(req, resp);
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
