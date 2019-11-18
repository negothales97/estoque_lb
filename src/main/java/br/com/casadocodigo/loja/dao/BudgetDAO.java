package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Budget;

@Repository
@Transactional
public class BudgetDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Budget> index() {
		return manager.createQuery("select o from Budget o", Budget.class)
				.getResultList();
	}

	public void save(Budget budget) {
		manager.persist(budget);
	}

	public Budget find(Integer id) {
		return manager.find(Budget.class, id);
	}

	public void delete(Integer id) {
		Budget budget = manager.find(Budget.class, id);
		manager.remove(budget);
	}

	public void update(Budget budget) {
		manager.merge(budget);
	}
}
