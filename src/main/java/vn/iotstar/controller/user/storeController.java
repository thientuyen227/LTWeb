package vn.iotstar.controller.user;

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

@WebServlet(urlPatterns = { "/home/store", "/home/storedetail" })
public class storeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	storeService storeservice = new storeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("storedetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Store store = storeservice.get(id);
			req.setAttribute("store", store);
			req.getRequestDispatcher("/views/user/storeDetail.jsp").forward(req, resp);
		} else if (url.contains("store")) {
			List<Store> storeList = storeservice.getAll();
			req.setAttribute("storeList", storeList);
			req.getRequestDispatcher("/views/user/store.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURL().toString();
		if (url.contains("store")) {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String searchKeyWord = req.getParameter("searchKeyWord");
			System.out.print(searchKeyWord);
			if (searchKeyWord != null) {
				List<Store> searchStoreByName = storeservice.findAllByName(searchKeyWord);
				req.setAttribute("storeList", searchStoreByName);
			}
			req.getRequestDispatcher("/views/user/store.jsp").forward(req, resp);
		} else if (url.contains("detail")) {

			req.getRequestDispatcher("/views/user/storeDetail.jsp").forward(req, resp);
		}
	}

}
