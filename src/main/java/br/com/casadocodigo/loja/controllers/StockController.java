package br.com.casadocodigo.loja.controllers;

/*
 * 
 * 
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import br.com.casadocodigo.loja.dao.StockDAO; import
 * br.com.casadocodigo.loja.models.Stock;
 * 
 * 
 * 
 * @Controller
 * 
 * @RequestMapping("/estoque") public class StockController {
 * 
 * @Autowired private StockDAO dao;
 * 
 * @Autowired private CategoryDAO categoryDao;
 * 
 * @RequestMapping(method=RequestMethod.GET) public ModelAndView
 * index(HttpServletRequest req) { String qtdString =
 * req.getParameter("qtdString"); System.out.println(qtdString); List<Stock>
 * stock = dao.index(searchString); ModelAndView modelAndView = new
 * ModelAndView("product/index"); modelAndView.addObject("products", products);
 * return modelAndView; }
 * 
 * @RequestMapping("criar") public ModelAndView create() { ModelAndView
 * modelAndView = new ModelAndView("estoque/create"); List<Stock> stocks =
 * dao.index(null); modelAndView.addObject("estoques", stocks); return
 * modelAndView; }
 * 
 * @RequestMapping(value="save", method=RequestMethod.POST) public ModelAndView
 * save(Product product, HttpServletRequest req) { String categoryId =
 * req.getParameter("categoryId"); int category = Integer.parseInt(categoryId) ;
 * Category c = categoryDao.find(category); product.setCategory(c);
 * dao.save(product); return new ModelAndView("redirect:/produtos/"); }
 * 
 * @RequestMapping(value="edit", method=RequestMethod.GET) public ModelAndView
 * edit(Integer productId) { Product product = dao.find(productId);
 * 
 * List<Category> categories = categoryDao.index(null);
 * 
 * ModelAndView modelAndView = new ModelAndView("product/edit");
 * modelAndView.addObject("categories", categories);
 * modelAndView.addObject("product", product); return modelAndView; }
 * 
 * @RequestMapping(value="update", method=RequestMethod.POST) public
 * ModelAndView update(Product product, HttpServletRequest req) { String
 * categoryId = req.getParameter("categoryId");
 * System.out.println(product.getId()); int category =
 * Integer.parseInt(categoryId) ; Category c = categoryDao.find(category);
 * product.setCategory(c); dao.update(product); return new
 * ModelAndView("redirect:/produtos/"); }
 * 
 * @RequestMapping(value="delete", method=RequestMethod.GET) public ModelAndView
 * delete(Integer productId) { dao.delete(productId); return new
 * ModelAndView("redirect:/produtos/"); } }
 * 
 * 
 * }
 */