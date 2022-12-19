package vn.iotstar.model;

public class category extends AbstractModel<category> {
	private String categoryName;
	private boolean isDelete;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	
}
