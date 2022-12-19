package vn.iotstar.model;

import java.util.List;


public class Store extends AbstractModel<Store>{
	private String name;
	private String bio;
	private int ownerID;
	private boolean isOpen;
	private String avatar;
	private int rating;
	private double eWallet;
	private List<ImageStore> images;

	public List<ImageStore> getImages() {
		return images;
	}

	public void setImages(List<ImageStore> images) {
		this.images = images;
	}

	public double geteWallet() {
		return eWallet;
	}

	public void seteWallet(double eWallet) {
		this.eWallet = eWallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}


	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
