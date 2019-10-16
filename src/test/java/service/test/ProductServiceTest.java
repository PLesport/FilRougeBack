package service.test;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.plesport.pfr.App;
import fr.plesport.pfr.model.Product;
import fr.plesport.pfr.model.ProductAvailability;
import fr.plesport.pfr.model.ProductPackaging;
import fr.plesport.pfr.model.ProductType;
import fr.plesport.pfr.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	public void createTest() {
		Product product = new Product("thé blanc rouge", "il est blanc et rouge", "TBR", ProductType.THE_BLANC, "Zimbabwe", ProductPackaging.HUNDRED_GRAMS, BigDecimal.valueOf(12.5), 5, 16, ProductAvailability.AVAILABLE);
		productService.createProduct(product);
	}
	
	@Test
	public void createSameProductTest() {
		Product product = new Product("thé blanc rouge", "il est blanc et rouge", "TBR", ProductType.THE_BLANC, "Zimbabwe", ProductPackaging.HUNDRED_GRAMS, BigDecimal.valueOf(12.5), 5, 16, ProductAvailability.AVAILABLE);
		productService.createProduct(product);
	}
	
	@Test
	public void createNullProduct() {
		Product product = null;
		productService.createProduct(product);
	}
	
	@Test
	public void updateProductTest() {
		Product product = new Product("thé blanc rouge", "il est blanc et rouge", "TBR", ProductType.THE_ROOIBOS, "Zimbabwe", ProductPackaging.FIVE_HUNDRED_GRAMS, BigDecimal.valueOf(12.5), 5, 16, ProductAvailability.AVAILABLE);
		productService.updateProduct(product);
	}
	
	@Test
	public void findProductByIdTest() {
		Long id = 1L;
		productService.findProductById(id);
	}
	
	@Test
	public void deleteProductTest() {
		Long id = 1L;
		Product product = productService.findProductById(id);
		productService.deleteProduct(product);
	}
}
