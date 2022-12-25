package vn.iotstar.paging;

import vn.iotstar.sort.Sort;

public interface pgEble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sort getSort();
}
