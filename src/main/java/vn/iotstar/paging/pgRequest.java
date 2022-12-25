package vn.iotstar.paging;

import vn.iotstar.sort.Sort;

public class pgRequest implements pgEble {
	
	private Integer page;
	private Integer maxPageItem;
	private Sort sort;
	
	public pgRequest(Integer page, Integer maxPageItem, Sort sort) {
		// TODO Auto-generated constructor stub
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sort = sort;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		if (this.page != null && this.maxPageItem != null) {
			return (this.page - 1)*this.maxPageItem;			
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		if (this.sort != null) {
			return this.sort;
		}
		return null;
	}

}
