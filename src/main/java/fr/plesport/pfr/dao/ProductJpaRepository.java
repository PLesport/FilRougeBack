package fr.plesport.pfr.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import fr.plesport.pfr.model.Product;
import fr.plesport.pfr.model.criteria.ProductSearchCriteria;

@Repository
public class ProductJpaRepository extends AbstractJpaRepository<Product> {
	public ProductJpaRepository() {
		super(Product.class);
	}

	public List<Product> search(ProductSearchCriteria criteria) {
		String qlQuery = "from Product p";
		if (criteria.hasCriterias()) {
			qlQuery += " where 1=1";
		}
		if (criteria.getId() != null) {
			qlQuery += " and p.id = :id";
		}
		if (!StringUtils.isEmpty(criteria.getReference())) {
			qlQuery += " and p.reference = :reference";
		}
		if (criteria.getType() != null) {
			qlQuery += " and p.type = :type";
		}
		if (!StringUtils.isEmpty(criteria.getOrigin())) {
			qlQuery += " and p.origin = :origin";
		}
		if (criteria.getPackaging() != null) {
			qlQuery += " and p.packaging = :packaging";
		}
		if (criteria.getPrice() != null) {
			qlQuery += " and p.price = :price";
		}
		if (criteria.getDiscountRate() != null) {
			qlQuery += " and p.discountRate = :discountRate";
		}
		if (criteria.getStock() != null) {
			qlQuery += " and p.stock = :stock";
		}
		if (criteria.getStatus() != null) {
			qlQuery += " and p.status = :status";
		}

		TypedQuery<Product> query = em.createQuery(qlQuery, Product.class);

		if (criteria.hasCriterias()) {
			if (criteria.getId() != null) {
				query.setParameter("id", criteria.getId());
			}
			if (!StringUtils.isEmpty(criteria.getReference())) {
				String reference = criteria.getReference().toLowerCase();
				query.setParameter("reference", "%" + reference + "%");
			}
			if (criteria.getType() != null) {
				query.setParameter("type", criteria.getType());
			}
			if (!StringUtils.isEmpty(criteria.getOrigin())) {
				String origin = criteria.getOrigin().toLowerCase();
				query.setParameter("origin", "%" + origin + "%");
			}
			if (criteria.getPackaging() != null) {
				query.setParameter("packaging", criteria.getPackaging());
			}
			if (criteria.getPrice() != null) {
				query.setParameter("price", criteria.getPrice());
			}
			if (criteria.getDiscountRate() != null) {
				query.setParameter("discountRate", criteria.getDiscountRate());
			}
			if (criteria.getStock() != null) {
				query.setParameter("stock", criteria.getStock());
			}
			if (criteria.getStatus() != null) {
				query.setParameter("status", criteria.getStatus());
			}
		}

		return query.getResultList();
	}
}
