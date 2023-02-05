package productcrudapp.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.Model.Product;

@Repository
public class ProductDaoImplement implements ProductDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
//	To create
	
	@Transactional
	public void saveProduct(Product product) {
		this.hibernateTemplate.save(product);
	}
	
//	To get all products
	
	public List<Product> getProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
//	Delete the single product
	
	@Transactional
	public void deleteProduct(int pId) {
		Product product = this.hibernateTemplate.load(Product.class,pId);
		this.hibernateTemplate.delete(product);
	}
	
//	To get single product
	
	public Product getProduct(int pId) {
		Product product = this.hibernateTemplate.get(Product.class, pId);
		return product;
	}
	
//	To update a product
	@Transactional
	public void updateProduct(Product product) {
		this.hibernateTemplate.update(product);
	}
}
