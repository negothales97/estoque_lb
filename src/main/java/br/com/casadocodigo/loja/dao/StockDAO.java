
package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Stock;

@Repository

@Transactional
public class StockDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Stock> index(String searchString) {
		String name = searchString == null ? "%" : searchString.concat("%");
		return manager.createQuery("select p from Stock p where p.name like :name").setParameter("name", name)
				.getResultList();
	}

	public void save(Stock stock) {
		manager.persist(stock);

	}

	public Stock find(Integer id) {
		return manager.find(Stock.class, id);

	}

	public void delete(Integer id) {
		Stock product = manager.find(Stock.class, id);
		manager.remove(product);

	}

	public void update(Stock stock) {
		manager.merge(stock);
	}
}
