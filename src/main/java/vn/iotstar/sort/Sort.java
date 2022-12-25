package vn.iotstar.sort;

public class Sort {
	
	private String sortName;
	private String sortBy;
	
	public Sort(String sortName, String sortBy) {
		// TODO Auto-generated constructor stub
		this.sortBy=sortBy;
		this.sortName = sortName;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

}
