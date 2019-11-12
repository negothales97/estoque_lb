package br.com.casadocodigo.loja.controllers;

import java.sql.SQLException;
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

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<Category> categories = null;
		try {
			categories = dao.index(searchString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("category/index");
		modelAndView.addObject("categories", categories);
		return modelAndView;
	}

	@RequestMapping("criar")
	public ModelAndView create() {
		return new ModelAndView("category/create");
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(Category category) {
		try {
			dao.save(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/categoria/");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(Integer categoryId) {
		Category category = dao.find(categoryId);
		ModelAndView modelAndView = new ModelAndView("category/edit");
		modelAndView.addObject("category", category);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(Category category) {
		try {
			dao.update(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/categoria/");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer categoryId) {
		try {
			dao.delete(categoryId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/categoria/");
	}

}
