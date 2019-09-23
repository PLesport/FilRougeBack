package fr.plesport.pfr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.plesport.pfr.dao.ProductJpaRepository;
import fr.plesport.pfr.model.Product;
import fr.plesport.pfr.model.criteria.ProductSearchCriteria;

@Service
public class ProductService {
	@Autowired
	private ProductJpaRepository productJpaRepository;

	public void createProduct(Product product) {
		productJpaRepository.persist(product);
	}

	public void deleteProduct(Product product) {
		productJpaRepository.delete(product);
	}

	public void updateProduct(Product product) {
		productJpaRepository.update(product);
	}

	public Product findProductById(Long id) {
		return productJpaRepository.find(id);
	}

	public List<Product> findAll() {
		return productJpaRepository.findAll();
	}

	public List<Product> search(ProductSearchCriteria criteria) {
		return productJpaRepository.search(criteria);
	}
}
