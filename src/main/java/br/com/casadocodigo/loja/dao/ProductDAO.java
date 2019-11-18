package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
@Transactional
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Product> index(String searchString) {
		String name = searchString == null ? "%" : searchString.concat("%");
		return manager.createQuery("select p from Product p where p.name like :name").setParameter("name", name)
				.getResultList();
	}

	public void save(Product product) {
		manager.persist(product);
	}

	public Product find(Integer id) {
		return manager.find(Product.class, id);
	}

	public void delete(Integer id) {
		Product product = manager.find(Product.class, id);
		manager.remove(product);

	}

	public void update(Product product) {
		manager.merge(product);
	}
}
