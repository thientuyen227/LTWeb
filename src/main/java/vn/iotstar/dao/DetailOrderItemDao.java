package vn.iotstar.dao;

import vn.iotstar.model.DetailOrdersItem;

public interface DetailOrderItemDao {
	DetailOrdersItem findOneByOrderId(int id);
}