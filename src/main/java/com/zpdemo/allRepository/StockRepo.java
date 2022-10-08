package com.zpdemo.allRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zpdemo.entityModel.StockBo;

public interface StockRepo extends JpaRepository<StockBo, String>{

	
	@Modifying
	@Query("delete StockBo where category_id=?1")
	public int removeStock(String catId);
}
