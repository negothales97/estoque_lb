package br.com.casadocodigo.loja.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Budget {
	
	private int id;
	private double total;

	private User user;
	
//	@OneToMany(mappedBy = "budget")
//	private Set<BudgetProduct> budgetProducts;
//	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
//	public Set<BudgetProduct> getBudgetProducts() {
//		return budgetProducts;
//	}
//	public void setBudgetProducts(Set<BudgetProduct> budgetProducts) {
//		this.budgetProducts = budgetProducts;
//	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Usuário: " + getUser());
		sb.append("Total: " + getTotal());
		return sb.toString();
	}
}
