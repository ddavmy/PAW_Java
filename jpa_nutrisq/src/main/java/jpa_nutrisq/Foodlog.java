package jpa_nutrisq;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the foodlog database table.
 * 
 */
@Entity
@NamedQuery(name="Foodlog.findAll", query="SELECT f FROM Foodlog f")
public class Foodlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_foodLog;

	@Temporal(TemporalType.DATE)
	private Date entryDate;

	@Column(name="id_group")
	private int idGroup;

	@Column(name="id_product")
	private int idProduct;

	private int weight;

	public Foodlog() {
	}

	public int getId_foodLog() {
		return this.id_foodLog;
	}

	public void setId_foodLog(int id_foodLog) {
		this.id_foodLog = id_foodLog;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}