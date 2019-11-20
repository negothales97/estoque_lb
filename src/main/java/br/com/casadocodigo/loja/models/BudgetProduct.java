package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BudgetProduct {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int qtd;
	private double price;
	private double total;
	
	@ManyToOne
	@JoinColumn(name="budget_id")
	private Budget budget;
	
	@ManyToOne
	private Product product;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Quantidade: " + getQtd());
		sb.append("Preco: " + getPrice());
		sb.append("Total: " + getTotal());
		sb.append("Produto: " + getProduct());
		return sb.toString();
	}

	
}
