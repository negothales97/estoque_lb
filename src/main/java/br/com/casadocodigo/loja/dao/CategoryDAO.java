package br.com.casadocodigo.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.conf.DatabaseConnection;
import br.com.casadocodigo.loja.models.Category;

@Repository
@Transactional
public class CategoryDAO {

	@PersistenceContext
	private EntityManager manager;

	private final String SEARCH = "SELECT id, name from category WHERE name LIKE ?";
	private final String INSERT = "INSERT INTO category (name) values (?)";
	private final String UPDATE = "UPDATE category SET name=? WHERE id=?";
	private final String DELETE = "DELETE FROM category WHERE id=?";
	private final String FINDBYID = "SELECT id, name FROM category WHERE ID = ?";

	public List<Category> index(String search) throws SQLException {
		List<Category> categories = new ArrayList<>();
		String searchName = search == null ? "%" : search.concat("%");
		try (Connection con = DatabaseConnection.getInstance().getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SEARCH);
			stmt.setString(1, searchName);
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category category = new Category();
				category.setName(name);
				category.setId(id);
				categories.add(category);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categories;
	}

	public void save(Category category) throws SQLException {
		try (Connection con = DatabaseConnection.getInstance().getConnection()) {

			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setString(1, category.getName());
			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(Category category) throws SQLException {
		try (Connection con = DatabaseConnection.getInstance().getConnection()) {

			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, category.getName());
			stmt.setInt(2, category.getId());

			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int id) throws SQLException {
		try (Connection con = DatabaseConnection.getInstance().getConnection()) {

			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, id);
			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Category find(Integer id) {
		return manager.find(Category.class, id);
	}
//	public List<Category> index(String searchString) {
//		String name = searchString == null ? "%" : searchString.concat("%");
//		return manager.createQuery("select c from Category c where c.name like :name").setParameter("name",name).getResultList();
//	}

//	public void save(Category category) {
//		manager.persist(category);
//	}
//

//
//	public void delete(Integer id) {
//		Category category = manager.find(Category.class, id);
//		manager.remove(category);
//	}
//
//	public void update(Category category) {
//		manager.merge(category);
//	}
}
