package com.zpdemo.allRepository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zpdemo.entityModel.CategoryBo;
import com.zpdemo.entityModel.InventoryDetailsBo;

public interface CategoryRepo extends JpaRepository<CategoryBo,String> {

	
	@Modifying
	@Query("update CategoryBo set category_status='0' where category_id=?1")
	public int updateCategory(String catId);
	
	@Modifying
	@Query("delete CategoryBo where category_id=?1")
	public int removeCategory(String catId);
	
	@Query(value = "select\r\n"
			+ "        a1.category_name,\r\n"
			+ "        a1.category_id,\r\n"
			+ "        c1.shop_name,\r\n"
			+ "        b.total_stock \r\n"
			+ "    from\r\n"
			+ "        dtl_category a1 left join  dtl_stock b on  a1.category_id=b.category_id\r\n"
			+ "        left join  dtl_shop c1 on b.shop_id=c1.shop_id where a1.category_id=?1",nativeQuery = true)
	public Map<String,String> getStockDetails(String catId);
}
