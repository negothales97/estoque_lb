package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.CategoryDAO;
import br.com.casadocodigo.loja.models.Category;
import br.com.casadocodigo.loja.validations.CategoryValidation;

@Controller
@RequestMapping("/categoria")
public class CategoryController {

	@Autowired
	private CategoryDAO dao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new CategoryValidation());
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<Category> categories = null;
		categories = dao.index(searchString);
		ModelAndView modelAndView = new ModelAndView("category/index");
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("pageName", "category");
		return modelAndView;
	}

	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("category/create");
		modelAndView.addObject("pageName", "category");
		return modelAndView;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return create();
		}
		dao.save(category);
		redirectAttributes.addFlashAttribute("success", "Categoria Adicionada com sucesso");
		return new ModelAndView("redirect:/categoria/");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(Integer categoryId) {
		Category category = dao.find(categoryId);
		ModelAndView modelAndView = new ModelAndView("category/edit");
		modelAndView.addObject("category", category);
		modelAndView.addObject("pageName", "category");
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@Valid Category category, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			//Arrumar redirect update
			return create();
		}
		dao.update(category);
		redirectAttributes.addFlashAttribute("success", "Categoria Atualizada com sucesso");
		return new ModelAndView("redirect:/categoria/");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer categoryId, RedirectAttributes redirectAttributes) {
		dao.delete(categoryId);
		redirectAttributes.addFlashAttribute("success", "Categoria Removida com sucesso");
		return new ModelAndView("redirect:/categoria/");
	}

}
