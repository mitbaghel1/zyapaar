package com.zpdemo.allRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zpdemo.entityModel.CategoryBo;
import com.zpdemo.entityModel.ImageBo;
import com.zpdemo.entityModel.InventoryDetailsBo;
import com.zpdemo.entityModel.ShopBo;
import com.zpdemo.entityModel.StockBo;

@Repository
public class InventoryRepository {
	
	@Autowired
	ShopRepo shopRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	StockRepo stockRepo;
	
	@Autowired
	ImageRepo imageRepo;
	
	@Transactional(rollbackOn = Exception.class)
	public StockBo createItems(InventoryDetailsBo bo)
	{
		ShopBo shopBo=new ShopBo();
		shopBo.setShop_name(bo.getShop_name());
		ShopBo saveBo=shopRepo.save(shopBo);
		
		CategoryBo catBo=new CategoryBo();
//		catBo.setCategory_id(bo.getCategory_id());
		catBo.setCategory_name(bo.getCategory_name());
		catBo.setCategory_status("1");
		catBo.setDate(new Date());
		CategoryBo catSaveBo=categoryRepo.save(catBo);
		
		StockBo stockBo=new StockBo();
		stockBo.setCategory_id(catBo.getCategory_id());
		stockBo.setShop_id(shopBo.getId());
		stockBo.setTotal_stock(bo.getTotal_stock());
		stockRepo.save(stockBo);
		
		return stockBo;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public int updateStatusItems(InventoryDetailsBo bo)
	{
		int k=categoryRepo.updateCategory(bo.getCategory_id().toString());
		
		return k;
	}
	@Transactional(rollbackOn = Exception.class)
	public InventoryDetailsBo getStockDetails(InventoryDetailsBo bo)
	{
		Map<String,String> inventoryDetailsBo=categoryRepo.getStockDetails(bo.getCategory_id());
		final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
		final InventoryDetailsBo pojo = mapper.convertValue(inventoryDetailsBo, InventoryDetailsBo.class);
		
		return pojo;
	}
	
	@Transactional(rollbackOn = Exception.class)
	public int removeStock(InventoryDetailsBo bo) throws Exception
	{
		int k=categoryRepo.removeCategory(bo.getCategory_id().toString());
		int l=stockRepo.removeStock(bo.getCategory_id().toString());
		if(l==1 && k==1)
			return k;
		else
			throw new Exception("Data is not delete");
	}
	
	public ImageBo saveImage(ImageBo bo) throws IOException
	{
		bo.setImages(bo.getFile().getBytes());
		return imageRepo.save(bo);
	}
	
	public List<StockBo> fetchstock()
	{
		return stockRepo.findAll();
	}
	
	
	
	
	
	
	
}
