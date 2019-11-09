package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.CategoryDAO;
import br.com.casadocodigo.loja.models.Category;


@Controller
@RequestMapping("/categoria")
public class CategoryController {
	
	@Autowired
	private CategoryDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<Category> categories = dao.index(searchString);
		ModelAndView modelAndView = new ModelAndView("category/index");
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}
	
	@RequestMapping("criar")
	public ModelAndView create() {
		return new ModelAndView("category/create");
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(Category category) {
		dao.save(category);
		return new ModelAndView("redirect:/categoria/");
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView edit(Integer categoryId) {
		Category category = dao.find(categoryId);
		ModelAndView modelAndView = new ModelAndView("category/edit");
		modelAndView.addObject("category", category);
		return modelAndView;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(Category category) {
		dao.update(category);
		return new ModelAndView("redirect:/categoria/");
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(Integer categoryId) {
		dao.delete(categoryId);
		return new ModelAndView("redirect:/categoria/");
	}
	
	
	
	
	
	
}
