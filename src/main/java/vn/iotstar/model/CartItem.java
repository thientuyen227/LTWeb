package vn.iotstar.model;


public class CartItem extends AbstractModel<CartItem>{
	private int cartId    ;
    private int productId ;
    private int count     ;
    private product product;

	public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

    }
