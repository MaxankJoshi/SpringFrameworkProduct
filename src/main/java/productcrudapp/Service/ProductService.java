package productcrudapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcrudapp.Dao.ProductDao;
import productcrudapp.Model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public void save(Product user) {
		this.productDao.saveProduct(user);
	}
	
	public Product getOneProduct(int pId) {
		Product product = this.productDao.getProduct(pId);
		
		return product;
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = this.productDao.getProducts();
		
		return products;
	}
	
	public void delete(int pId) {
		this.productDao.deleteProduct(pId);
	}
	
	public void update(Product product) {
		this.productDao.updateProduct(product);
	}
}
