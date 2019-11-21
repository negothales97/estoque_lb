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

import br.com.casadocodigo.loja.dao.UserDAO;
import br.com.casadocodigo.loja.models.User;
import br.com.casadocodigo.loja.validations.UserValidation;


@Controller
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired
	private UserDAO dao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidation());
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<User> users = dao.index(searchString);
		ModelAndView modelAndView = new ModelAndView("user/index");
		modelAndView.addObject("pageName", "user");
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("user/create");
		modelAndView.addObject("pageName", "user");
		return modelAndView;
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return create();
		}
		dao.save(user);
		redirectAttributes.addFlashAttribute("success", "Usuario Adicionado com sucesso");
		return new ModelAndView("redirect:/usuario/");
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView edit(Integer userID) {
		User user = dao.find(userID);
		ModelAndView modelAndView = new ModelAndView("user/edit");
		modelAndView.addObject("user", user);
		modelAndView.addObject("pageName", "user");
		return modelAndView;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return create();
		}
		dao.update(user);
		redirectAttributes.addFlashAttribute("success", "Usuario Atualizado com sucesso");
		return new ModelAndView("redirect:/usuario/");
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(Integer userID, RedirectAttributes redirectAttributes) {
		dao.delete(userID);

		redirectAttributes.addFlashAttribute("success", "Usuario Removido com sucesso");
		return new ModelAndView("redirect:/usuario/");
	}	
}
