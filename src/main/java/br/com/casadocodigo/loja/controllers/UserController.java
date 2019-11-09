package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.UserDAO;
import br.com.casadocodigo.loja.models.User;


@Controller
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired
	private UserDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		List<User> users = dao.index(searchString);
		ModelAndView modelAndView = new ModelAndView("user/index");
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@RequestMapping("criar")
	public ModelAndView create() {
		return new ModelAndView("user/create");
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(User user) {
		dao.save(user);
		return new ModelAndView("redirect:/usuario/");
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView edit(Integer userID) {
		User user = dao.find(userID);
		ModelAndView modelAndView = new ModelAndView("user/edit");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(User user) {
		dao.update(user);
		return new ModelAndView("redirect:/usuario/");
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(Integer userID) {
		dao.delete(userID);
		return new ModelAndView("redirect:/usuario/");
	}	
}
