package vn.iotstar.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.Cart;
import vn.iotstar.model.CartItem;
import vn.iotstar.model.product;
import vn.iotstar.model.user;
import vn.iotstar.service.cartItemService;
import vn.iotstar.service.cartService;
import vn.iotstar.service.productService;
import vn.iotstar.service.storeService;
import vn.iotstar.service.userService;
import vn.iotstar.service.impl.cartItemServiceImpl;
import vn.iotstar.service.impl.cartServiceImpl;
import vn.iotstar.service.impl.productServiceImpl;
import vn.iotstar.service.impl.storeServiceImpl;
import vn.iotstar.service.impl.userServiceImpl;

@WebServlet(urlPatterns = { "/home/cart", "/home/cart/detail","/home/cart/detail/delete" })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	cartService cartservice= new cartServiceImpl();
	cartItemService cartitemservice = new cartItemServiceImpl();
	productService productservice = new productServiceImpl();
	storeService storeservice = new storeServiceImpl();
	userService userservice = new userServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url= req.getRequestURL().toString();
		if(url.contains("/home/cart/detail")){
			int id = Integer.parseInt(req.getParameter("id"));
			List<Cart> cartProductList = cartservice.getAllProduct(id);
			req.setAttribute("cartList", cartProductList);
			req.getRequestDispatcher("/views/user/cartDetail.jsp").forward(req, resp);
		}
		else if(url.contains("/home/cart")) {
			user user = (user) req.getSession().getAttribute("User");
			List<Cart> cartList = cartservice.findByUserId(user.getId());
			req.setAttribute("cartList", cartList);
			req.getRequestDispatcher("/views/user/cart.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url= req.getRequestURL().toString();
		if (url.contains("/web/cart/cartitem/add")) {
			insertItem(req, resp);
			resp.sendRedirect(req.getContextPath() + "/home/cart");
		}
	}

	protected void insertItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		product product = productservice.get(Integer.parseInt(req.getParameter("id")));
		user user = (user) req.getSession().getAttribute("User");
		Cart cart = cartservice.findByUserAndStore(user.getId(),product.getId() );
		if (cart == null) {
			cart = new Cart();
			cart.setUserId(user.getId());
			cart.setStoreId(product.getStoreId());
			cartservice.insert(cart);
			cart = cartservice.findByUserAndStore(user.getId(), product.getStoreId());
		}
		int count=0;
		if(req.getParameter("count")!=null) {
			count = Integer.parseInt(req.getParameter("count"));
		}
		else
			count=1;
		CartItem cartItem = new CartItem();
		CartItem cartItemTemp = cartitemservice.findByCartAndProduct(cart.getId(),Integer.parseInt(req.getParameter("id")));
		if (cartItemTemp == null) {
			cartItem.setCartId(cart.getId());
			cartItem.setProductId(Integer.parseInt(req.getParameter("id")));
			cartItem.setCount(count);
			cartitemservice.insert(cartItem);
		} else {
			cartItemTemp.setCount(count + cartItemTemp.getCount());
			cartitemservice.edit(cartItemTemp);
		}

		product.setQuantity(product.getQuantity() - count);
		productservice.edit(product);

	}
	
}
