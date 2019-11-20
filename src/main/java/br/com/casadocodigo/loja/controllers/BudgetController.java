package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.BudgetDAO;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.dao.UserDAO;
import br.com.casadocodigo.loja.models.Budget;
import br.com.casadocodigo.loja.models.BudgetProduct;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.User;

@Controller
@RequestMapping("/pedidos")
public class BudgetController {

	@Autowired
	private BudgetDAO dao;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ProductDAO prodDao;
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		List<Budget> budgets = dao.index();
		ModelAndView modelAndView = new ModelAndView("budget/index");
		modelAndView.addObject("budgets", budgets);
		modelAndView.addObject("pageName", "budget");
		return modelAndView;
	}

	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("budget/create");
		List<User> users = userDao.index(null);
		modelAndView.addObject("users", users);
		modelAndView.addObject("pageName", "budget");
		return modelAndView; 
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(Budget budget, HttpServletRequest req) {
		String userId = req.getParameter("userId");
		int user = Integer.parseInt(userId) ;
		User u = userDao.find(user);
		budget.setUser(u);
		
		double total = 0.0;
		budget.setTotal(total);
		
		dao.save(budget);
		return new ModelAndView("redirect:/pedidos/");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(Integer budgetId) {
		Budget budget = dao.find(budgetId);
		ModelAndView modelAndView = new ModelAndView("budget/edit");
		
		List<BudgetProduct> budgetProducts = dao.findBudgetProducts(budget);
		List<User> users = userDao.index(null);
		List<Product> products = prodDao.index(null);
		List<Budget> otherBudgets = dao.index();
		
		modelAndView.addObject("users", users);
		modelAndView.addObject("pageName", "budget");
		modelAndView.addObject("products", products);
		modelAndView.addObject("otherBudgets", otherBudgets);
		modelAndView.addObject("budgetProducts", budgetProducts);
		modelAndView.addObject("budget", budget);
		return modelAndView;
	}

//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public ModelAndView update(Budget budget, HttpServletRequest req) {
//		String userId = req.getParameter("userId");
//		int user = Integer.parseInt(userId) ;
//		User u = userDao.find(user);
//		budget.setUser(u);
//		budget.setTotal(0.0);
//		dao.update(budget);
//		return new ModelAndView("redirect:/pedidos/");
//	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer budgetId) {
		dao.delete(budgetId);
		return new ModelAndView("redirect:/pedidos/");
	}

	@RequestMapping(value = "includeProduct", method = RequestMethod.POST)
	public ModelAndView includeProduct(BudgetProduct budgetProduct, HttpServletRequest req) {
		Double total = budgetProduct.getPrice() * budgetProduct.getQtd();
		budgetProduct.setTotal(total);
		
		String idBudget = req.getParameter("idBudget");
		int budget = Integer.parseInt(idBudget);
		Budget b = dao.find(budget);
		budgetProduct.setBudget(b);
		
		String idProduct = req.getParameter("idProduct");
		int product = Integer.parseInt(idProduct);
		Product p = prodDao.find(product);
		budgetProduct.setProduct(p);
		dao.includeProduct(budgetProduct);
		
		Double totalBudget = dao.getTotalBudget(budget);
		b.setTotal(totalBudget);
		dao.update(b);
		
		return new ModelAndView("redirect:/pedidos/edit?budgetId="+idBudget);
	}
	
	@RequestMapping(value = "removeProduct", method = RequestMethod.GET)
	public ModelAndView removeProduct(Integer budgetProductId) {
		dao.removeProduct(budgetProductId);
		return new ModelAndView("redirect:/pedidos/");
	}
}
