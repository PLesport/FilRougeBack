package fr.plesport.pfr.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.plesport.pfr.model.OrderLine;
import fr.plesport.pfr.model.criteria.OrderLineSearchCriteria;
import fr.plesport.pfr.service.OrderLineService;
@Transactional
@RestController
@RequestMapping("/api/orderlines")
public class OrderLineController {

	@Autowired
	OrderLineService orderLineService;
	
	@PreAuthorize("hasAuthority('C_ORDERLINE')")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createOrderLine(@RequestBody @Valid OrderLine orderLine) {
		orderLineService.createOrderLine(orderLine);
	}

	@PreAuthorize("hasAuthority('D_ORDERLINE')")
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteOrderLine(@PathVariable Long id) {
		OrderLine orderLine = orderLineService.findOrderLineById(id);
		orderLineService.deleteOrderLine(orderLine);
	}

	@PreAuthorize("hasAuthority('F_ORDERLINE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public OrderLine findOrderLineById(@PathVariable Long id) {
		return orderLineService.findOrderLineById(id);
	}

	@PreAuthorize("hasAuthority('F_ORDERLINE')")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<OrderLine> findAll() {
		return orderLineService.findAll();
	}

	@PreAuthorize("hasAuthority('U_ORDERLINE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateOrderLine(@PathVariable Long id, @RequestBody @Valid OrderLine orderLine) {
		orderLine.setId(id);
		orderLineService.updateOrderLine(orderLine);
	}

	@PreAuthorize("hasAuthority('F_ORDERLINE')")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<OrderLine> search(@RequestParam(name = "orderLineNumber", required = false) Long id,
			@RequestParam(required = false) Integer quantity) {
		OrderLineSearchCriteria criteria = new OrderLineSearchCriteria(id, quantity);
		return orderLineService.search(criteria);
	}

}
