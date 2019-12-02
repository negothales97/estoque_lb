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
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.models.Category;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validations.CategoryValidation;
import br.com.casadocodigo.loja.validations.ProductValidation;

@Controller
@RequestMapping("/produtos")
public class ProductController {

	@Autowired
	private ProductDAO dao;

	@Autowired
	private CategoryDAO categoryDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidation());
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<Product> products = dao.index(searchString);
		int soma= 0;
		for (Product product : products) {
			soma += product.getId();
		}
		System.out.println(soma);
		System.out.println(products.get(1).getCategory().getName());
		ModelAndView modelAndView = new ModelAndView("product/index");
		modelAndView.addObject("pageName", "product");
		modelAndView.addObject("products", products);
		return modelAndView;
	}

	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("product/create");
		List<Category> categories = null;
		categories = categoryDao.index(null);
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("pageName", "product");
		return modelAndView;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes,
			HttpServletRequest req) {
		if (result.hasErrors()) {
			return create();
		}
		String categoryId = req.getParameter("categoryId");
		int category = Integer.parseInt(categoryId);
		Category c = categoryDao.find(category);
		product.setCategory(c);
		dao.save(product);
		redirectAttributes.addFlashAttribute("success", "Produto Adicionado com sucesso");
		return new ModelAndView("redirect:/produtos/");
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(Integer productId) {
		Product product = dao.find(productId);

		List<Category> categories = null;
		categories = categoryDao.index(null);
		ModelAndView modelAndView = new ModelAndView("product/edit");
		modelAndView.addObject("categories", categories);
		modelAndView.addObject("pageName", "product");
		modelAndView.addObject("product", product);
		return modelAndView;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@Valid Product product, BindingResult result, RedirectAttributes redirectAttributes, HttpServletRequest req) {
		if (result.hasErrors()) {
			return create();
		}
		String categoryId = req.getParameter("categoryId");
		int category = Integer.parseInt(categoryId);
		Category c = categoryDao.find(category);
		product.setCategory(c);
		dao.update(product);
		redirectAttributes.addFlashAttribute("success", "Produto Atualizado com sucesso");
		return new ModelAndView("redirect:/produtos/");
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer productId, RedirectAttributes redirectAttributes) {
		dao.delete(productId);
		redirectAttributes.addFlashAttribute("success", "Produto Removido com sucesso");
		return new ModelAndView("redirect:/produtos/");
	}
}
