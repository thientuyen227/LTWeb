package vn.iotstar.service;

import vn.iotstar.model.DetailOrdersItem;

public interface detailOrdersItemService {
	DetailOrdersItem findOneByOrderId(int id);
}
