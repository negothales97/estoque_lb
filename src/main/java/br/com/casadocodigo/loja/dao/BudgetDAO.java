package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Budget;
import br.com.casadocodigo.loja.models.BudgetProduct;

@Repository
@Transactional
public class BudgetDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Budget> index() {
		return manager.createQuery("select o from Budget o", Budget.class).getResultList();
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

	public void includeProduct(BudgetProduct budgetProduct) {
		manager.persist(budgetProduct);
	}

	public List<BudgetProduct> findBudgetProducts(Budget budget) {
		return manager
				.createQuery("select o from BudgetProduct o where o.budget = " + budget.getId(), BudgetProduct.class)
				.getResultList();
	}

	public void removeProduct(Integer budgetProductId) {
		BudgetProduct bProduct = manager.find(BudgetProduct.class, budgetProductId);
		Budget b = bProduct.getBudget();
		manager.remove(bProduct);
		
		Double newTotalBudget = this.getTotalBudget(b.getId());
		b.setTotal(newTotalBudget);
		this.update(b);
	}

	public Double getTotalBudget(Integer IdBudget) {
		return (Double) manager.createQuery("select sum(b.total) from BudgetProduct b where b.budget = " + IdBudget)
				.getSingleResult();
	}

}
