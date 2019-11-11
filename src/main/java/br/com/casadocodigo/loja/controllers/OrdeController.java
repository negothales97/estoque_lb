package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.OrderDAO;
import br.com.casadocodigo.loja.models.Order;

@Controller
@RequestMapping("/pedidos")
public class OrdeController {

	@Autowired
	private OrderDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<Order> orders = dao.index(searchString);
		ModelAndView modelAndView = new ModelAndView("order/index");
		modelAndView.addObject("orders", orders);
		return modelAndView;
	}

	@RequestMapping("criar")
	public ModelAndView create() {
		return new ModelAndView("order/create");
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(Order order) {
		dao.save(order);
		return new ModelAndView("redirect:/categoria/");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(Integer orderId) {
		Order order = dao.find(orderId);
		ModelAndView modelAndView = new ModelAndView("order/edit");
		modelAndView.addObject("order", order);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(Order order) {
		dao.update(order);
		return new ModelAndView("redirect:/order/");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer categoryId) {
		dao.delete(categoryId);
		return new ModelAndView("redirect:/categoria/");
	}
}
