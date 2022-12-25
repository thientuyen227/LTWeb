package vn.iotstar.controller.vendor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.Store;
import vn.iotstar.model.user;
import vn.iotstar.service.storeService;
import vn.iotstar.service.impl.storeServiceImpl;

@WebServlet(urlPatterns = { "/vendor/store", "/vendor/store/add","/vendor/store/edit", "/vendor/storedetail" })
public class StoreController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	storeService storeservice = new storeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("add")) {
			req.getRequestDispatcher("/views/vendor/store/add.jsp").forward(req, resp);
		}
		else if (url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Store store = storeservice.get(id);
			req.setAttribute("store", store);
			req.getRequestDispatcher("/views/vendor/store/edit.jsp").forward(req, resp);
		}
		else if (url.contains("storedetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Store store = storeservice.get(id);
			req.setAttribute("store", store);
			req.getRequestDispatcher("/views/vendor/store/storeDetail.jsp").forward(req, resp);
		} else if (url.contains("store")) {
			
			user user = (user) req.getSession().getAttribute("User");
			List<Store> storeList = storeservice.findByUserId(user.getId());
			req.setAttribute("storeList", storeList);
			req.getRequestDispatcher("/views/vendor/store/store.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (url.contains("/vendor/store/add")) {
			System.out.print("add");
            String storeName = req.getParameter("storename");
            String avatar = req.getParameter("avatar");
            String Bio = req.getParameter("bio");
            int ownerId = Integer.parseInt(req.getParameter("ownerId"));
            System.out.print("ownerId:" + ownerId);
            Store store = new Store();
            store.setAvatar(avatar);
            store.setName(storeName);
            store.setBio(Bio);
            store.setOwnerID(ownerId);
            storeservice.insert(store);
            resp.sendRedirect(req.getContextPath() + "/vendor/store");
        }
		else if (url.contains("edit")) {
            String storeName = req.getParameter("storename");
            String avatar = req.getParameter("avatar");
            String Bio = req.getParameter("bio");
            int ownerId = 1;
            int storeId = Integer.parseInt(req.getParameter("id"));
            Store store = new Store();
            store.setAvatar(avatar);
            store.setName(storeName);
            store.setBio(Bio);
            store.setOwnerID(ownerId);
            store.setId(storeId);
            storeservice.edit(store);
            resp.sendRedirect(req.getContextPath() + "/vendor/store");
        } 
		else if (url.contains("store")) {
			req.getRequestDispatcher("/views/vendor/store/store.jsp").forward(req, resp);
		} else if (url.contains("detail")) {
			req.getRequestDispatcher("/views/vendor/store/storeDetail.jsp").forward(req, resp);
		}
		
	}

}
