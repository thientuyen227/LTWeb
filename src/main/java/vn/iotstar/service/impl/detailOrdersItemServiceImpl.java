package vn.iotstar.service.impl;


import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.DetailOrderItemDao;
import vn.iotstar.dao.impl.DetailOrderItemDaoImpl;
import vn.iotstar.model.DetailOrdersItem;
import vn.iotstar.service.detailOrdersItemService;

public class detailOrdersItemServiceImpl extends DBConnection implements detailOrdersItemService {
	DetailOrderItemDao detailOrderItemDao = new DetailOrderItemDaoImpl();

	@Override
	public DetailOrdersItem findOneByOrderId(int id) {
		// TODO Auto-generated method stub
		return detailOrderItemDao.findOneByOrderId(id);
	}
    
}
