package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "validaAdmin", method = RequestMethod.POST)
	public ModelAndView validaAdmin(HttpServletRequest req, RedirectAttributes redirectAttributes) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(password);
		if(email.equals("admin@admin.com") && password.equals("010203") || email.equals("admin@admin.com.br") && password.equals("123456") ) {
			return new ModelAndView("redirect:/produtos/");
		}else {
			redirectAttributes.addFlashAttribute("error", "Dados de login inválido");
			return new ModelAndView("redirect:/");
		}
		
	}
}
