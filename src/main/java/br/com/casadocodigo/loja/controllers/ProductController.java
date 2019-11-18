package br.com.casadocodigo.loja.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.CategoryDAO;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.models.Category;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.User;

@Controller
@RequestMapping("/produtos")
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
			String searchString = req.getParameter("searchString");
			System.out.println(searchString);
			List<Product> products = dao.index(searchString);
			ModelAndView modelAndView = new ModelAndView("product/index");
			modelAndView.addObject("pageName", "product");
			modelAndView.addObject("products", products);
			return modelAndView;
	}
	
	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("product/create");
		List<Category> categories = null;
		try {
			categories = categoryDao.index(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(Product product, HttpServletRequest req) {
		String categoryId = req.getParameter("categoryId");
		int category = Integer.parseInt(categoryId) ;
		Category c = categoryDao.find(category);
		product.setCategory(c);
		dao.save(product);
		return new ModelAndView("redirect:/produtos/");
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView edit(Integer productId) {
		Product product = dao.find(productId);
		
		List<Category> categories = null;
		try {
			categories = categoryDao.index(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("product/edit");
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(Product product, HttpServletRequest req) {
		String categoryId = req.getParameter("categoryId");
		int category = Integer.parseInt(categoryId) ;
		Category c = categoryDao.find(category);
		product.setCategory(c);
		dao.update(product);
		return new ModelAndView("redirect:/produtos/");
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(Integer productId) {
		dao.delete(productId);
		return new ModelAndView("redirect:/produtos/");
	}
}
