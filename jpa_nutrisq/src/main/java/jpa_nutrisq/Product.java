package jpa_nutrisq;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private int idProduct;

	private int calories;

	private int carbs;

	private int fats;

	private int fiber;

	private String name;

	private int protein;

	private int weight;

	public Product() {
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getCalories() {
		return this.calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getCarbs() {
		return this.carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getFats() {
		return this.fats;
	}

	public void setFats(int fats) {
		this.fats = fats;
	}

	public int getFiber() {
		return this.fiber;
	}

	public void setFiber(int fiber) {
		this.fiber = fiber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProtein() {
		return this.protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}