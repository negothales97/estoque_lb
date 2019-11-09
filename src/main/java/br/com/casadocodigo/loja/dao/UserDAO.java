package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.User;

@Repository
@Transactional
public class UserDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<User> index(String searchString) {
		String name = searchString == null ? "%" : searchString.concat("%");
		return manager.createQuery("select u from User u where u.name like :name").setParameter("name", name).getResultList();
	}

	public void save(User user) {
		manager.persist(user);
	}

	public User find(Integer id) {
		return manager.find(User.class, id);
	}

	public void delete(Integer id) {
		User user = manager.find(User.class, id);
		manager.remove(user);
	}

	public void update(User user) {
		manager.merge(user);
	}
}
