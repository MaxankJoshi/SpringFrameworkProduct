package productcrudapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import productcrudapp.Model.Product;
import productcrudapp.Service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService service;
	
//	To Show home page
	
	@RequestMapping({"/home","/"})
	public String home(Model m) {
		List<Product> products =  service.getAllProducts();
		m.addAttribute("products", products);
		
		return "index";
	}
	
//	To Show add product form
	
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		
		return "add_product_form";
	}
	
//	To handle add product form
	
	@RequestMapping(path="/handle-product", method=RequestMethod.POST)
	public String handleProduct(@ModelAttribute("product") Product product) {
		System.out.println(product);
		
		this.service.save(product);
		
		return "redirect:/";
	}
	
//	delete handler
	
	@RequestMapping(path="/delete/{productId}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("productId") int productId) {
		this.service.delete(productId);
		
		return "redirect:/";
	}
	
//	Update handler
	
	@RequestMapping(path="/update/{productId}", method=RequestMethod.GET) 
	public String openUpdateForm(@PathVariable("productId") int productId, Model m) {
		Product product = this.service.getOneProduct(productId);
		m.addAttribute("title", "Update Product");
		m.addAttribute("product", product);
		
		return "update_form";
	}
	
	@RequestMapping(path="/update-product", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute("product") Product product) {
		this.service.update(product);
		
		return "redirect:/";
	}
	
}
