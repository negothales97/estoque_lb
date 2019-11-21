package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Category;

@Repository
@Transactional
public class CategoryDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Category> index(String searchString) {
		String name = searchString == null ? "%" : searchString.concat("%");
		return manager.createQuery("select c from Category c where c.name like :name").setParameter("name", name)
				.getResultList();
	}

	public void save(Category category) {
		manager.persist(category);
	}

	public Category find(Integer id) {
		return manager.find(Category.class, id);
	}

	public void delete(Integer id) {
		Category category = manager.find(Category.class, id);
		manager.remove(category);
	}

	public void update(Category category) {
		manager.merge(category);
	}
}
