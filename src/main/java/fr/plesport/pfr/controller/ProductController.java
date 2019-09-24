package fr.plesport.pfr.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.plesport.pfr.model.Product;
import fr.plesport.pfr.model.ProductAvailability;
import fr.plesport.pfr.model.ProductPackaging;
import fr.plesport.pfr.model.ProductType;
import fr.plesport.pfr.model.criteria.ProductSearchCriteria;
import fr.plesport.pfr.service.ProductService;
@Transactional
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteProduct(@PathVariable Long id) {
		Product product = productService.findProductById(id);
		productService.deleteProduct(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Product findProductById(@PathVariable Long id) {
		return productService.findProductById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Product> findAll() {
		return productService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		productService.updateProduct(product);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Product> search(@RequestParam(name = "productNumber", required = false) Long id, //
			@RequestParam(required = false) String name, //
			@RequestParam(required = false) String description, //
			@RequestParam(required = false) String reference, //
			@RequestParam(required = false) String type, //
			@RequestParam(required = false) String origin, //
			@RequestParam(required = false) String packaging, //
			@RequestParam(required = false) Long price, //
			@RequestParam(required = false) Integer discountRate, //
			@RequestParam(required = false) Integer stock, //
			@RequestParam(required = false) String status) {

		ProductType typeT = type != null ? ProductType.valueOf(type) : null;
		ProductPackaging packagingT = packaging != null ? ProductPackaging.valueOf(packaging) : null;
		BigDecimal priceT = price != null ? BigDecimal.valueOf(price) : null;
		ProductAvailability statusT = status != null ? ProductAvailability.valueOf(status) : null;

		ProductSearchCriteria criteria = new ProductSearchCriteria(id, name, description, reference, typeT, origin,
				packagingT, priceT, discountRate, stock, statusT);

		return productService.search(criteria);

	}

}
