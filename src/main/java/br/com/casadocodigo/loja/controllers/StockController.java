package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.CategoryDAO;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.dao.StockDAO;
import br.com.casadocodigo.loja.models.Category;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.models.Stock;

@Controller
@RequestMapping("/produtos")
public class StockController {
	
	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private StockDAO stockDao;
	
	@RequestMapping("criar")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("stock/create");
		return modelAndView;
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public ModelAndView save(Stock stock, HttpServletRequest req) {
		String productId = req.getParameter("productId");
		int product = Integer.parseInt(productId) ;
		Product p = productDao.find(product);
		stock.setProduct(p);
		stockDao.save(stock);
		return new ModelAndView("redirect:/produtos/");
	}
		
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView delete(Integer stockId) {
		stockDao.delete(stockId);
		return new ModelAndView("redirect:/produtos/");
	}
}