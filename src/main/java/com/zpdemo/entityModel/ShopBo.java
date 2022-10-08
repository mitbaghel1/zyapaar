package com.zpdemo.entityModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="dtl_shop")
public class ShopBo {

		@Id
//		@SequenceGenerator(name="pk_sequence",sequenceName="shop_seq", allocationSize=1)
//		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
		@GeneratedValue(generator="system-uuid")
		@GenericGenerator(name="system-uuid", strategy = "uuid")
		@Column(name="shop_id")
		private String id;
		
		@Column(name="shop_name")
		private String shop_name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getShop_name() {
			return shop_name;
		}

		public void setShop_name(String shop_name) {
			this.shop_name = shop_name;
		}
}
