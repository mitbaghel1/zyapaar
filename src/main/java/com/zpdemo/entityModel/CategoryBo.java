package com.zpdemo.entityModel;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="dtl_category")
public class CategoryBo {
	
	@Id
//	@SequenceGenerator(name="pk_sequence",sequenceName="category_seq", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
//	@Lob
//	@Type(type = "org.hibernate.type.TextType")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="category_id")
	private String category_id;
	
	@Column(name="category_name")
	private String category_name;
	
	@Column(name="category_status")
	private String category_status;

	@Column(name="crt_date")
	private Date date;
	
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_status() {
		return category_status;
	}

	public void setCategory_status(String category_status) {
		this.category_status = category_status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
