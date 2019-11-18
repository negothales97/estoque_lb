package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.BudgetDAO;
import br.com.casadocodigo.loja.dao.UserDAO;
import br.com.casadocodigo.loja.models.Budget;
import br.com.casadocodigo.loja.models.Category;
import br.com.casadocodigo.loja.models.User;

@Controller
@RequestMapping("/pedidos")
public class BudgetController {

	@Autowired
	private BudgetDAO dao;
	
	@Autowired
	private UserDAO userDao;
	

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
		List<User> users = userDao.index(null);
		modelAndView.addObject("users", users);
		modelAndView.addObject("pageName", "budget");
		modelAndView.addObject("budget", budget);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(Budget budget, HttpServletRequest req) {
		String userId = req.getParameter("userId");
		int user = Integer.parseInt(userId) ;
		User u = userDao.find(user);
		budget.setUser(u);
		System.out.println(budget.getId());
		budget.setTotal(0.0);
		dao.update(budget);
		return new ModelAndView("redirect:/pedidos/");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer categoryId) {
		dao.delete(categoryId);
		return new ModelAndView("redirect:/pedidos/");
	}
}
