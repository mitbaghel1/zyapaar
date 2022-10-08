package com.zpdemo.serviceImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpdemo.allRepository.InventoryRepository;
import com.zpdemo.entityModel.CategoryBo;
import com.zpdemo.entityModel.ImageBo;
import com.zpdemo.entityModel.InventoryDetailsBo;
import com.zpdemo.entityModel.StockBo;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository; 
	
	public Map<String,Object> createItems(InventoryDetailsBo bo)
	{
		Map<String,Object> returnMap=new HashMap<String,Object>();
		StockBo stockBo= inventoryRepository.createItems(bo);
		if(stockBo != null && stockBo.getStock_id() != null)
		{
			returnMap.put("msg", "SUCCESS");
		}
		return returnMap; 
	}
	
	public Map<String,Object> updateStatusItems(InventoryDetailsBo bo)
	{
		Map<String,Object> returnMap=new HashMap<String,Object>();
		int k= inventoryRepository.updateStatusItems(bo);
		if(k != 0)
		{
			returnMap.put("msg", "SUCCESS");
		}
		return returnMap; 
	}
	
	public Map<String,Object> removeStock(InventoryDetailsBo bo) throws Exception
	{
		Map<String,Object> returnMap=new HashMap<String,Object>();
		int k= inventoryRepository.removeStock(bo);
		if(k != 0)
		{
			returnMap.put("msg", "SUCCESS");
		}
		return returnMap; 
	}
	
	//
	public InventoryDetailsBo getStockDetails(InventoryDetailsBo bo)
	{
		return inventoryRepository.getStockDetails(bo);
	}
	
	public Map<String,Object> saveImage(ImageBo bo) throws IOException
	{
		Map<String,Object> returnMap=new HashMap<String,Object>();
		ImageBo bosave= inventoryRepository.saveImage(bo);
		if(bo != null)
		{
			returnMap.put("msg", "SUCCESS");
		}
		return returnMap; 
	}
	
	public List<StockBo> fetchstock()
	{
		return inventoryRepository.fetchstock();
	}
	
}
