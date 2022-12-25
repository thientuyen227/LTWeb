package vn.iotstar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.Store;
import vn.iotstar.service.storeService;
import vn.iotstar.service.impl.storeServiceImpl;

@WebServlet(urlPatterns = { "/admin/store", "/admin/storedetail", "/admin/store/isopen", "/admin/store/unisopen" })
public class StoreController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	storeService storeservice = new storeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if(url.contains("unisopen")) {
			int id = Integer.parseInt(req.getParameter("id"));
			storeservice.isOpen(0, id);
			resp.sendRedirect(req.getContextPath() + "/admin/store");
		}
		else if(url.contains("isopen")) {
			int id = Integer.parseInt(req.getParameter("id"));
			storeservice.isOpen(1, id);
			resp.sendRedirect(req.getContextPath() + "/admin/store");
		}
		else if (url.contains("storedetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Store store = storeservice.get(id);
			req.setAttribute("store", store);
			req.getRequestDispatcher("/views/admin/store/storeDetail.jsp").forward(req, resp);
		} else if (url.contains("/admin/store")) {
			List<Store> storeList = storeservice.getAllByAdmin();
			req.setAttribute("storeList", storeList);
			req.getRequestDispatcher("/views/admin/store/store.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
