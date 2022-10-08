package com.zpdemo.entityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dtl_stock")
public class StockBo {

	@Id
//	@SequenceGenerator(name="pk_sequence",sequenceName="stock_seq", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="stock_id")
	private String stock_id;
	
	@Column(name="category_id")
	private String category_id;
	
	@Column(name="shop_id")
	private String shop_id;
	
	@Column(name="total_stock")
	private String total_stock;
	
	public String getTotal_stock() {
		return total_stock;
	}

	public void setTotal_stock(String total_stock) {
		this.total_stock = total_stock;
	}

	public String getStock_id() {
		return stock_id;
	}

	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getShop_id() {
		return shop_id;
	}

	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}


	
}
