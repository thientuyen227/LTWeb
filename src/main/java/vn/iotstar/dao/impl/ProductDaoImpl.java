package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.product;
import vn.iotstar.service.categoryService;
import vn.iotstar.service.storeService;
import vn.iotstar.service.impl.categoryServiceImpl;
import vn.iotstar.service.impl.storeServiceImpl;

public class ProductDaoImpl extends DBConnection implements ProductDao {

	@Override
	public void insert(product product) {
		String sql = "INSERT INTO product(name, description, price, promotionalPrice, quantity, sold,"
				+ "categoryId, storedId, rating) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getname());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setInt(7, product.getCategoryId());
			ps.setInt(8, product.getStoreId());
			ps.setInt(9, product.getRating());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET name = ?, description=?, price=?, promotionalPrice=?, quantity=?, sold=?,"
				+ "categoryId=?, storedId=?, rating=?" + ", WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getname());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getPromotionalPrice());
			ps.setInt(5, product.getQuantity());
			ps.setInt(6, product.getSold());
			ps.setInt(7, product.getCategoryId());
			ps.setInt(8, product.getStoreId());
			ps.setInt(9, product.getRating());
			ps.setInt(10, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public product get(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product where id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				return product;
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<product> getAll() {
		// TODO Auto-generated method stub
		List<product> listProduct = new ArrayList<product>();
		String sql = "SELECT * FROM product where isActive=1";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));

				listProduct.add(product);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public List<product> searchProductByName(String keyword) {
		// TODO Auto-generated method stub
		List<product> listProductByName = new ArrayList<product>();
		String sql = "select * from product where name like concat('%',?,'%')";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				listProductByName.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listProductByName;
	}

	@Override
	public product findById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from product " + "where id =?";	
		categoryService categoryservice = new categoryServiceImpl();
		storeService storeservice = new storeServiceImpl();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setStore(storeservice.get(product.getStoreId()));
				product.setCategory(categoryservice.get(rs.getInt("categoryId")));
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<product> newProductList() {
		// TODO Auto-generated method stub
		List<product> listNewProduct = new ArrayList<product>();
		String sql = "select * from product order by createdat desc limit 2";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));

				listNewProduct.add(product);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listNewProduct;

	}

	@Override
	public List<product> getTopRating(int index) {
		// TODO Auto-generated method stub
		String sql = new String("select * from product\n" + "order by rating DESC\n" + "limit ?");
		List<product> products = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));

				product.setCreateAt(rs.getTimestamp("createAt"));
				product.setUpdateAt(rs.getTimestamp("updateAt"));

				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<product> filterByPrice(String price0) {
		// TODO Auto-generated method stub
		String sql = new String("select * from product where promotionalPrice > ? and promotionalPrice <= ? ");
		List<product> products = new ArrayList<>();
		String[] price= price0.split("-");
		Double price1= Double.parseDouble(price[0]);
		Double price2= Double.parseDouble(price[1]);
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, price1);
			ps.setDouble(2, price2);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));

				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<product> filterByRating(int index) {
		// TODO Auto-generated method stub
		String sql = new String("select * from product where rating like ?");
		List<product> products = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<product> listShowing(int index) {
		// TODO Auto-generated method stub
		String sql = new String("select * from product limit ?");
		List<product> products = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, index);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setActive(rs.getBoolean("isActive"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));

				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void isActive(int isActive,int id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET isActive=? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, isActive);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<product> getAllProductByAdmin() {
		// TODO Auto-generated method stub
		List<product> listProduct = new ArrayList<product>();
		String sql = "SELECT * FROM product";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setActive(rs.getBoolean("isActive"));
				listProduct.add(product);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

	@Override
	public List<product> getProductOfStore(int storeId) {
		// TODO Auto-generated method stub
		List<product> listProduct = new ArrayList<product>();
		String sql = "SELECT * FROM product where storeId=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storeId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product product = new product();
				product.setId(rs.getInt("id"));
				product.setname(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setPromotionalPrice(rs.getDouble("promotionalPrice"));
				product.setQuantity(rs.getInt("quantity"));
				product.setSold(rs.getInt("sold"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setStoreId(rs.getInt("storeId"));
				product.setRating(rs.getInt("rating"));
				product.setActive(rs.getBoolean("isActive"));
				listProduct.add(product);
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return listProduct;
	}

}
