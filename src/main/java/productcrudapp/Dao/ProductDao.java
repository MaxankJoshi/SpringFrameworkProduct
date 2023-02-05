package productcrudapp.Dao;

import java.util.List;

import productcrudapp.Model.Product;

public interface ProductDao {
	public void saveProduct(Product product);
	public List<Product> getProducts();
	public void deleteProduct(int pId);
	public Product getProduct(int pId);
	public void updateProduct(Product product);
}
