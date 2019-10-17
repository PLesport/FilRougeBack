package fr.plesport.pfr.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.plesport.pfr.dao.OrdersJpaRepository;
import fr.plesport.pfr.dao.RightJpaRepository;
import fr.plesport.pfr.dao.RoleJpaRepository;
import fr.plesport.pfr.dao.UserJpaRepository;
import fr.plesport.pfr.model.OrderLine;
import fr.plesport.pfr.model.Orders;
import fr.plesport.pfr.model.Right;
import fr.plesport.pfr.model.Role;
import fr.plesport.pfr.model.User;
import fr.plesport.pfr.model.UserCivility;


@Component
public class InitializationBean {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private RoleJpaRepository roleRepository;

	@Autowired
	private RightJpaRepository rightRepository;

	@Autowired
	private OrdersJpaRepository ordersJpaRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {

		if (userJpaRepository.findAll().isEmpty()) {
			Right createProductRight = new Right("C_PRODUCT");
			Right createOrderRight = new Right("C_ORDER");
			Right createUserRight = new Right("C_USER");
			Right createOrderLineRight = new Right("C_ORDERLINE");
			Right createNewsLetterRight = new Right("C_NEWSLETTER");
			Right createBlogRight = new Right("C_BLOG");

			Right findOrderRight = new Right("F_ORDER");
			Right findProductRight = new Right("F_PRODUCT");
			Right findUserRight = new Right("F_USER");
			Right findOrderLineRight = new Right("F_ORDERLINE");
			Right findNewsLetterRight = new Right("F_NEWSLETTER");
			Right findBlogRight = new Right("F_BLOG");

			Right updateProductRight = new Right("U_PRODUCT");
			Right updateOrderRight = new Right("U_ORDER");
			Right updateUserRight = new Right("U_USER");
			Right updateOrderLineRight = new Right("U_ORDERLINE");
			Right updateNewsLetterRight = new Right("U_NEWSLETTER");
			Right updateBlogRight = new Right("U_BLOG");

			Right deleteProductRight = new Right("D_PRODUCT");
			Right deleteUserRight = new Right("D_USER");
			Right deleteOrderRight = new Right("D_ORDER");
			Right deleteOrderLineRight = new Right("D_ORDERLINE");
			Right deleteNewsLetterRight = new Right("D_NEWSLETTER");
			Right deleteBlogRight = new Right("D_BLOG");

			rightRepository.persist(createProductRight);
			rightRepository.persist(createOrderRight);
			rightRepository.persist(createUserRight);
			rightRepository.persist(createOrderLineRight);
			rightRepository.persist(createNewsLetterRight);
			rightRepository.persist(createBlogRight);
			
			rightRepository.persist(findOrderRight);
			rightRepository.persist(findProductRight);
			rightRepository.persist(findUserRight);
			rightRepository.persist(findOrderLineRight);
			rightRepository.persist(findNewsLetterRight);
			rightRepository.persist(findBlogRight);

			rightRepository.persist(updateProductRight);
			rightRepository.persist(updateOrderRight);
			rightRepository.persist(updateUserRight);
			rightRepository.persist(updateOrderLineRight);
			rightRepository.persist(updateNewsLetterRight);
			rightRepository.persist(updateBlogRight);

			rightRepository.persist(deleteProductRight);
			rightRepository.persist(deleteUserRight);
			rightRepository.persist(deleteOrderRight);
			rightRepository.persist(deleteOrderLineRight);
			rightRepository.persist(deleteNewsLetterRight);
			rightRepository.persist(deleteBlogRight);

			List<Right> rightsCustomerList = new ArrayList<Right>();
			rightsCustomerList.add(findProductRight);
			rightsCustomerList.add(createOrderRight);
			rightsCustomerList.add(updateUserRight);
			rightsCustomerList.add(findOrderRight);
			rightsCustomerList.add(deleteOrderRight);

			List<Right> rightsAdminList = new ArrayList<Right>();
			rightsAdminList.addAll(rightsCustomerList);
			rightsAdminList.add(createProductRight);
			rightsAdminList.add(createOrderRight);
			rightsAdminList.add(createUserRight);
			rightsAdminList.add(createOrderLineRight);
			rightsAdminList.add(createNewsLetterRight);
			rightsAdminList.add(createBlogRight);
			rightsAdminList.add(findUserRight);
			rightsAdminList.add(findNewsLetterRight);
			rightsAdminList.add(findBlogRight);
			rightsAdminList.add(updateProductRight);
			rightsAdminList.add(updateOrderRight);
			rightsAdminList.add(updateOrderLineRight);
			rightsAdminList.add(updateNewsLetterRight);
			rightsAdminList.add(updateBlogRight);
			rightsAdminList.add(deleteProductRight);
			rightsAdminList.add(deleteUserRight);
			rightsAdminList.add(deleteOrderRight);
			rightsAdminList.add(deleteOrderLineRight);
			rightsAdminList.add(deleteNewsLetterRight);
			rightsAdminList.add(deleteBlogRight);

			Role adminRole = new Role("ADMIN");
			adminRole.setRights(rightsAdminList);
			Role customerRole = new Role("CUSTOMER");
			customerRole.setRights(rightsCustomerList);

			roleRepository.persist(adminRole);
			roleRepository.persist(customerRole);

			User userAdmin = new User(UserCivility.MR, "Jacques", "Bobiche", "70 rue de la louche", "Montpellier", "34000", "0645342312", "admin@sas.net", passwordEncoder.encode("admin"));
			userAdmin.setRole(adminRole);
			User userCustomer = new User(UserCivility.MME, "Jeanne", "Delapoutre", "59 rue de la cuillère", "Montpellier", "34000", "0645343412", "customer@sas.net", passwordEncoder.encode("customer"));
			userCustomer.setRole(customerRole);
			
			userJpaRepository.persist(userAdmin);
			userJpaRepository.persist(userCustomer);


			Orders orderCustomer = new Orders();
			List<OrderLine> commandeligne = new ArrayList<OrderLine>();
			commandeligne.add(null);
			commandeligne.add(null);
			
			ordersJpaRepository.persist(orderCustomer);
		}
	}
}

