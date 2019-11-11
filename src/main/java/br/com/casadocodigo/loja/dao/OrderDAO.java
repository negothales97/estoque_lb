package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Order;

@Repository
@Transactional
public class OrderDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Order> index(String searchString) {
		String name = searchString == null ? "%" : searchString.concat("%");
		return manager.createQuery("select c from Order o where c.name like :name").setParameter("name", name)
				.getResultList();
	}

	public void save(Order order) {
		manager.persist(order);
	}

	public Order find(Integer id) {
		return manager.find(Order.class, id);
	}

	public void delete(Integer id) {
		Order order = manager.find(Order.class, id);
		manager.remove(order);
	}

	public void update(Order order) {
		manager.merge(order);
	}
}
