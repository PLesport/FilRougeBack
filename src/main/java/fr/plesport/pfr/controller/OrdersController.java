package fr.plesport.pfr.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import fr.plesport.pfr.model.Orders;
import fr.plesport.pfr.model.OrdersStatus;
import fr.plesport.pfr.model.criteria.OrdersSearchCriteria;
import fr.plesport.pfr.service.OrdersService;
@Transactional
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	@Autowired
	OrdersService ordersService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createOrders(@RequestBody @Valid Orders orders) {
		ordersService.createOrders(orders);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteOrders(@PathVariable Long id) {
		Orders orders = ordersService.findOrdersById(id);
		ordersService.deleteOrders(orders);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Orders findOrdersById(@PathVariable Long id) {
		return ordersService.findOrdersById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Orders> findAll() {
		return ordersService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateOrders(@PathVariable Long id, @RequestBody @Valid Orders orders) {
		orders.setId(id);
		ordersService.updateOrders(orders);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Orders> search(@RequestParam(name = "ordersNumber", required = false) Long id,
								@RequestParam(required = false) LocalDateTime date, 
								@RequestParam(required = false) String shippingAddress,
								@RequestParam(required = false) String ordersStatus) {
		
		OrdersStatus ordersStatusT = ordersStatus != null ? OrdersStatus.valueOf(ordersStatus) : null;
		
		OrdersSearchCriteria criteria = new OrdersSearchCriteria(id, date, shippingAddress, ordersStatusT);
		return ordersService.search(criteria);
	}

}